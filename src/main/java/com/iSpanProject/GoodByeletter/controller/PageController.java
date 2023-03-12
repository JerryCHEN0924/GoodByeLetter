package com.iSpanProject.GoodByeletter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/oldindex")
	public String newhome() {
		return "oldindex";
	}
@GetMapping("/newnav")
public String newnav() {
	return "layout/newmynav";
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
