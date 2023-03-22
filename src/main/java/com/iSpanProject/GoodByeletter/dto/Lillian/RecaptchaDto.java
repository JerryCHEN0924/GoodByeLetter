package com.iSpanProject.GoodByeletter.dto.Lillian;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecaptchaDto implements Serializable {
	
	@JsonProperty("success")
	private boolean success;	//要處理
	
	@JsonProperty("challenge_ts")
	private String challenge_ts;
	
	@JsonProperty("hostname")
	private String hostname;
	
	@JsonProperty("errorCodes")
	private String[] errorCodes;
	
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

	public RecaptchaDto() {
		
	}

}
