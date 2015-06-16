package com.fruit.service;

import com.fruit.dao.UserBookDao;

public class UserBookService
{
	private UserBookDao userBookDao;

	public UserBookDao getUserBookDao()
	{
		return userBookDao;
	}

	public void setUserBookDao(UserBookDao userBookDao)
	{
		this.userBookDao = userBookDao;
	}
}
