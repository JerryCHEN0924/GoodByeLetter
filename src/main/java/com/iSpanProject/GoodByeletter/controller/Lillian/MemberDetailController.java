package com.iSpanProject.GoodByeletter.controller.Lillian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Lillian.MemberDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberDetailDao memberDetailDao;
	
	@ResponseBody
	@PostMapping("/MemberDetail/add2")
	public MemberDetail saveMemberDetail(@RequestBody String name,@RequestBody String gender,@RequestBody String birthday,@RequestBody String email,@RequestBody String county,@RequestBody String address) {
			return null;	
//		return memberDetailDao.save(name);		
	}
	
	@GetMapping("register/memberDetail")
	public String MemberDetailDaoPage(Model model) {
		MemberDetail memberDetail = new MemberDetail();
		model.addAttribute("memberDetail",memberDetail);
		
		return "example/addMemberDetail";
	}
}
