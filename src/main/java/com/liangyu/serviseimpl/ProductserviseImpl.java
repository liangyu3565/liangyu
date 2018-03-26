package com.liangyu.serviseimpl;

import java.util.List;

import com.liangyu.dao.CategoryDao;
import com.liangyu.dao.ProductDao;
import com.liangyu.daoimpl.CategoryDaoImpl;
import com.liangyu.daoimpl.ProductDaoImpl;
import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;
import com.liangyu.servise.Categoryservise;
import com.liangyu.servise.Productservise;

public class ProductserviseImpl implements Productservise{

	
	public List<Product> SreadAll() {
		// TODO Auto-generated method stub
		ProductDao productDao=ProductDaoImpl.getInstance();
		
			List<Product> list=productDao.readAll();
		
		return list;
	}

	
	
	
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		ProductDao productDao=ProductDaoImpl.getInstance();
		
		return productDao.addProductDao(product);
		
		
	}



	
	public int delectProduct(Product Product) {
		// TODO Auto-generated method stub
		
        ProductDao productDao=ProductDaoImpl.getInstance();
		
		return productDao.delectProductDao(Product);
		
	}


 

	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		
		 ProductDao productDao=ProductDaoImpl.getInstance();
			
			return productDao.findProductById(id);
			
		
	}



	
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		ProductDao productDao=ProductDaoImpl.getInstance();
		
		return productDao.updateProductDao(product);
		
		
	}



	
	



	
	public PageModle<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
ProductDao productDao=ProductDaoImpl.getInstance();
		
		return productDao.findProductByPage(pageNo, pageSize);
	}




	
	public List<Category> findAllCategory_id() {
		// TODO Auto-generated method stub
ProductDao productDao=ProductDaoImpl.getInstance();
		
		return productDao.findAllCategoryt_id();
		
	
	}

}
