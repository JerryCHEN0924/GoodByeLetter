package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackendPageController {
	
	
	@GetMapping("/topGun")
	public String backendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
	
	
	@GetMapping("/topGun/template")
	public String template() {
		
		return "/Ryu/ryuzSubTemplate";
		
	}
	
	
	@GetMapping("/topGun/member/add")
	public String addMember() {
		
		return "/Ryu/ryuzAddMember";
		
	}
	
	
	
	
}
