package com.iSpanProject.GoodByeletter.controller.Tina.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatWebSocketController {
	
	@RequestMapping("/wschat")
	public String wschat(){
		return "Tina/wsChat";
	}

}
