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
	public String myNav() {
		return "/mynav";
	}

	@GetMapping("/myregister")
	public String myregister() {
		return "example/myregister";
	}

	@GetMapping("/mycompany")
	public String mycompany() {
		return "mycompany";
	}

	@GetMapping("/myspace")
	public String myspace() {
		return "myspace";
	}
	
	@GetMapping("/LastNote")
	public String lastNote() {
		return "Jerry/LastNote";
	}
}
