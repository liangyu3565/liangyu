package com.liangyu.dao;

import java.util.List;

import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.exception.UserDaoException;

public interface LoginDao {
	int  checkUserName(String username);
	User findByUserNameAndPsssword(String username,String password) throws UserDaoException;
	
	
	int updateTokenByUserId(Integer userid,String token) throws UserDaoException;
	
    User findUserByToken(String token) throws UserDaoException;
    
    int delectTokenByUserId(Integer userid) throws UserDaoException;
    List<User> findAllUser();
   int addBatchUser(List<User> user) throws UserDaoException;
    List<User> findUserByForeach(List<Integer> ids) throws UserDaoException;
    PageModle<User> findUserByPage(Integer pageNo,Integer pageSize);
}
