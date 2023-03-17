package com.iSpanProject.GoodByeletter.controller.Jerry;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Controller
@RequestMapping("/ECPay")
public class ECPayController {
	private static AllInOne all = new AllInOne("");

	// 跳頁，進入金流頁面。
	@GetMapping("")
	public String donatePage(Model model) {
		return "Jerry/LastNoteDonate";
	}

	// 接收回傳斗內金額葉面。
	@GetMapping("/ThankYou")
	public String thankPage(Model model) {
		return "Jerry/LastNoteDonate";
	}
	
	//送出表單請求到綠界科技
	@GetMapping(value = "/ECPayServer", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String processPayment(HttpServletRequest request, HttpServletResponse response) {
		String form = genAioCheckOutALL(request);
		return form;
	}

	private String genAioCheckOutALL(HttpServletRequest request) {
		AioCheckOutALL obj = new AioCheckOutALL();

		obj.setMerchantTradeNo(String.format("GoodBye Letter.iii%d", new Date().getTime()));
		obj.setMerchantTradeDate(String.format("%tY/%<tm/%<td %<tH:%<tM:%<tS", new Date())); 
		obj.setTotalAmount(request.getParameter("TotalAmount"));
		obj.setTradeDesc(request.getParameter("TradeDesc")); 
		obj.setItemName(request.getParameter("ItemName")); 
		obj.setNeedExtraPaidInfo("N");

		// ***付款結果通知我們伺服端的方式(可二選一)***//
		// A.以Server端(綠界)方式直接回傳付款結果通知
		obj.setReturnURL("https://220.133.103.95/ecpay/ECPayServer2");
		// 當消費者付款完成後，綠界會將付款結果參數以幕後(Server POST)回傳到該網址(該網址須是一個固定IP且使用https協定)。
		// 必設欄位。但我們可以忽略相關的後續處理作業。
		// B.以Client端(消費者)方式回傳付款結果通知
		obj.setOrderResultURL("http://localhost:8080/index/ECPay/ThankYou");
		// 當消費者付款完成後，綠界會將付款結果參數以幕前(Client POST)回傳到該網址。
		// 若與下面[ClientBackURL]同時設定，將會以此參數為主。
		// ********************************//

		// obj.setClientBackURL("http://localhost:8080/ecpay/ECPayServer3");
		// 綠界付款成功畫面會增加「返回商店」按鈕，消費者點選此按鈕後，會將頁面導回到此設定的網址
		// (注意：導回時不會帶付款結果到此網址，只是將頁面(以GET方法)導回而已。)

		String form = all.aioCheckOut(obj, null);
		return form;
	}
}
