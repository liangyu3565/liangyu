package com.liangyu.exception;

public class UserOrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4976052319988669351L;
	 private String message;
	public UserOrderException(String message) {
		super(message);
	}
	public UserOrderException() {
		super();
	}
	
	
}
