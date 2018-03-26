package com.liangyu.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.liangyu.common.MyBatisUtils;
import com.liangyu.dao.LoginDao;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.exception.UserDaoException;

public class LodinDaoByMybatis implements LoginDao {

	
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Object o=session.selectOne("com.liangyu.entity.User.checkUserName",username);
		if(o instanceof Integer) {
			return (Integer)o;
		}
		MyBatisUtils.cliose(session);
		return 0;
	}

	
	public User findByUserNameAndPsssword(String username, String password) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		
		Object o=session.selectOne("com.liangyu.entity.User.findByUserNameAndPsssword",map);
		if(o instanceof User) {
			return (User)o;
		}
		MyBatisUtils.cliose(session);
		
		return null;
	}

	
	public int updateTokenByUserId(Integer userid, String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", token);
		map.put("userid", userid);
		
		int result=session.update("com.liangyu.entity.User.updateTokenByUserId",map);
		session.commit();
		MyBatisUtils.cliose(session);
		
		return result;
	}
		

	
	public User findUserByToken(String token) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		Object o=session.selectOne("com.liangyu.entity.User.findUserByToken",token);
		if(o instanceof User) {
			return (User)o;
		}
		MyBatisUtils.cliose(session);
		
		
		
		return null;
	}

	
	public int delectTokenByUserId(Integer userid) throws UserDaoException {
		// TODO Auto-generated method stub

		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int result=session.delete("com.liangyu.entity.User.delectTokenByUserId",userid);
		session.commit();
		MyBatisUtils.cliose(session);
		
		return result;
		
		
		
		
	}

	
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		List<User> list=session.selectList("com.liangyu.entity.User.findAllUser");
		MyBatisUtils.cliose(session);
		
		
		return list;
	}

	
	public PageModle<User> findUserByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int totalcount=(Integer)session.selectOne("com.liangyu.entity.User.findTotalCount");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<User> user=session.selectList("com.liangyu.entity.User.findUserbyPage", map);
		
		
		PageModle<User> pageModle=new PageModle<User>();
		pageModle.setTotalPage(((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1));
		pageModle.setData(user);
		
		
		
		MyBatisUtils.cliose(session);
		
		
		
		return pageModle;
	}

	
	public int addBatchUser(List<User> user) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		int result=session.insert("com.liangyu.entity.User.addBatchUser", user);
		
		
		session.commit();
		
		
		
		MyBatisUtils.cliose(session);
		
		
		return result;
	}

	
	public List<User> findUserByForeach(List<Integer> ids) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		List<User> user=session.selectList("com.liangyu.entity.User.findUserByForeach", ids);
		
		
		session.commit();
		
		
		
		MyBatisUtils.cliose(session);
		
		
		return user;
	}

}
