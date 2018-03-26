package com.liangyu.entity.vo;

import java.io.Serializable;

import com.liangyu.entity.User;

public class LoginVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int LOGIN_SUCC=1;
	public static final int LOGIN_FAIL=0;
	
	
	
	
	private int errno;
	private String message;
	private User user;
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
}
