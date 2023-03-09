package com.iSpanProject.GoodByeletter.controller.YiJie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;

@Controller
public class PictureController {

	@Autowired
	private YJCustomerDetailService detailService;
	
	
	//圖片功能頁面
	@GetMapping("/picture/page1")
	public String picturePage1() {
		return "YiJie/updatePic";
	}
	
}
