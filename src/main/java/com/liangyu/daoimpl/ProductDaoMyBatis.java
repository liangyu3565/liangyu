package com.liangyu.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liangyu.common.MyBatisUtils;
import com.liangyu.dao.ProductDao;
import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;
import com.liangyu.exception.ProductException;

public class ProductDaoMyBatis implements ProductDao {

	
	public List<Product> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int addProductDao(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int delectProductDao(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int updateProductDao(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<Category> findAllCategoryt_id() {
		// TODO Auto-generated method stub
		return null;
		
	}

	
	public long getProductStock(Integer product_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Long row=session.selectOne("com.liangyu.entity.Product.getProductStock",product_id);
		session.close();
		
		
		return row;
	}

	
	public PageModle<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int reduceProductStock(Integer product_id, Integer quantity) throws ProductException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("quantity", quantity);
		map.put("productid", product_id);
		int row=session.update("com.liangyu.entity.Product.reduceProductStock",map);
		session.commit();
		
		session.close();
		
		
		return row;
	}

}
