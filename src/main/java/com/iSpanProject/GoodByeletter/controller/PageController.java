package com.iSpanProject.GoodByeletter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@GetMapping("/")
	public String home() {	
			return "index";
	}

	@GetMapping("/myregister")
	public String myregister() {
		return "example/myregister";
	}

	@GetMapping("/mycompany")
	public String mycompany() {
		return "example/mycompany";
	}

	@GetMapping("/myspace")
	public String myspace() {
		return "example/myspace";
	}
	

}
