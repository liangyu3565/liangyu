package com.liangyu.exception;

public class UserDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4269264313370886688L;
   private String message;
public UserDaoException(String message) {
	super(message);
}
public UserDaoException() {
	super();
} 
}
