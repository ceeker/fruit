package com.fruit.service;

import java.util.Date;
import java.util.List;

import com.fruit.dao.UserMessageDao;
import com.fruit.domain.User;
import com.fruit.domain.UserMessage;

public class UserMessageService {
	
	private UserMessageDao userMessageDao;

	public UserMessageDao getUserMessageDao() {
		return userMessageDao;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		this.userMessageDao = userMessageDao;
	}
	
	public List<UserMessage> findMyUserMessages(User user){
		return userMessageDao.findMyUserMessages(user);
	}

	public int insertIntoUserMessage(String userMessageId, String userMessageContent,
			String userId, Date userMessageDate) {
		// TODO Auto-generated method stub
		return userMessageDao.insertIntoUserMessage(userMessageId,
				userMessageContent,
				userId, userMessageDate);
	}

	
}
