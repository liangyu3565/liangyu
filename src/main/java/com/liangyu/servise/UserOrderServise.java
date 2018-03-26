package com.liangyu.servise;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liangyu.entity.PageModle;
import com.liangyu.entity.UserOrder;
import com.liangyu.entity.UserOrderItem;
import com.liangyu.entity.vo.OrderVO;
import com.liangyu.exception.UserOrderException;
import com.liangyu.exception.UserOrderItemDaoException;

public interface UserOrderServise {

	UserOrder createOrder(Integer user_id,HttpServletRequest request) throws UserOrderException;
	public UserOrder findUserOrderDetailByOrderNo(Long orderno) throws UserOrderException; 
	public PageModle<OrderVO> findUserOrderByPage(Integer userid, HttpServletRequest request) throws UserOrderException;
	int updateOrderStatusByOrderNo(HttpServletRequest request) throws UserOrderException;
	public List<UserOrderItem> findOrderItemByOrderNo(Long orderno) throws UserOrderItemDaoException;
}
