package com.iSpanProject.GoodByeletter.model.Tina.chat;

public class Result {
	
	private boolean flag;
	//判斷是否登入的提示
	private String loginmessage;
	
	
	
	
	public Result() {
		super();
	}
	public Result(boolean flag, String loginmessage) {
		super();
		this.flag = flag;
		this.loginmessage = loginmessage;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getLoginmessage() {
		return loginmessage;
	}
	public void setLoginmessage(String loginmessage) {
		this.loginmessage = loginmessage;
	}
	
	

}
