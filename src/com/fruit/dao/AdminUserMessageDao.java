package com.fruit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.UserMessage;
import com.fruit.util.SpringUtil;

public class AdminUserMessageDao {
	private SpringUtil springUtil;

	public SpringUtil getSpringUtil() {
		return springUtil;
	}

	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}
	public List<UserMessage> findAllUserMessage(){
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		List<UserMessage> userMessageList = new ArrayList<UserMessage>();
		try{
			userMessageList = sess.createQuery("from UserMessage").list();
			
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			tx.commit();
			sess.close();
		}
		return userMessageList;
	}

	public int deleteUserMessageById(String userMessageId) {
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		int result=0;
		try{
			String sql = "delete from UserMessage where userMessageId=?";
			result =sess.createSQLQuery(sql).setString(0,userMessageId).executeUpdate();
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			tx.commit();
			sess.close();
		}
		return result;
	}

	public UserMessage findUserMessageById(String userMessageId) {
		UserMessage userMessage ;
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		
		try{
			userMessage = (UserMessage) sess.get(UserMessage.class, new String(userMessageId));
			
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
			throw new RuntimeException("系统操作异常");
		}finally{
			tx.commit();
			sess.close();
		}
		return userMessage;
	}

	public int updateUserMessageById(UserMessage userMessage) {
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		try{
			UserMessage um = (UserMessage) sess.get(UserMessage.class, new String(userMessage.getUserMessageId()));
			um.setIsConfirm(userMessage.getIsConfirm());
			sess.merge(um);
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
			throw new RuntimeException("系统操作异常");
		}finally{
			tx.commit();
			sess.close();
		}
		return 1;
	}

}
