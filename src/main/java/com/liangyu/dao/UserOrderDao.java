package com.liangyu.dao;

import com.liangyu.entity.PageModle;
import com.liangyu.entity.UserOrder;
import com.liangyu.exception.UserOrderException;

public interface UserOrderDao {

	int addOrder(UserOrder userOrder) throws UserOrderException;
	
	PageModle<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer pageSize) throws UserOrderException;
	UserOrder findUserOrderDetailByOrderNo(Long orderno) throws UserOrderException;
	int updateOrderStatusByOrderNo(Long orderno,Integer status) throws UserOrderException;
    


}
