package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackendPageController23456 {
	
	
	@GetMapping("/topGun")
	public String backendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
	
	
	@GetMapping("/topGun/template")
	public String template() {
		
		return "/Ryu/ryuzTemplate";
		
	}
	
	
}
