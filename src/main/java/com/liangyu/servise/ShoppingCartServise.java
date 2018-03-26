package com.liangyu.servise;

import javax.servlet.http.HttpServletRequest;

import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.exception.CartException;

public interface ShoppingCartServise {
	int addCartByUserIdAndProductId(Integer userid,HttpServletRequest request)throws CartException;
	
	PageModle<Cart> findCartByPage(Integer userid,HttpServletRequest request)throws CartException;
	
	int delectCartByProductId(Integer userid,Integer productid) throws CartException;
	
	Cart findCartByUserIdAndProductId(Integer userid,Integer productid);
	int updateCartByUserIdAndProductId(Integer userid,Integer productid,int quantity) throws CartException;
	
	int findCartQuantity(Integer userid);
	int checkOrUncheckedProduct(Integer userid,Integer productid,int checked);
}
