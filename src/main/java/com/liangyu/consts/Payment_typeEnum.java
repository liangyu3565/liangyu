package com.liangyu.consts;

public enum Payment_typeEnum {
    ONLINE(1,"在线支付"),
    OFFLINE(2,"货到付款");
	
	int type;
	String message;
	private Payment_typeEnum(int type, String message) {
		this.type = type;
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
