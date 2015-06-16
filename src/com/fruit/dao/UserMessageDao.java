package com.fruit.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.User;
import com.fruit.domain.UserMessage;
import com.fruit.util.DateFormatUtil;
import com.fruit.util.HibernateUtil;
import com.fruit.util.SpringUtil;

public class UserMessageDao {
	
	public UserMessageDao(){
		
	}
	private UserMessage userMessage;
	private SpringUtil springUtil;
	

	public SpringUtil getSpringUtil() {
		return springUtil;
	}

	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}
	
	
	public List<UserMessage> findMyUserMessages(User user)
	{	
		 //List<UserMessage> list=springUtil.getSession().createQuery("from UserMessage where UserMessage.isConfirm=1").list();
		String userId=user.getUserId().toString(); 
		
		String hql = "from UserMessage where UserMessage.userMessageAuthor.userId="+userId;
		 List<UserMessage> list = HibernateUtil.executeQuery(hql);
		 return list;
	}

	//插入用户留言
	public int insertIntoUserMessage(String userMessageId,
			 String userMessageContent,
			 String userId, Date userMessageDate) {
			Session sess = springUtil.getSession();
			Transaction tx = sess.beginTransaction();
					int result=0;
		
		try{
			User user = (User) sess.get(User.class, new String(userId));
			UserMessage userMessage = new UserMessage();
			userMessage.setUserMessageId(userId+DateFormatUtil.getInstance().format(new Date()));
			
			userMessage.setUserMessageContent(userMessageContent);
			userMessage.setUserMessageAuthor(user);
			userMessage.setUserMessageDate(new Date());
			sess.save(userMessage);
			sess.flush();	
				result=1;				
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常！");
		}finally{
			tx.commit();
			sess.close();
		}
		
		return result;
	}
    
	
}
