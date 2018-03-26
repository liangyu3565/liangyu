package com.liangyu.entity.vo;

import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;

public class CartVO{
	
	public static final int CART_SUCCESS=1;
	public static final int CART_UNLOGIN=0;
	
	
	private int errno;
	private String message;
	private PageModle<Cart> pageModle;
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
	public PageModle<Cart> getPageModle() {
		return pageModle;
	}
	public void setPageModle(PageModle<Cart> pageModle) {
		this.pageModle = pageModle;
	}
	
	
	
	
	

}
