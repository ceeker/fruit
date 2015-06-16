package com.fruit.service;

import java.util.List;

import com.fruit.dao.UserDao;
import com.fruit.domain.User;

public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	//验证用户是否有效
	public List<String> validateLogin(String userId) {
		
		return userDao.validateLogin(userId);
	}

	public List<String> userLogin(String userId, String userPassword)
	{
		// TODO Auto-generated method stub
		return userDao.userLogin(userId,userPassword);
	}

	public int userRegist(User user)
	{
		// TODO Auto-generated method stub
		return userDao.userRegist(user);
		
	}

	public int updateUserInfo(User user)
	{
		// TODO Auto-generated method stub
		return userDao.updateUserInfo(user);
		
	}

	public int userUpdatePassword(User user)
	{
		// TODO Auto-generated method stub
		return userDao.userUpdatePassword(user);
		
	}

	public User findUserInfoById(String userId)
	{
		// TODO Auto-generated method stub
		return userDao.findUserInfoById(userId);
	}

	public List isExist(String userId)
	{
		// TODO Auto-generated method stub
		return userDao.isExist(userId);
		
	}

	public List mailExist(String userMail)
	{
		// TODO Auto-generated method stub
		return userDao.mailExist(userMail);
		
	}

	public int updateMail(String userId,String userMail)
	{
		// TODO Auto-generated method stub
		return userDao.updateMail(userId,userMail);
	}

	public int updateAddr(String userId, String userAddr)
	{
		// TODO Auto-generated method stub
		
		return userDao.updateAddr(userId,userAddr);
	}

	public int updatePhone(String userId, String userPhone)
	{
		// TODO Auto-generated method stub
		return userDao.updatePhone(userId,userPhone);
	}

	public int validatePass(String userId, String prepass)
	{
		// TODO Auto-generated method stub
		return userDao.validatePass(userId,prepass);
	}

}
