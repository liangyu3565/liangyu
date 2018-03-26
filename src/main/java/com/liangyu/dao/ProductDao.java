package com.liangyu.dao;

import java.util.List;

import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;
import com.liangyu.exception.ProductException;

public interface ProductDao {
	public List<Product> readAll();
	public int addProductDao(Product  product);
	public int delectProductDao(Product  product);
	public Product findProductById(Integer id);
	public int updateProductDao(Product  product);
	public List<Category> findAllCategoryt_id();
	public long getProductStock(Integer product_id);
	public PageModle<Product> findProductByPage(int pageNo,int pageSize);
	int reduceProductStock(Integer product_id,Integer quantity) throws ProductException;

}

	


