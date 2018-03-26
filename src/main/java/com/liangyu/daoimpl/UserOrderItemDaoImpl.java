package com.liangyu.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liangyu.common.MyBatisUtils;
import com.liangyu.dao.UserOrderItemDao;
import com.liangyu.entity.UserOrderItem;
import com.liangyu.exception.UserOrderItemDaoException;

public class UserOrderItemDaoImpl implements UserOrderItemDao {

	
	public int addBatch(List<UserOrderItem> list) throws UserOrderItemDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int row=session.insert("com.liangyu.entity.UserOrderItem.addBatch",list);
		session.commit();
		session.close();
		
		
		return row;
	}

	
	public List<UserOrderItem> findOrderItemByOrderNo(Long orderno) throws UserOrderItemDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<UserOrderItem> row=session.selectList("com.liangyu.entity.UserOrderItem.findOrderItemByOrderNo",orderno);
		session.commit();
		session.close();
		return row;
	}

}
