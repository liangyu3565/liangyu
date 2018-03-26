package com.liangyu.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liangyu.common.DBUtils;
import com.liangyu.dao.ProductDao;
import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;
import com.liangyu.exception.ProductException;

public class ProductDaoImpl implements ProductDao {
	private static ProductDao product=null;
	private ProductDaoImpl() {}
	public static ProductDao getInstance(){
		synchronized(ProductDaoImpl.class) {
		if(product==null) {
			product=new ProductDaoImpl();
	}
		}
		return product;
	}
	

	
	public List<Product> readAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		List<Product> product=new ArrayList<Product>();
		Product product1=null;
		try {
			
			conn=DBUtils.getConnection();
			String sql="select id,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,create_time,update_time from product";
			ps=conn.prepareStatement(sql);
			st=ps.executeQuery();
			while(st.next()) {
				product1=new Product();
				product1.setId(st.getInt("id"));
				product1.setCategory_id(st.getInt("category_id"));
				product1.setName(st.getString("name"));
				product1.setSubtitle(st.getString("subtitle"));
				product1.setMain_image(st.getString("main_image"));
				product1.setSub_image(st.getString("sub_image"));
				product1.setDetail(st.getString("detail"));
				product1.setPrice(st.getBigDecimal("price"));
				product1.setStock(st.getInt("stock"));
				product1.setStatus(st.getInt("status"));
				product1.setCreate_time(st.getDate("create_time"));
				product1.setUpdate_time(st.getDate("update_time"));
				product.add(product1);
			} 
		
			return product;
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
		
		
		
		

	
		return product;
		
	}

	
	public int addProductDao(Product  product) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			conn=DBUtils.getConnection();
			String sql="insert into product(category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,create_time,update_time) value(?,?,?,?,?,?,?,?,?,now(),now());";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, product.getCategory_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getSubtitle());
			ps.setString(4, product.getMain_image());
			ps.setString(5, product.getSub_image());
			ps.setString(6, product.getDetail());
			ps.setBigDecimal(7, product.getPrice());
			ps.setInt(8, product.getStock());
			ps.setInt(9, product.getStatus());
			
			System.out.println(ps);
		
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
	
	public int delectProductDao(Product product) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from product where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, product.getId());
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
	
	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		 
		Product product=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,create_time,update_time from product where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			st=ps.executeQuery();
			if(st.next()) {
				product=new Product(st.getInt("id"),st.getInt("category_id"),st.getString("name"),st.getString("subtitle"),st.getString("main_image"),st.getString("sub_image"),st.getString("detail"),st.getBigDecimal("price"),st.getInt("stock"),st.getInt("status"),st.getDate("create_time"),st.getDate("update_time"));
				
				 
				
			} 
		
			return product;
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
	
	public int updateProductDao(Product product) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update product set category_id=?,name=?,subtitle=?,main_image=?,sub_image=?,detail=?,price=?,stock=?,status=?,update_time=now() where id=?";	
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, product.getCategory_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getSubtitle());
			ps.setString(4, product.getMain_image());
			ps.setString(5, product.getSub_image());
			ps.setString(6, product.getDetail());
			ps.setBigDecimal(7, product.getPrice());
			ps.setInt(8, product.getStock());
			ps.setInt(9, product.getStatus());
			ps.setInt(10, product.getId());
			
			
		
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
	
	public PageModle<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
PageModle<Product> pageModle=new PageModle<Product>();
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		
		Product product1=null;
		try {
			conn=DBUtils.getConnection();
			String sqlcount="select count(id) from product";
			ps=conn.prepareStatement(sqlcount);
			st=ps.executeQuery();
			if(st.next()) {
				int totalCount=st.getInt(1);
				int totalPage=(totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModle.setTotalPage(totalPage);
			}
			String sql="select id,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,create_time,update_time from product limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,(pageNo-1)*pageSize);
			ps.setInt(2,pageSize);
			
			st=ps.executeQuery();
			List<Product> product=new ArrayList<Product>();
			while(st.next()) {
				product1=new Product();
				product1.setId(st.getInt("id"));
				product1.setCategory_id(st.getInt("category_id"));
				product1.setName(st.getString("name"));
				product1.setSubtitle(st.getString("subtitle"));
				product1.setMain_image(st.getString("main_image"));
				product1.setSub_image(st.getString("sub_image"));
				product1.setDetail(st.getString("detail"));
				product1.setPrice(st.getBigDecimal("price"));
				product1.setStock(st.getInt("stock"));
				product1.setStatus(st.getInt("status"));
				product1.setCreate_time(st.getDate("create_time"));
				product1.setUpdate_time(st.getDate("update_time"));
				product.add(product1);
			} 
		pageModle.setData(product);
			
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
	
	public List<Category> findAllCategoryt_id() {
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
	
	public long getProductStock(Integer product_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int reduceProductStock(Integer product_id, Integer quantity) throws ProductException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

