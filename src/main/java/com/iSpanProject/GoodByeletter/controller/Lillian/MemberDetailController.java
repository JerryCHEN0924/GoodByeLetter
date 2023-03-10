package com.iSpanProject.GoodByeletter.controller.Lillian;


import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;
import com.iSpanProject.GoodByeletter.service.Lillian.RegisterService;

@Controller
@SessionAttributes({"existing","authenticated"})
public class MemberDetailController {

	@Autowired
	private MemberDetailService memberDetailService;
	@Autowired
	private RegisterDao registerDao;

	@Autowired
	private RegisterService registerService;

//註冊會員資料
	@PostMapping("/MemberDetail/add2")
	public String saveMemberDetail(@RequestParam(value = "name") String name,
			@RequestParam(value = "gender") String gender,
			@RequestParam(value = "birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
			@RequestParam(value = "email") String email, @RequestParam(value = "county") String county,
			@RequestParam(value = "address") String address, @RequestParam(value = "memberId") Integer memberId,
			Model model) {

		MemberDetail newMemberDetail = new MemberDetail();
		newMemberDetail.setName(name);
		newMemberDetail.setGender(gender);
		newMemberDetail.setBirthday(birthday);
		newMemberDetail.setEmail(email);
		newMemberDetail.setCounty(county);
		newMemberDetail.setAddress(address);
		/////////////////////
		Register register = registerService.findById(memberId);
		newMemberDetail.setFK_memberId(register);
		///////////////////////
		memberDetailService.insert(newMemberDetail);
		Map<String, String> msg = new HashMap<String, String>();
		model.addAttribute("msg", msg);
		msg.put("success", "會員註冊成功!");

		return "redirect:/";
	}


//編輯會員資料
	@GetMapping("/memberDetail/edit")
	public String editMemberDetailPage(@RequestParam Integer memberId, Model model) throws ParseException {// model儲存送過去

		MemberDetail memberDetails=memberDetailService.findByMemberId(memberId);
		
		if(memberDetails == null){
			MemberDetail md = new  MemberDetail();
			model.addAttribute("memberDetails", md);
			
			return "Lillian/MemberDetailEdit";
		}
		//////時間轉換///////////
//		Date memberBirthday=memberDetails.getBirthday();
//		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
//		String memberBirthdayString=format.format(memberBirthday);
//		Date memberBirthdayNewType=format.parse(memberBirthdayString);
//		memberDetails.setBirthday(memberBirthdayNewType);
		
		model.addAttribute("memberDetails", memberDetails);


		return "Lillian/MemberDetailEdit";

	}

	@PutMapping("/memberDetail/putMemberDetail")
	public String updateMemberDetailEdit(@ModelAttribute("memberDetail") MemberDetail memberDetail,HttpServletRequest request,Model model) {
		Register registerNew =(Register)model.getAttribute("existing");

		
		Integer memberId = registerNew.getMemberId();
		Register currentRegister = registerService.findById(memberId);

		
		memberDetail.setFK_memberId(currentRegister);
		memberDetail.setFK_Plevel(currentRegister.getFK_Plevel());
		
		
		memberDetailService.updateMemberDetail(memberDetail);

		return "redirect:/";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/addRegister")
//	public String addRegister(@ModelAttribute("memberDetails") MemberDetail memberDetail,  Model model,HttpSession sessions) {		
//		Register op = (Register)model.getAttribute("existing");
//		registerService.getRegisterById(op.getMemberId());
//		
//		
//		return "redirect:/";
//	}
//	
//	@GetMapping("/register/memberDetail")
//	public String MemberDetailDaoPage(Model model) {		
//		MemberDetail m1 = new MemberDetail();	
//		model.addAttribute("memberDetails", m1);
//		return "Lillian/addMemberDetail";
//	}
}