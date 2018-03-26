package com.liangyu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.liangyu.common.DBUtils;
import com.liangyu.dao.CategoryDao;
import com.liangyu.dao.ShoppingCartDao;
import com.liangyu.entity.Cart;
import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.exception.CartException;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	
	private static ShoppingCartDao shoppingCartDao=null;
	private ShoppingCartDaoImpl() {}
	public static ShoppingCartDao getInstance(){
		synchronized(ShoppingCartDaoImpl.class) {
		if(shoppingCartDao==null) {
			shoppingCartDao=new ShoppingCartDaoImpl();
	}
		}
		return shoppingCartDao;
	}
	
	
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		 
		Cart cart=null;
		try {
			conn=DBUtils.getConnection();
			
			String sql="select id,user_id,product_id,quantity,checked,create_time,update_time from Cart where user_id=? and product_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ps.setInt(2,productid);
			st=ps.executeQuery();
			if(st.next()) {
				cart=new Cart(st.getInt("id"),st.getInt("quantity"),st.getInt("checked"),st.getDate("create_time"),st.getDate("update_time"));
				
				
				
			}
		
			return cart;
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
	
	public int updateCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			
			String sql="update cart set quantity=?,update_time=now() where user_id=? and product_id=?";	
			ps=conn.prepareStatement(sql);
			ps.setInt(1,quantity);
			ps.setInt(2,userid);
			ps.setInt(3, productid);
			
			
		
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
	
	public int addProductIntoCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			
			String sql="insert into cart(user_id,product_id,quantity,create_time,update_time) value(?,?,?,now(),now())";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ps.setInt(2, productid);
			ps.setInt(3, quantity);
			
			
		
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
	
	public PageModle<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int delectCartByProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int checkOrUncheckedProduct(Integer userid, Integer productid, int checked) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int findCartQuantity(Integer userid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Cart> findCartListByUserId(Integer userid) throws CartException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int deleteCheckedProductByUserid(Integer user_id) throws CartException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int price(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
