package com.liangyu.serviseimpl;

import java.util.List;

import com.liangyu.dao.CategoryDao;
import com.liangyu.daoimpl.CategoryDaoImpl;
import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.servise.Categoryservise;

public class CategoryserviseImpl implements Categoryservise{

	
	public List<Category> SreadAll() {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		
			List<Category> list=categoryDao.readAll();
		
		return list;
	}

	
	
	
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		return categoryDao.addCategory(category);
		
		
	}



	
	public int delectCategory(Category category) {
		// TODO Auto-generated method stub
		
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		return categoryDao.delectCategory(category);
		
	}


 
	
	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		return categoryDao.findCategoryById(id);
		
		
	}



	
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		return categoryDao.updateCategory(category);
		
	}



	
	public List<Category> findAllParent_id() {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		return categoryDao.findAllParent_id();
		
	}



	
	public PageModle<Category> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		CategoryDao categoryDao=CategoryDaoImpl.getInstance();
		return categoryDao.findCategoryByPage(pageNo, pageSize);

	}



	
		
	

}
