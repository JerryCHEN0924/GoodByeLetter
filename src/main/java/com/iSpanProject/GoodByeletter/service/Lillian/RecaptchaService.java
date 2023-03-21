//package com.iSpanProject.GoodByeletter.service.Lillian;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import com.iSpanProject.GoodByeletter.model.Lillian.RecaptchaResponse;
//
//@Service
//public class RecaptchaService {
//
//	@Value("${google.recaptcha.key.site}")
//	private String recaptchaSiteKey;
//
//	@Value("${google.recaptcha.key.secret}")
//	private String recaptchaSecretKey;
//
//	@Value("${google.recaptcha.api.url}")
//	private String recaptchaApiUrl;
//	
//
//	public boolean verifyRecaptcha(String ip,String response1) {//接收一個 IP 地址和一個 reCAPTCHA 驗證回應作為輸入參數
//		RestTemplate restTemplate = new RestTemplate();//使用 RestTemplate 進行 HTTP POST 請求，並將 reCAPTCHA 驗證回應傳遞到 Google reCAPTCHA API 進行驗證
//
//		//ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();//創建了一個 MultiValueMap 對象，用於存儲 POST 請求中的參數
//		bodyMap.add("secret", recaptchaSecretKey);//添加了 reCAPTCHA 密鑰
//		bodyMap.add("response", response1);//驗證回應//就是token
//		//bodyMap.add("remoteip", ip);//用戶 IP 地址到 MultiValueMap 
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		//用於設置 POST 請求的 Content-Type
////		String url = "https://www.google.com/recaptcha/api/siteverify"
////		        + "?secret=" + recaptchaSecretKey
////		        + "&response=" + response1;
////		        // + "&remoteip=" + ip; // 如果需要包含用戶的IP地址，請取消註釋此行
//
//		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);
//		//建了一個 HttpEntity 對象，將 MultiValueMap 和 HttpHeaders 對象作為輸入參數傳遞給它
//		
//		RecaptchaResponse recaptchaResponse = new RecaptchaResponse();	
////		RecaptchaResponse apiResponse = restTemplate.postForObject(recaptchaApiUrl, url,
////				RecaptchaResponse.class);
//		String apiResponse = restTemplate.postForObject(recaptchaApiUrl, bodyMap, String.class);
//		
//		if(apiResponse == null) {
//			return false;
//		}
//		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
//		//System.out.println(apiResponse.isSuccess());
//		System.out.println(apiResponse);
//		System.out.println(recaptchaSiteKey);
//		System.out.println(recaptchaSecretKey);
//		System.out.println(recaptchaApiUrl);
//		System.out.println(response1);
//		System.out.println(RecaptchaResponse.class);
//		//System.out.println(apiResponse.errorCodes);
//		System.out.println(String.class);
//		System.out.println(String.class);
//		return false;
//		
//		//方法使用 RestTemplate 的 postForObject() 方法向 reCAPTCHA API 發送 HTTP POST 請求
//		//，將 HttpEntity 對象作為輸入參數傳遞給它。 postForObject() 方法返回一個 RecaptchaResponse 對象
//		//return apiResponse != null && apiResponse.isSuccess();//方法檢查 API 響應是否為空，以及 API 是否成功
//	}
//}
