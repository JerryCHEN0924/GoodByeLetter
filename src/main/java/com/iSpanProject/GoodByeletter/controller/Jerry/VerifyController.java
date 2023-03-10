package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;

@Controller
public class VerifyController {

	@Autowired
	private LastnoteService lastnoteService;
	
	// 跳頁，測試頁面	
	@GetMapping("/LastNote/test")
	public String LastNoteTestPage() {
		return "Jerry/LastNoteTestPage";
	}
	
	// 跳頁，驗證信功能測試	
	@GetMapping("/LastNote/sendVerificationEmail")
	public String LastNoteTestSendMail() {
		lastnoteService.sendVerificationEmail();
		return "redirect:/LastNote/test";
	}
	
	// 驗證信的TOKEN檢查
	@GetMapping("/LastNote/verify")
	public String verifyToken(@RequestParam("code") String token,Model model) {
		System.out.println(token);
		lastnoteService.checkToken(token);
		return "redirect:/";
	}
	
	
	
}
