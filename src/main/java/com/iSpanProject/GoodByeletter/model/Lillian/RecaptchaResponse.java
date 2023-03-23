package com.iSpanProject.GoodByeletter.model.Lillian;

import java.util.Arrays;

public class RecaptchaResponse {


	private boolean success;
	private String challenge_ts;
	//challenge_ts 代表 reCAPTCHA 驗證的時間戳記，可以用來確認驗證是否過期，避免使用舊的驗證結果。
	private String hostname;
	//hostname 則是代表網站的主機名稱，用來確認驗證請求是否來自於合法的網站。這些資訊都可以協助確保使用者的安全性和網站的安全性。
	public String[] errorCodes;
	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getChallenge_ts() {
		return challenge_ts;
	}


	public void setChallenge_ts(String challenge_ts) {
		this.challenge_ts = challenge_ts;
	}


	public String getHostname() {
		return hostname;
	}


	public void setHostname(String hostname) {
		this.hostname = hostname;
	}


	public String[] getErrorCodes() {
		return errorCodes;
	}


	public void setErrorCodes(String[] errorCodes) {
		this.errorCodes = errorCodes;
	}


	public RecaptchaResponse() {

	}

	@Override
	public String toString() {
		return "RecaptchaResponse [success=" + success + ", challenge_ts=" + challenge_ts + ", hostname=" + hostname + ", errorCodes=" + Arrays.toString(errorCodes) + "]";
	}
}
