package com.iSpanProject.GoodByeletter.dto.Tina;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoardDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 613619474378056644L;

	/**
	 * 
	 */
	
	
	@JsonProperty("inputTitle") //有寫這行 這行裡的name會變成遮罩,沒有變預設, 也可寫在dao上
	private String inputTitle;
	
	@JsonProperty("inputMessage")
	private String inputMessage;
	
	public BoardDto() {
		
	}

	public String getInputTitle() {
		return inputTitle;
	}

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}

	public String getInputMessage() {
		return inputMessage;
	}

	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}
	
}
