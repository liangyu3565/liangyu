package com.liangyu.entity.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liangyu.consts.OrderStatusEnum;
import com.liangyu.consts.Payment_typeEnum;
import com.liangyu.entity.User;
import com.liangyu.entity.UserOrder;

public class OrderVO {
	int id ;
	long order_no;
	  int  user_id;
	  User user;
	  public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	int  shipping_id;
	  String payment;
	  String  payment_type;
	  int postage;
	  String status ;
	  String payment_time;
	  String send_time;
	  String end_time;
	  String close_time;
	  String create_time;
	  String update_time;
	//private String view_create_time;
	//private String view_update_time;
	
	  public int getId() {
		return id;
	}
	public OrderVO() {
		super();
	}
	public OrderVO(int id, long order_no, int user_id, int shipping_id, String payment, String payment_type,
			int postage, String status, String payment_time, String send_time, String end_time, String close_time,
			String create_time, String update_time) {
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
	public void setId(int id) {
		this.id = id;
	}
	public long getOrder_no() {
		return order_no;
	}
	
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public int getPostage() {
		return postage;
	}
	public void setPostage(int postage) {
		this.postage = postage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getClose_time() {
		return close_time;
	}
	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	/*public String getView_create_time() {
		return view_create_time;
	}
	public void setView_create_time(String view_create_time) {
		this.view_create_time = view_create_time;
	}
	public String getView_update_time() {
		return view_update_time;
	}
	public void setView_update_time(String view_update_time) {
		this.view_update_time = view_update_time;
	}*/
	public void convertUserOrderToOrderVO(UserOrder useOrder) {
		this.id=useOrder.getId();
		this.order_no=useOrder.getOrder_no();
		this.user_id=useOrder.getUser_id();
		this.payment=useOrder.getPayment().toString();
		int paymenttype=useOrder.getPayment_type();
		if(paymenttype==Payment_typeEnum.ONLINE.getType()) {
			this.payment_type="在线支付";	
		}else if(paymenttype==Payment_typeEnum.OFFLINE.getType()) {
			this.payment_type="或到付款";
			
		}
		this.postage=useOrder.getPostage();
		Integer status=useOrder.getStatus();
		if(status==OrderStatusEnum.CANCEL.getStatus()) {
			this.status="取消订单";
		}else if(status==OrderStatusEnum.UNPAY.getStatus()) {
			this.status="未支付";
		}else if(status==OrderStatusEnum.PAY.getStatus()) {
			this.status="已支付";
		}else if(status==OrderStatusEnum.SEND.getStatus()) {
			this.status="已发货";
		}else if(status==OrderStatusEnum.CLOSE.getStatus()) {
			this.status="交易关闭";
		}
		Date create_time=useOrder.getCreate_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(create_time);
		this.update_time=format.format(useOrder.getUpdate_time());
		//this.payment_time=format.format(useOrder.getPayment_time());
		//this.send_time=format.format(useOrder.getSend_time());
		//this.end_time=format.format(useOrder.getEnd_time());
		//this.close_time=format.format(useOrder.getClose_time());
		this.user=useOrder.getUser();
	
	}
	
	

}
