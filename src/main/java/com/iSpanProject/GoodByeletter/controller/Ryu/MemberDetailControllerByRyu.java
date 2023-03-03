package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.iSpanProject.GoodByeletter.model.Ryu.MemberDetailByRyu;
import com.iSpanProject.GoodByeletter.service.Ryu.MemberDetailServiceByRyu;
import com.iSpanProject.GoodByeletter.validate.MemberValidator;


@Controller
// @PropertySource("classpath:ValidationMessages_zh_TW.properties")
public class MemberDetailControllerByRyu {
	
	
	
	@Autowired
	public MemberDetailServiceByRyu memberDetailServiceByRyu;
	
	
	
	
	@GetMapping("/topGun/memberDetailByRyu/add")
	public String addNewMemberDetailForm(Model model) {
		
		MemberDetailByRyu memberDetailByRyu = new MemberDetailByRyu();
		model.addAttribute("memberDetailByRyu", memberDetailByRyu);
		
		return "/Ryu/ryuzAddMemberDetail";
		
	}
	
	
	@PostMapping("/topGun/memberDetailByRyu/post")
	public String insertMemberDetailData(@ModelAttribute("memberDetailByRyu") MemberDetailByRyu memberDetailByRyu, BindingResult bindingResult) {
		
		new MemberValidator().validate(memberDetailByRyu, bindingResult);
		System.out.println("新增客戶: " + memberDetailByRyu);
		
		
		if (bindingResult.hasErrors()) {
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			
			System.out.println("======================");
			return "/Ryu/ryuzAddMemberDetail";
			
		}
		
		System.out.println("bean==>" + memberDetailByRyu);
		
//		memberDetailByRyu.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		
		
		memberDetailServiceByRyu.insert(memberDetailByRyu);
		
		return "redirect:/topGun";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// java.util.Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		dateFormat.setLenient(false);
		CustomDateEditor ce = new CustomDateEditor(dateFormat, true); 
		binder.registerCustomEditor(Date.class, ce);
		// java.sql.Date		
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat2.setLenient(false);
		CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true); 
		binder.registerCustomEditor(java.sql.Date.class, ce2);
	}
	
	
	
	
	
	
	


}
