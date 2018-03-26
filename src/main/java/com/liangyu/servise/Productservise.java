package com.liangyu.servise;

import java.util.List;

import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;

public interface Productservise {
	public List<Product> SreadAll();
	public int  addProduct(Product  product);
	public int  delectProduct(Product  product);
	public Product findProductById(Integer id);
	public int updateProduct(Product  product);
	public List<Category> findAllCategory_id();
	public PageModle<Product> findProductByPage(int pageNo,int pageSize);
}
