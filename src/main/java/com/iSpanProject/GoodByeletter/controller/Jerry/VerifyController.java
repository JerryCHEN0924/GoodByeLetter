package com.iSpanProject.GoodByeletter.controller.Jerry;

import org.jasypt.encryption.StringEncryptor;
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

	@Autowired
	private StringEncryptor stringEncryptor;

	// 跳頁，測試頁面
	@GetMapping("/test")
	public String LastNoteTestPage() {
		
		//加密
//		String text = "我是一條魚";
//		System.out.println("=========");
//		System.out.println("明文:"+text);
//		System.out.println("=========");
//		String encrypt = stringEncryptor.encrypt(text);
//		System.out.println("=========");
//		System.out.println("加密:"+encrypt);
//		System.out.println("=========");
//		String decrypt = stringEncryptor.decrypt("Gum+x8Ds4RDyyU8LNHwZJzX/DVW5BMK3cJNY3L6n/6cC3bJKGb+9XyJ7BwBc6ww0p3Ngf9tFSPc=");
//		System.out.println("=========");
//		System.out.println("解密:"+decrypt);
//		System.out.println("=========");
		
		
		//加密結束
		
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
		// 如果Token驗證成功，導向編輯頁面(這邊可考慮做一個頁面告知驗證成功，驗證日已經往後推移6個月請登入確認，再跳轉到首頁。)
		if (verify) {
			return "redirect:/LastNote/VerifySuccess";
		} else {
			// 如果Token驗證失敗，導向驗證失敗頁面。
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
