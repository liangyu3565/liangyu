package com.liangyu.servise;

import java.util.List;

import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;

public interface Categoryservise {
	public List<Category> SreadAll();
	public int  addCategory(Category  category);
	public int  delectCategory(Category  category);
	public Category findCategoryById(Integer id);
	public int updateCategory(Category  category);
	public List<Category> findAllParent_id();
	public PageModle<Category> findCategoryByPage(int pageNo,int pageSize);
	
}
