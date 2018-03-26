package com.liangyu.common;


import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;



public class DBUtils{
	private static Properties ps=new Properties();
	static {
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
				Class.forName(ps.getProperty("driver"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
	Connection conn=null;
		try {
			conn=DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("username"),ps.getProperty("psw"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
	public static void close(Connection conn,PreparedStatement st) throws SQLException {
		conn.close();
		st.close();
	}
	public static void close(Connection conn,PreparedStatement st, ResultSet rs) throws SQLException {
		conn.close();
		st.close();
		rs.close();
	}
	
	
	
}
