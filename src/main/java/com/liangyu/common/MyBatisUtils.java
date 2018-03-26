package com.liangyu.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
   private static SqlSessionFactory sqlSessionFactory=null;
   
   static {
	   String config="com/liangyu/config/MyBatisConfig.xml";
	   Reader reader=null;
	   try {
		reader=Resources.getResourceAsReader(config);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   
   }
   public static SqlSessionFactory getSqlSessionFactory() {
	     return sqlSessionFactory;
 }
   public static void cliose(SqlSession sqlSession) {
	   sqlSession.close();
   }
}
