package com.fruit.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;







import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.Admin;
import com.fruit.domain.Message;
import com.fruit.util.DateFormatUtil;
import com.fruit.util.SpringUtil;




public class AdminMessageDao {
 private SpringUtil springUtil;

	public SpringUtil getSpringUtil() {
	return springUtil;
}
public void setSpringUtil(SpringUtil springUtil) {
	this.springUtil = springUtil;
}
	public List<Message> queryAllMessage() {
		// TODO Auto-generated method stub
		Session session=springUtil.getSession();
		
		//开启事务；
		
		Transaction ts=session.beginTransaction();
		List<Message> messageList=new ArrayList<Message>();
		//查询公告
		try{
			messageList=session.createQuery("from Message").list();
			return	messageList;
		}catch(Exception e){
			e.printStackTrace();
			ts.rollback();
			
			throw  new RuntimeException("系统操作异常");
		}finally{
			
			ts.commit();
			session.close();		
		}	
	}
	
	
	
	
	public int insertMessage(Message message,String adminId)
	{
		Session sess=springUtil.getSession();
		Transaction tx =sess.beginTransaction();
		int flag=0;
		try {
			
			Admin messageAuthor=(Admin)sess.get(Admin.class, new String(adminId));
			Message mi=new Message();
			mi.setMessageId(DateFormatUtil.getInstance().format(new Date()));
			mi.setMessageTitle(message.getMessageTitle());
			mi.setMessageContent(message.getMessageContent());
			mi.setMessageDate(new Date());
			mi.setMessageAdmin(messageAuthor);
			/*sess.merge(mi);*/
			sess.save(mi);
			sess.flush();
			flag=1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
	}
	public int deleteMessageById(String id)
	{
		Session sess=springUtil.getSession();
		Transaction tx =sess.beginTransaction();
		System.out.print(id);
		String sql="delete from message where messageId=?";
		int result=sess.createSQLQuery(sql).setString(0, id).executeUpdate();
		tx.commit();
		sess.close();
		
		return result;
		
		
	}
	public int updateMessage(Message message)
	{
		Session sess=springUtil.getSession();
		Transaction tx =sess.beginTransaction();
		//Admin messageAuthor=(Admin)sess.get(Admin.class, new String(adminId));
		Message mi=(Message)sess.get(Message.class, new String(message.getMessageId()));
		//mi.setMessageId(messageId);
		mi.setMessageTitle(message.getMessageTitle());
		mi.setMessageContent(message.getMessageContent());
		mi.setMessageDate(new Date());
		//mi.setMessageAdmin(messageAuthor);
		sess.merge(mi);
		sess.flush();
		tx.commit();
		return 1;
		
	}
	
	public Message findMessageById(String messageId) {
		Message message ;
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		try{
		      message = (Message) sess.get(Message.class, new String(messageId));
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
				throw  new RuntimeException("系统操作异常");
			}finally{
				tx.commit();
				sess.close();
				
			}
		 return message;
	}



}
