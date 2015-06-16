package com.fruit.service;

import java.util.List;

import com.fruit.dao.RecoverPasswordDao;
import com.fruit.domain.User;

public class RecoverPasswordService
{
	private RecoverPasswordDao recoverPasswordDao;

	public RecoverPasswordDao getRecoverPasswordDao()
	{
		return recoverPasswordDao;
	}

	public void setRecoverPasswordDao(RecoverPasswordDao recoverPasswordDao)
	{
		this.recoverPasswordDao = recoverPasswordDao;
	}

	public List validateUser(String userId)
	{
		// TODO Auto-generated method stub
		return  recoverPasswordDao.validateUser(userId);
 
	}
}
