package com.liangyu.exception;

public class UserOrderItemDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4269264313370886688L;
   private String message;
public UserOrderItemDaoException(String message) {
	super(message);
}
public UserOrderItemDaoException() {
	super();
} 
}
