package com.liangyu.consts;

public enum OrderStatusEnum {
    CANCEL(0,"交易取消"),
    UNPAY(10,"δ֧��"),
    PAY(20,"��֧��"),
    SEND(40,"�ѷ���"),
	SUCCESS(50,"ȷ���ջ�"),
	CLOSE(60,"���׹ر�");
	
	
	
	
	private int status;
	private String message;
	private OrderStatusEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
