package com.iSpanProject.GoodByeletter.controller.Jerry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.service.Jerry.LastnoteService;
import com.iSpanProject.GoodByeletter.service.Jerry.VerifyService;

@Controller
public class VerifyController {

	@Autowired
	private VerifyService vs;
	@Autowired
	private LastnoteService ls;
	
	// 跳頁，測試頁面	
	@GetMapping("/LastNote/test")
	public String LastNoteTestPage() {
		vs.sendUserGoodByeLetter();
		return "Jerry/LastNoteTestPage";
	}
	
	// 跳頁，驗證失敗頁面	
	@GetMapping("/LastNote/VerifyFail")
	public String VerifyFailPage() {
		return "Jerry/VerifyFailPage";
	}
	
	// 跳頁，驗證成功頁面	
	@GetMapping("/LastNote/VerifySuccess")
	public String VerifySuccessPage() {
		return "Jerry/VerifySuccessPage";
	}
	
	// 驗證信的TOKEN檢查
	@GetMapping("/LastNote/verify")
	public String verifyToken(@RequestParam("code") String token,Model model) {
		boolean verify = vs.checkToken(token);
		//如果Token驗證成功，導向編輯頁面(這邊可考慮做一個頁面告知驗證成功，驗證日已經往後推移6個月請登入確認，再跳轉到首頁。)
		if(verify) {
			return "redirect:/LastNote/VerifySuccess";
		}else {
			//如果Token驗證失敗，導向驗證失敗頁面。
			return "redirect:/LastNote/VerifyFail";
		}
	}
	
	
//	// 跳頁，驗證信功能測試	
//	@GetMapping("/LastNote/sendVerificationEmail")
//	public String LastNoteTestSendMail() {
//		lastnoteService.sendVerificationEmail();
//		return "redirect:/LastNote/test";
//	}
	
}
