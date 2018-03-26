package com.liangyu.serviseimpl;

import com.liangyu.dao.LoginDao;
import com.liangyu.daoimpl.LodinDaoByMybatis;
import com.liangyu.daoimpl.LoginDaoimpl;
import com.liangyu.entity.User;
import com.liangyu.exception.UserDaoException;
import com.liangyu.servise.Servise;

public class ServiseImpl implements Servise {
    LoginDao loginDao=new LodinDaoByMybatis();
	
	public User doLogin(String username, String password) throws UserDaoException {
		// TODO Auto-generated method stub
		User user=null;
		int result=loginDao.checkUserName(username);
		
		if(result>0) {
			user=loginDao.findByUserNameAndPsssword(username, password);
		}
		
		return user;
	}
	
	public int updateTokenByUserId(Integer userid, String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		 LoginDao loginDao=new LodinDaoByMybatis();
		 return loginDao.updateTokenByUserId(userid, token);
		
	}
	
	public User findUserByToken(String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		LoginDao loginDao=new LodinDaoByMybatis();
		 return loginDao.findUserByToken(token);
		
		
	}
	
	public User findByUserNameAndPsssword(String username, String password) throws UserDaoException {
		// TODO Auto-generated method stub
		
		LoginDao loginDao=new LodinDaoByMybatis();
		 return loginDao.findByUserNameAndPsssword(username, password);
		
		
	}
	
	public int delectTokenByUserId(Integer userid) throws UserDaoException {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoimpl();
		 return loginDao.delectTokenByUserId(userid);
	}

}
