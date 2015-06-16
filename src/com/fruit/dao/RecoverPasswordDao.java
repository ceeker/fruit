package com.fruit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.User;
import com.fruit.util.SpringUtil;

public class RecoverPasswordDao
{
	private SpringUtil springUtil;

	public SpringUtil getSpringUtil()
	{
		return springUtil;
	}

	public void setSpringUtil(SpringUtil springUtil)
	{
		this.springUtil = springUtil;
	}

	public List validateUser(String userId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<User> list=null;
		list=sess.createQuery("from User as u where u.userId=:userId").setString("userId",userId).list();
		return list;
	}
	
}
