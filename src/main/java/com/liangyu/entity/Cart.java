package com.liangyu.entity;

import java.io.Serializable;
import java.util.Date;
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6877480965857246638L;
	private int id;
	private User user;
	private Product product;
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", product=" + product + ", quantity=" + quantity + ", checked="
				+ checked + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	private int  quantity;
	private int checked;
	private Date  create_time;
	private Date  update_time;
	public Cart() {
		super();
	}
	public Cart(int id,  int quantity, int checked, Date create_time, Date update_time) {
		super();
		this.id = id;
		
		
		this.quantity = quantity;
		this.checked = checked;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
	
}
