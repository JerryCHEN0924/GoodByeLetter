package com.iSpanProject.GoodByeletter.service.Lillian;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iSpanProject.GoodByeletter.model.Lillian.RecaptchaResponse;

@Service
public class RecaptchaService {

	@Value("${google.recaptcha.key.site}")
	private String recaptchaSiteKey;

	@Value("${google.recaptcha.key.secret}")
	private String recaptchaSecretKey;

	@Value("${google.recaptcha.api.url}")
	private String recaptchaApiUrl;
	

	public boolean verifyRecaptcha(String response1) {//接收一個 IP 地址和一個 reCAPTCHA 驗證回應作為輸入參數
		RestTemplate restTemplate = new RestTemplate();//使用 RestTemplate 進行 HTTP POST 請求，並將 reCAPTCHA 驗證回應傳遞到 Google reCAPTCHA API 進行驗證

		//ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();//創建了一個 MultiValueMap 對象，用於存儲 POST 請求中的參數
		bodyMap.add("secret", recaptchaSecretKey);//添加了 reCAPTCHA 密鑰
		bodyMap.add("response", response1);//驗證回應//就是token
		//bodyMap.add("remoteip", ip);//用戶 IP 地址到 MultiValueMap 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//用於設置 POST 請求的 Content-Type

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);
		//建了一個 HttpEntity 對象，將 MultiValueMap 和 HttpHeaders 對象作為輸入參數傳遞給它
		
		RecaptchaResponse recaptchaResponse = new RecaptchaResponse();	
//		RecaptchaResponse apiResponse = restTemplate.postForObject(recaptchaApiUrl, url,
//				RecaptchaResponse.class);
		String apiResponse = restTemplate.postForObject(recaptchaApiUrl, bodyMap, String.class);
		System.out.println(apiResponse);
		
		if(apiResponse.isEmpty()) {
			return false;
		}
		Gson gson = new Gson();
		RecaptchaResponse rRepo = gson.fromJson(apiResponse, RecaptchaResponse.class);
		System.out.println(rRepo);
		boolean success = rRepo.isSuccess();
		if(success) {
			// 驗證成功，繼續處理您的應用程式邏輯
			return true;
		} 
		else {
			// 驗證失敗，要求用戶重新進行驗證
			return false;
		}
		
		//方法使用 RestTemplate 的 postForObject() 方法向 reCAPTCHA API 發送 HTTP POST 請求
		//，將 HttpEntity 對象作為輸入參數傳遞給它。 postForObject() 方法返回一個 RecaptchaResponse 對象
		//return apiResponse != null && apiResponse.isSuccess();//方法檢查 API 響應是否為空，以及 API 是否成功
	}
}
