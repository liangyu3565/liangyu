package com.liangyu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserOrder implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3801111416829979540L;
	/**
	 * 
	 */
	
	int id ;
	 long order_no;
	 int user_id;
	  User user;
	  int  shipping_id;
	  BigDecimal payment;
	  int  payment_type;
	  int postage;
	  int status ;
	 Date payment_time;
	 Date send_time;
	 Date end_time;
	 Date close_time;
	 Date create_time;
	 Date update_time;
	 private List<UserOrderItem> orderItems=null;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	

	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", user=" + user
				+ ", shipping_id=" + shipping_id + ", payment=" + payment + ", payment_type=" + payment_type
				+ ", postage=" + postage + ", status=" + status + ", payment_time=" + payment_time + ", send_time="
				+ send_time + ", end_time=" + end_time + ", close_time=" + close_time + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", orderItems=" + orderItems + "]";
	}

	public UserOrder(int id, long order_no, int user_id, int shipping_id, BigDecimal payment, int payment_type,
			int postage, int status, Date payment_time, Date send_time, Date end_time, Date close_time,
			Date create_time, Date update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public UserOrder() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	
	public int getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public int getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}
	public int getPostage() {
		return postage;
	}
	public void setPostage(int postage) {
		this.postage = postage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getClose_time() {
		return close_time;
	}
	public void setClose_time(Date close_time) {
		this.close_time = close_time;
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

	public List<UserOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<UserOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	 
	 
	 
	
	
}
