package com.iSpanProject.GoodByeletter.controller.YiJie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.iSpanProject.GoodByeletter.model.YiJie.YJMessages;
import com.iSpanProject.GoodByeletter.service.YiJie.YJMessageService;

@Controller
public class YJMessageController {

	@Autowired
	private YJMessageService mService;
	
	@GetMapping("/message/add") //抓addMessage.jsp表單資料的控制器
	public String addMessagePage(Model model) {
		YJMessages messages = new YJMessages();
		model.addAttribute("messages", messages);
		
		return "messages/addMessage"; //跳頁回原頁
	}
	
	@PostMapping("/message/post")
	public String addMessagePost(@ModelAttribute YJMessages msg, Model model) {
		mService.insert(msg);//請service幫忙寫入資料
		YJMessages messages = new YJMessages();
		model.addAttribute("messages", messages);		
		
		return "messages/addMessage";
	}
	
}
