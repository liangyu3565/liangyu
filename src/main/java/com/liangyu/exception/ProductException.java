package com.liangyu.exception;

public class ProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4976052319988669351L;
	 private String message;
	public ProductException(String message) {
		super(message);
	}
	public ProductException() {
		super();
	}
	
	
}
