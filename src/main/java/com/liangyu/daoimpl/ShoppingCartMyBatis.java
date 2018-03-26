package com.liangyu.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liangyu.common.MyBatisUtils;
import com.liangyu.dao.ShoppingCartDao;
import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.exception.CartException;

public class ShoppingCartMyBatis implements ShoppingCartDao {

	
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", userid);
		map.put("product_id", productid);
		
		Object o=session.selectOne("com.liangyu.entity.Cart.findCartByUserIdAndProductId",map);
		if(o instanceof Cart) {
			return (Cart)o;
		}
		
		
		MyBatisUtils.cliose(session);
		
		return null;
		
	}

	
	public int updateCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("quantity", quantity);
		map.put("user_id", userid);
		map.put("product_id", productid);
		
		int result=session.update("com.liangyu.entity.Cart.updateCartByUserIdAndProductId",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
	}

	
	public int addProductIntoCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("user_id", userid);
		map.put("product_id", productid);
		map.put("quantity", quantity);
		
		int result=session.update("com.liangyu.entity.Cart.addProductIntoCartByUserIdAndProductId",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
		
		
	}

	
	public PageModle<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) throws CartException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pagesize", pageSize);
		PageModle<Cart> pageModle=new PageModle<Cart>();
		Integer totalcount=(Integer)session.selectOne("com.liangyu.entity.Cart.findTotalCount",userid);
		if(totalcount>0) {
		List<Cart> list=session.selectList("com.liangyu.entity.Cart.findCartByPage", map);
		
		int totalPage=(totalcount%pageSize==0?(totalcount/pageSize):(totalcount/pageSize)+1);
		pageModle.setTotalPage(totalPage);
		pageModle.setData(list);
		}
		
		
		MyBatisUtils.cliose(session);
		return pageModle;
	}

	
	public int delectCartByProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
	
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("user_id", userid);
		map.put("product_id", productid);
		
		
		int result=session.delete("com.liangyu.entity.Cart.delectCartByProductId",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
	}

	
	public int checkOrUncheckedProduct(Integer userid, Integer productid, int checked) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("user_id", userid);
		map.put("product_id", productid);
		map.put("checked", checked);
		
		
		int result=session.update("com.liangyu.entity.Cart.checkOrUncheckedProduct",map);
		session.commit();
		MyBatisUtils.cliose(session);
		return result;
		
		
		
		
		
	}

	
	public int findCartQuantity(Integer userid) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int result=0;
	    result=session.selectOne("com.liangyu.entity.Cart.findCartQuantity",userid);	
		MyBatisUtils.cliose(session);	
		return result;
	}

	
	public List<Cart> findCartListByUserId(Integer userid) throws CartException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<Cart> list=session.selectList("com.liangyu.entity.Cart.findCartListByUserId",userid);
		MyBatisUtils.cliose(session);
		return list;
	}

	
	public int deleteCheckedProductByUserid(Integer user_id) throws CartException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int list=session.delete("com.liangyu.entity.Cart.deleteCheckedProductByUserid",user_id);
		session.commit();
		MyBatisUtils.cliose(session);
		return list;
	}

	
	public int price(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		
		
		return 0;
	}

}
