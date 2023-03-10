package com.iSpanProject.GoodByeletter.controller.YiJie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.YiJie.PictureDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;

@Controller
@SessionAttributes("exis")
public class PictureController {

	@Autowired
	private YJCustomerDetailService detailService;
	
	@Autowired
	private PictureDao pDao;
	
	//圖片頁面
	@GetMapping("/picture/page1")
	public String picturePage1() {
		return "YiJie/updatePic";
	}
	//回廠商主頁面
	@GetMapping("/companylogig/page")
	public String backPage() {
		return "YiJie/companylogin";
	}
	//圖片上傳
	
	
	////////////////////////////////////
	public void abcd (Model model) {
		//抓session物件  mvc6-3前半小時
		Register res = (Register) model.getAttribute("exis");
		
		
	}
	
	
}
