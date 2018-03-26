package com.liangyu.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liangyu.common.MyBatisUtils;
import com.liangyu.dao.UserOrderDao;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.UserOrder;
import com.liangyu.exception.UserOrderException;

public class UserOrderDaoImpl implements UserOrderDao {

	
	public int addOrder(UserOrder userOrder) throws UserOrderException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();

		int result=session.insert("com.liangyu.entity.UserOrder.addOrder",userOrder);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
	}


	public PageModle<UserOrder> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize)
			throws UserOrderException {
		// TODO Auto-generated method stub
		
		
		
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		PageModle<UserOrder> pageModle=new PageModle<UserOrder>();
		int totalPage=session.selectOne("com.liangyu.entity.UserOrder.findTotalPage",userid);
		if(totalPage>0) {
			Map<String,Integer> map=new HashMap<String,Integer>();
			map.put("offset", (pageNo-1)*pageSize);
			map.put("pageSize", pageSize);
			map.put("userid", userid);
			List<UserOrder> userOrder=session.selectList("com.liangyu.entity.UserOrder.findUserOrder",map);
			int a=(totalPage%pageSize==0?totalPage/pageSize:(totalPage/pageSize)+1);
			pageModle.setTotalPage(a);
			pageModle.setData(userOrder);
		}
		session.commit();
		MyBatisUtils.cliose(session);
		return pageModle;
		
	}

	
	public UserOrder findUserOrderDetailByOrderNo(Long orderno) throws UserOrderException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		UserOrder userOrder=session.selectOne("com.liangyu.entity.UserOrder.findOrderItemByOrderNo",orderno);
		
		session.commit();
		MyBatisUtils.cliose(session);
		return userOrder;
		
		
		
		
		
	}

	
	public int updateOrderStatusByOrderNo(Long orderno,Integer status) throws UserOrderException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("status", status);
			map.put("orderno",orderno);
			int userOrder=session.update("com.liangyu.entity.UserOrder.updateOrderStatusByOrderNo",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return userOrder;
	}

}
