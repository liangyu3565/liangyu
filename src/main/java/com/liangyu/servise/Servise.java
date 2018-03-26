package com.liangyu.servise;

import com.liangyu.entity.User;
import com.liangyu.exception.UserDaoException;

public interface Servise {
	public User doLogin(String username,String password) throws UserDaoException;
	public User findByUserNameAndPsssword(String username,String password) throws UserDaoException;
	public int updateTokenByUserId(Integer userid,String token) throws UserDaoException;
	public User findUserByToken(String token) throws UserDaoException;
	public int delectTokenByUserId(Integer userid) throws UserDaoException;
}
