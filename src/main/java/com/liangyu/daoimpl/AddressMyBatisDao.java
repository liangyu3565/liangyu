package com.liangyu.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liangyu.common.MyBatisUtils;
import com.liangyu.dao.UserAddress;
import com.liangyu.entity.Address;
import com.liangyu.entity.PageModle;

public class AddressMyBatisDao implements UserAddress {

	
	
	
	private static UserAddress userAddress=new AddressMyBatisDao();
	private AddressMyBatisDao() {
		
	};
	
	public static UserAddress getInstance() {
		return userAddress;
	}
	
	
	public int addAddress(Integer userid, Address adress) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("receiver_name", adress.getReceiver_name());
		map.put("receiver_phone", adress.getReceiver_phone());
		map.put("receiver_mobile", adress.getReceiver_mobile());
		map.put("receiver_province", adress.getReceiver_province());
		map.put("receiver_city", adress.getReceiver_city());
		map.put("receiver_district", adress.getReceiver_district());
		map.put("receiver_address", adress.getReceiver_address());
		map.put("receiver_zip", adress.getReceiver_zip());
		
		
		
		int result=session.insert("com.liangyu.entity.Address.addAddress",map);
		session.commit();
		MyBatisUtils.cliose(session);
		
		
		return result;
		
		
		
		
		
	}

	
	public int delectAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("id", id);
		
		
		
		int result=session.delete("com.liangyu.entity.Address.delectAddressByUserid",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
		
		
		
		
	}

	
	public int updateUserAddressByUserid(Integer userid, Address adress) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("receiver_name", adress.getReceiver_name());
		map.put("receiver_phone", adress.getReceiver_phone());
		map.put("receiver_mobile", adress.getReceiver_mobile());
		map.put("receiver_province", adress.getReceiver_province());
		map.put("receiver_city", adress.getReceiver_city());
		map.put("receiver_district", adress.getReceiver_district());
		map.put("receiver_address", adress.getReceiver_address());
		map.put("receiver_zip", adress.getReceiver_zip());
		
		
		
		int result=session.update("com.liangyu.entity.Address.updateUserAddressByUserid",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
		
		
		
	}

	
	public PageModle<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		
		
		
		int totalCount=session.selectOne("com.liangyu.entity.Address.findTotalPage",userid);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List list=session.selectList("com.liangyu.entity.Address.findDate",map);
		PageModle<Address> pageModle=new PageModle<Address>();
		int totalPage=(totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize)+1);
		pageModle.setData(list);
		pageModle.setTotalPage(totalPage);
		
		session.commit();
		MyBatisUtils.cliose(session);
		return pageModle;
		
		
		
		
	}

	
	public Address findAddressById(Integer id) {
		// TODO Auto-generated method stub
		
		
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		
		
		Address address=session.selectOne("com.liangyu.entity.Address.findAddressById",id);
		session.commit();
		MyBatisUtils.cliose(session);
		return address;
		
	}

}
