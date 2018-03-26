package com.liangyu.dao;

import java.util.List;

import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.exception.CartException;

public interface ShoppingCartDao {
 Cart findCartByUserIdAndProductId(Integer userid,Integer productid) throws CartException;
 int updateCartByUserIdAndProductId(Integer userid,Integer productid,int quantity) throws CartException;
 
 int addProductIntoCartByUserIdAndProductId(Integer userid,Integer productid,int quantity) throws CartException;
 PageModle<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize) throws CartException;
 int delectCartByProductId(Integer userid,Integer productid) throws CartException;
 
 int checkOrUncheckedProduct(Integer userid,Integer productid,int checked)throws CartException;
 int findCartQuantity(Integer userid)throws CartException;
 
 List<Cart> findCartListByUserId(Integer userid) throws CartException;
 
 int deleteCheckedProductByUserid(Integer user_id)throws CartException;
 public int price(Cart cart) throws CartException;
 
}
