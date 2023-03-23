package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.service.Jerry.VerifyService;

@Controller
@RequestMapping("/LastNote")
public class VerifyController {

	@Autowired
	private VerifyService vs;

	// 跳頁，測試頁面
	@GetMapping("/test")
	public String LastNoteTestPage() {
		
		return "Jerry/LastNoteTestPage";
	}

	// 跳頁，驗證失敗頁面
	@GetMapping("/VerifyFail")
	public String VerifyFailPage() {
		return "Jerry/VerifyFailPage";
	}

	// 跳頁，驗證成功頁面
	@GetMapping("/VerifySuccess")
	public String VerifySuccessPage() {
		return "Jerry/VerifySuccessPage";
	}

	// 驗證信的TOKEN檢查
	@GetMapping("/verify")
	public String verifyToken(@RequestParam("code") String token, Model model) {
		boolean verify = vs.checkToken(token);
		// 如果Token驗證成功，導向驗證成功頁面
		if (verify) {
			return "redirect:/LastNote/VerifySuccess";
		} else {
			// 如果Token驗證失敗，導向驗證失敗頁面。
			return "redirect:/LastNote/VerifyFail";
		}
	}

}
