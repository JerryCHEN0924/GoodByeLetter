package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;

@Controller
public class BackendPageController {
	
	
	@GetMapping("/topGun")
	public String backendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
	
	
	@GetMapping("/topGun/template")
	public String template(Model model) {
		
		MemberByRyu m1 = new MemberByRyu();
		model.addAttribute("memberByRyu", m1);
		
		return "/Ryu/ryuzMainTemplate";
		
	}
	
	
	
	
	
	
	
}
