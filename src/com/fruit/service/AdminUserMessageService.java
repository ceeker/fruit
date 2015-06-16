package com.fruit.service;

import java.util.List;

import com.fruit.dao.AdminUserMessageDao;
import com.fruit.domain.UserMessage;

public class AdminUserMessageService {
	private AdminUserMessageDao adminUserMessageDao;

	public AdminUserMessageDao getAdminUserMessageDao() {
		return adminUserMessageDao;
	}

	public void setAdminUserMessageDao(AdminUserMessageDao adminUserMessageDao) {
		this.adminUserMessageDao = adminUserMessageDao;
	}

	public List<UserMessage> findAllUserMessage() {
		
		return adminUserMessageDao.findAllUserMessage();
	}

	public int deleteUserMessageById(String userMessageId) {
		return adminUserMessageDao.deleteUserMessageById(userMessageId);
	}

	public UserMessage findUserMessageById(String userMessageId) {
		return adminUserMessageDao.findUserMessageById(userMessageId);
	}

	public int updateUserMessageById(UserMessage userMessage) {
		// TODO Auto-generated method stub
		return adminUserMessageDao.updateUserMessageById(userMessage);
	}

}
