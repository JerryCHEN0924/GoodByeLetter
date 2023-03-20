package com.iSpanProject.GoodByeletter.model.Tina.chat;

public class ResultMessage {
	
	//true :系統消息 false:for specific user
	private boolean isSystem;
	private String fromName;
	private Object message;
	
	
	
	public ResultMessage() {
		super();
	}
	public ResultMessage(boolean isSystem,String fromName, Object message) {
		super();
		this.isSystem = isSystem;
		this.fromName = fromName;
		this.message = message;
	}
	public boolean isSystem() {
		return isSystem;
	}
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	

}
