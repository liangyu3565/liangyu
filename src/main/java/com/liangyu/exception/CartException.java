package com.liangyu.exception;

public class CartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4976052319988669351L;
	 private String message;
	public CartException(String message) {
		super(message);
	}
	public CartException() {
		super();
	}
	
	
}
