package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;

@Controller
public class LastNoteController {
	@GetMapping("/LastNote")
	public String note(Model model) {
		//MemberDetail memberdetail = new MemberDetail();
		return "LastNote";
	}
}
