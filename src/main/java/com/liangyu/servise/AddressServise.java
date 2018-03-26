package com.liangyu.servise;

import com.liangyu.entity.Address;
import com.liangyu.entity.PageModle;  

public interface AddressServise {

	public int addAddress(Integer userid,Address adress);
	   public int delectAddressByUserid(Integer userid,Integer id);
	   public int updateUserAddressByUserid(Integer userid,Address adress);
	   public PageModle<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	   public Address findAddressById(Integer id);
	
}
