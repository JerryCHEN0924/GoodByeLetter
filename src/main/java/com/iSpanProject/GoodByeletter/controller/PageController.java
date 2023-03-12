package com.iSpanProject.GoodByeletter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String home(@RequestParam(name="code", required = false) String code, Model model) {
		if(code==null)
			return "index";
		else {
			model.addAttribute("code",code);
			return "Lillian/resetPwd";
		}
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
