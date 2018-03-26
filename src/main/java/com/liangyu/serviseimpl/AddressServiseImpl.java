package com.liangyu.serviseimpl;

import com.liangyu.dao.UserAddress;
import com.liangyu.daoimpl.AddressMyBatisDao;
import com.liangyu.entity.Address;
import com.liangyu.entity.PageModle;
import com.liangyu.servise.AddressServise;

public class AddressServiseImpl implements AddressServise {

	

	private static AddressServise addressServiseImpl=new AddressServiseImpl();
	private AddressServiseImpl() {
		
	};
	
	public static AddressServise getInstance() {
		return addressServiseImpl;
	}
	
	
	
	public int addAddress(Integer userid, Address adress) {
		// TODO Auto-generated method stub
		UserAddress userAddress=AddressMyBatisDao.getInstance();
		return userAddress.addAddress(userid, adress);
		
		
		
	}

	
	public int delectAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub
		UserAddress userAddress=AddressMyBatisDao.getInstance();
		return userAddress.delectAddressByUserid(userid, id);
	}

	
	public int updateUserAddressByUserid(Integer userid, Address adress) {
		// TODO Auto-generated method stub
		UserAddress userAddress=AddressMyBatisDao.getInstance();
		return userAddress.updateUserAddressByUserid(userid, adress);
	}

	
	public PageModle<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		UserAddress userAddress=AddressMyBatisDao.getInstance();
		return userAddress.findUserAddress(pageNo, pageSize, userid);
	}

	
	public Address findAddressById(Integer id) {
		// TODO Auto-generated method stub
		UserAddress userAddress=AddressMyBatisDao.getInstance();
		return userAddress.findAddressById(id);
		
		
		
	}

}
