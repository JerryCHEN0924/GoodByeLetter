package com.iSpanProject.GoodByeletter.controller.Jerry;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// 付款完成後綠界導回來，處理回傳的內容。
	@PostMapping(value = "/ThankYou", produces = "text/html;charset=utf-8") // 預設response的字元編碼為ISO-8859-1
	public String processPaymentResult2(HttpServletRequest request, Model model) {

		Hashtable<String, String> dict = new Hashtable<String, String>();
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String paramName = enumeration.nextElement();
			String paramValue = request.getParameter(paramName);
			dict.put(paramName, paramValue);
		}
		// 輸出範例：
		// 【ECPayServer3.java】用戶端付款成功後回傳「付款結果」通知給伺服端的參數們：
		// {CheckMacValue=028D288F5CB566EB1FA5E204FA46B6FC68AB3ED68EC12AE17E561A6A9AF885F5,
		// TradeDate=2021/08/31 11:09:08, TradeNo=2108311109087900, MerchantID=2000132,
		// PaymentTypeChargeFee=21, PaymentType=Credit_CreditCard, TradeAmt=1050,
		// RtnMsg=Succeeded, StoreID=, CustomField4=,
		// MerchantTradeNo=III1630379348465, CustomField3=,
		// PaymentDate=2021/08/31 11:10:23, SimulatePaid=0, CustomField2=,
		// CustomField1=, RtnCode=1}

		boolean checkStatus = all.compareCheckMacValue(dict); // true：表示資料未被竄改
		// 消費者付款成功且檢查碼正確的時候： (RtnCode:交易狀態(1:成功，其餘為失敗))
		if ("1".equals(dict.get("RtnCode")) && checkStatus == true) {
			// ---------------------------//
			// 在此撰寫你的處理邏輯
			
			
			
			// ---------------------------//
			
			// 回應用戶端(付款者)
			
			
			model.addAttribute("paymentSuccess", dict);
			return "Jerry/ThankYou";
		} else {
			model.addAttribute("paymentFail", dict);
			return "Jerry/ThankYou";
		}
	}

	// 接收送出的表單，再將表單送綠界科技
	@PostMapping(value = "/ECPayServer", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String processPayment(HttpServletRequest request, HttpServletResponse response) {
		String form = genAioCheckOutALL(request);
		return form;
	}

	private String genAioCheckOutALL(HttpServletRequest request) {
		AioCheckOutALL obj = new AioCheckOutALL();

		obj.setMerchantTradeNo(String.format("iii%d", new Date().getTime()));
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
