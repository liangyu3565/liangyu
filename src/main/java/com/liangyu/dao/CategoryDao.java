package com.liangyu.dao;

import java.util.List;

import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;

public interface CategoryDao {
	public List<Category> readAll();
	public int addCategory(Category  category);
	public int delectCategory(Category  category);
	public Category findCategoryById(Integer id);
	public int updateCategory(Category  category);
	public List<Category> findAllParent_id();
	public PageModle<Category> findCategoryByPage(int pageNo,int pageSize);
	
	

}

	


