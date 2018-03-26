package com.liangyu.dao;

import java.util.List;

import com.liangyu.entity.UserOrderItem;
import com.liangyu.exception.UserOrderItemDaoException;

public interface UserOrderItemDao {
	
	
	int addBatch(List<UserOrderItem> list)throws UserOrderItemDaoException;
     List<UserOrderItem> findOrderItemByOrderNo(Long orderno)throws UserOrderItemDaoException;
}
