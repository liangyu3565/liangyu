package com.liangyu.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.liangyu.common.DBUtils;
import com.liangyu.dao.LoginDao;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.exception.UserDaoException;



public class LoginDaoimpl implements LoginDao {

	
	public int   checkUserName(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="select username from user where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			st=ps.executeQuery();
			if(st.next()) {
				return 1;
			}else {
				return 0;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserDaoException("��ѯ�û�������");
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UserDaoException("��ѯ�û�������رմ���");
			}
		}
		
		
		
	
	}

	
	

	
	public User findByUserNameAndPsssword(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		User user=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,username,password,email,phone,question,answer,role from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			st=ps.executeQuery();
			if(st.next()) {
				user=new User();
				user.setId(st.getInt("id"));
				user.setUsername(st.getString("username"));
				user.setPassword(st.getString("password"));
			}else {
				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserDaoException("��ѯ�û�������2");
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UserDaoException("��ѯ�û�������رմ���2");
			}
		}
		
		
		
		return user;
	}




	
	public int updateTokenByUserId(Integer userid, String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		try {
			conn=DBUtils.getConnection();
			String sql="update user set token=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, token);
			ps.setInt(2, userid);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserDaoException("�����û�token����");
		}finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UserDaoException("�����û�token�رմ���");
			}
		}
		
		
		
	
	}




	
	public User findUserByToken(String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet st=null;
		User user=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,username,password,email,phone,question,answer,role  from user where token=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, token);
			st=ps.executeQuery();
			if(st.next()) {
				user=new User();
				user.setId(st.getInt("id"));
				user.setUsername(st.getString("username"));
				user.setPassword(st.getString("password"));
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserDaoException("��ѯ�û�������3");
		}finally {
			try {
				DBUtils.close(conn, ps, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UserDaoException("��ѯ�û�������رմ���3");
			}
		}
		
		
		
		return user;
	}




	
	public int delectTokenByUserId(Integer userid) throws UserDaoException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		
		try {
			conn=DBUtils.getConnection();
			String sql="update user set token=null where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserDaoException("ɾ���û�token����");
		}finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UserDaoException("ɾ���û�token�رմ���");
			}
		}
		
		
	}




	
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}




	
	public PageModle<User> findUserByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}




	
	public int addBatchUser(List<User> user) throws UserDaoException {
		// TODO Auto-generated method stub
		return 0;
	}




	
	public List<User> findUserByForeach(List<Integer> ids) throws UserDaoException {
		// TODO Auto-generated method stub
		return null;
	}

		
		
		
		
	}
		
	

	
	

