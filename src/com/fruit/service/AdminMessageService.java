package com.fruit.service;

import java.util.Date;
import java.util.List;

import com.fruit.dao.AdminMessageDao;
import com.fruit.domain.Message;

public class AdminMessageService {
  
	
	private AdminMessageDao adminMessageDao;
	public AdminMessageDao getAdminMessageDao() {
		return adminMessageDao;
	}
	public void setAdminMessageDao(AdminMessageDao adminMessageDao) {
		this.adminMessageDao = adminMessageDao;
	}
	public List<Message> queryAllMessage() {
		// TODO Auto-generated method stub
		 return adminMessageDao.queryAllMessage();
		
	}
	public int insertMessage(Message message,String adminId) {
		// TODO Auto-generated method stub
		return adminMessageDao.insertMessage(message,adminId);
		
	}
	
	public int deleteMessageById(String messageId) {
		// TODO Auto-generated method stub
		
			return adminMessageDao.deleteMessageById(messageId);
		
		
		
	}
	public int updateMessage(Message message) {
		// TODO Auto-generated method stub
		
		return adminMessageDao.updateMessage(message);
	}
	
	public Message findMessageById(String messageId) {
		return adminMessageDao.findMessageById(messageId);
	}


	
	

}
