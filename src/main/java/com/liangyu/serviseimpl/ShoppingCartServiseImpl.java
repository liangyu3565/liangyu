package com.liangyu.serviseimpl;

import javax.servlet.http.HttpServletRequest;

import com.liangyu.dao.ShoppingCartDao;
import com.liangyu.daoimpl.ShoppingCartDaoImpl;
import com.liangyu.daoimpl.ShoppingCartMyBatis;
import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.exception.CartException;
import com.liangyu.exception.UserDaoException;
import com.liangyu.servise.ShoppingCartServise;

public class ShoppingCartServiseImpl implements ShoppingCartServise {

	private static ShoppingCartServise shoppingCartServise=null;
	private ShoppingCartServiseImpl() {}
	public static ShoppingCartServise getInstance(){
		synchronized(ShoppingCartServiseImpl.class) {
		if(shoppingCartServise==null) {
			shoppingCartServise=new ShoppingCartServiseImpl();
	}
		}
		return shoppingCartServise;
	}
	
	
	public int addCartByUserIdAndProductId(Integer userid, HttpServletRequest request) throws UserDaoException{
		// TODO Auto-generated method stub
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		
		String productid=request.getParameter("product_id");
		if(productid!=null) {
		Integer _productid=0;
		try {
			_productid=Integer.parseInt(productid);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		String quantity=request.getParameter("quantity");
		Integer _quantity=0;
		try {
			_quantity=Integer.parseInt(quantity);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
			Cart cart=shoppingCartDao.findCartByUserIdAndProductId(userid, _productid);
			if(cart==null) {
				return shoppingCartDao.addProductIntoCartByUserIdAndProductId(userid, _productid, _quantity);
			} else {
				int totalQuantity=cart.getQuantity()+_quantity;
				return shoppingCartDao.updateCartByUserIdAndProductId(userid, _productid, totalQuantity);
			}
			
		}else {
			throw new UserDaoException("productidΪ��");
		}
		
		
		
		
		
		
		
	}
	
	public PageModle<Cart> findCartByPage(Integer userid, HttpServletRequest request)throws CartException {
		// TODO Auto-generated method stub
		
		String _pageNo=request.getParameter("pageNo");
		String _pageSize=request.getParameter("pageSize");
		int pageNo=0;
		int pageSize=0;
		try {
			 pageNo=Integer.parseInt(_pageNo);
			 pageSize=Integer.parseInt(_pageSize);
	
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw  new CartException("Page,pageNo转换错误");
		}
		
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		return shoppingCartDao.findCartByPage(userid, pageNo, pageSize);
		
		
		
	}
	
	public int delectCartByProductId(Integer userid, Integer productid) throws CartException {
		// TODO Auto-generated method stub
		
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		return shoppingCartDao.delectCartByProductId(userid, productid);
		
		 
	}
	
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		return shoppingCartDao.findCartByUserIdAndProductId(userid, productid);
	}
	
	public int updateCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) throws CartException {
		// TODO Auto-generated method stub
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		return shoppingCartDao.updateCartByUserIdAndProductId(userid, productid, quantity);
		
		
		
	}
	
	public int checkOrUncheckedProduct(Integer userid, Integer productid, int checked) {
		// TODO Auto-generated method stub
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		return shoppingCartDao.checkOrUncheckedProduct(userid, productid, checked);
	}
	
	public int findCartQuantity(Integer userid) {
		
		ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
		return shoppingCartDao.findCartQuantity(userid);
		// TODO Auto-generated method stub
		
	}

	

}
