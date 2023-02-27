package com.iSpanProject.GoodByeletter.controller.Lillian;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberDetailService memberDetailService;
	
	
	@PostMapping("/MemberDetail/add2")
	public String saveMemberDetail(@RequestParam(value="name") String name,@RequestParam(value="gender") 
	String gender,@RequestParam(value="birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,@RequestParam(value="email") String email,@RequestParam(value="county")
	String county,@RequestParam(value="address") String address, Model model) {
		
		MemberDetail newMemberDetail = new MemberDetail();
		newMemberDetail.setName(name);
		newMemberDetail.setGender(gender);
		newMemberDetail.setBirthday(birthday);
		newMemberDetail.setEmail(email);
		newMemberDetail.setCounty(county);
		newMemberDetail.setAddress(address);
		
		memberDetailService.insert(newMemberDetail);
		   Map<String, String> msg = new HashMap<String, String>();
		   model.addAttribute("msg", msg);
		   msg.put("success", "會員註冊成功!");
		
	
			return "example/addMemberDetail";		
	}
	
	@GetMapping("register/memberDetail")
	public String MemberDetailDaoPage() {		
		return "example/addMemberDetail";
	}
}
