package com.liangyu.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.liangyu.common.DBUtils;
import com.liangyu.dao.CategoryDao;

import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;

public class CategoryDaoImpl implements CategoryDao {
	private static CategoryDao categoryDao=null;
	private CategoryDaoImpl() {}
	public static CategoryDao getInstance(){
		synchronized(CategoryDaoImpl.class) {
		if(categoryDao==null) {
			categoryDao=new CategoryDaoImpl();
	}
		}
		return categoryDao;
	}
	

	
	public List<Category> readAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		List<Category> category=new ArrayList<Category>();
		Category category1=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category";
			ps=conn.prepareStatement(sql);
			st=ps.executeQuery();
			while(st.next()) {
				category1=new Category();
				category1.setId(st.getInt("id"));
				category1.setParent_id(st.getInt("parent_id"));
				category1.setName(st.getString("name"));
				category1.setStatus(st.getInt("status"));
				category1.setSort_order(st.getInt("sort_order"));
				category1.setCreate_time(st.getDate("create_time"));
				category1.setUpdate_time(st.getDate("update_time"));
				category.add(category1);
				 
				
			} 
		
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		
		

	
		return category;
		
	}

	
	public int addCategory(Category  category) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="insert into category(parent_id,name,status,sort_order,create_time,update_time) value(?,?,?,?,now(),now())";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, category.getParent_id());
			ps.setString(2, category.getName());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getSort_order());
			
		
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		
		return 0;
	}
	
	public int delectCategory(Category category) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from category where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, category.getId());
            return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		return 0;
	}
	
	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		 
		Category category=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			st=ps.executeQuery();
			if(st.next()) {
				category=new Category(st.getInt("id"),st.getInt("parent_id"),st.getString("name"),st.getInt("status"),st.getInt("sort_order"),st.getDate("create_time"),st.getDate("update_time"));
				
				 
				
			} 
		
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		
		

		return null;
	}
	
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update category set parent_id=?,name=?,status=?,sort_order=?,update_time=now() where id=?";	
			ps=conn.prepareStatement(sql);
			ps.setInt(1, category.getParent_id());
			ps.setString(2, category.getName());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getSort_order());
			ps.setInt(5, category.getId());
			
		
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		return 0;
	}
	
	public List<Category> findAllParent_id() {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		List<Category> category=new ArrayList<Category>();
		Category category1=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category";
			ps=conn.prepareStatement(sql);
			st=ps.executeQuery();
			while(st.next()) {
				category1=new Category();
				category1.setId(st.getInt("id"));
				category1.setParent_id(st.getInt("parent_id"));
				category1.setName(st.getString("name"));
				category1.setStatus(st.getInt("status"));
				category1.setSort_order(st.getInt("sort_order"));
				category1.setCreate_time(st.getDate("create_time"));
				category1.setUpdate_time(st.getDate("update_time"));
				category.add(category1);
				 
				
			} 
		
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		
		

		return null;
	}
	
	public PageModle<Category> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModle<Category> pageModle=new PageModle<Category>();
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		
		Category category1=null;
		try {
			conn=DBUtils.getConnection();
			String sqlcount="select count(id) from category";
			ps=conn.prepareStatement(sqlcount);
			st=ps.executeQuery();
			if(st.next()) {
				int totalCount=st.getInt(1);
				int totalPage=(totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModle.setTotalPage(totalPage);
			}
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			
			st=ps.executeQuery();
			List<Category> category=new ArrayList<Category>();
			while(st.next()) {
				category1=new Category();
				category1.setId(st.getInt("id"));
				category1.setParent_id(st.getInt("parent_id"));
				category1.setName(st.getString("name"));
				category1.setStatus(st.getInt("status"));
				category1.setSort_order(st.getInt("sort_order"));
				category1.setCreate_time(st.getDate("create_time"));
				category1.setUpdate_time(st.getDate("update_time"));
				category.add(category1);
				 
				
			} 
		pageModle.setData(category);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		
		
		return pageModle;
	}
}

