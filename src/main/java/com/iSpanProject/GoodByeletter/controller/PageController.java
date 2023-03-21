package com.iSpanProject.GoodByeletter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
	
	
	@GetMapping("/")
	public String home() {	
		return "index";
	}

	@GetMapping("/mynav")
	public String newnav() {
		return "layout/mynav";
	}

}
