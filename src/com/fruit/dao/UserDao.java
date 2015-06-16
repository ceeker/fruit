package com.fruit.dao;

import java.util.ArrayList;
import java.util.List;













import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.User;
import com.fruit.util.SpringUtil;

public class UserDao {
	private User user;
	private SpringUtil springUtil;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public SpringUtil getSpringUtil() {
		return springUtil;
	}
	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}
	
	
	//根据验证用户是否有效
	public List<String> validateLogin(String userId){
		return springUtil.getSession().createQuery(" select U.userPassword from User U where U.userId=:var1").setString("var1", userId).list();
		
	}
	public List<String> userLogin(String userId, String userPassword)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<String> result=new  ArrayList<String>(); 
		try
		{
			result=sess.createQuery(" select U.userPassword from User U where U.userId=:var1").setString("var1", userId).list();
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}finally
		{
			tx.commit();
			sess.close();
		}
		return result;
		
	}
	public int userRegist(User user)
	{
		int flag=0;
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			sess.save(user);
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
	}
	
	//用户修改个人信息
	public int  updateUserInfo(User user)
	{
		// TODO Auto-generated method stub
		int flag=0;
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			//用户的修改密码和修改个人信息分开
			User u=(User)sess.get(User.class, new String(user.getUserId()));
			u.setUserName(user.getUserName());
			u.setUserAddr(user.getUserAddr());
			u.setUserBirth(user.getUserBirth());
			u.setUserMail(user.getUserMail());
			u.setUserPhone(user.getUserPhone());
			u.setUserSex(user.getUserSex());
			
			
			sess.save(u);
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
		
		
	}
	
	
	//用户修改个人密码
	public int userUpdatePassword(User user2)
	{
		int flag=0;
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			//用户的修改密码和修改个人信息分开
			User u=(User)sess.get(User.class, new String(user2.getUserId()));
			u.setUserPassword(user2.getUserPassword());
			
			
			sess.save(u);
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
		
	}
	//用户查询自己的信息
	public User findUserInfoById(String userId)
	{
		// TODO Auto-generated method stub
		int flag=0;
		User u;
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			//用户的修改密码和修改个人信息分开
		 u=(User)sess.get(User.class, new String(userId));
			
			
			
			
			
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		return u;
		
		
		
	}
	//p判断用户是否存在
	public List isExist(String userId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List list;
		try
		{
			list=sess.createQuery("from User as u  where  u.userId=:userId").setString("userId", userId).list();
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();sess.close();
		}
		return list;
		
		
		
	}
	public List mailExist(String userMail)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List list;
		try
		{
			list=sess.createQuery("from User as u  where  u.userMail=:userMail").setString("userMail", userMail).list();
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();sess.close();
		}
		return list;
		
	}
	//用户修改个人邮箱
	public int updateMail(String userId,String userMail)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int result=0;
		try
		{
			 result=sess.createQuery("update User u set u.userMail=:userMail where u.userId=:userId").setString("userMail", userMail).setString("userId",userId).executeUpdate();
			sess.flush();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		return result
				;
	}
	//用户修改个人地址
	public int updateAddr(String userId, String userAddr)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int result=0;
		try
		{
			 result=sess.createQuery("update User u set u.userAddr=:userAddr where u.userId=:userId").setString("userAddr", userAddr).setString("userId",userId).executeUpdate();
			 sess.flush();
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		return result
				;
	}
	//用户更新电话
	public int updatePhone(String userId, String userPhone)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int result=0;
		try
		{
			 result=sess.createQuery("update User u set u.userPhone=:userPhone where u.userId=:userId").setString("userPhone", userPhone).setString("userId",userId).executeUpdate();
			 sess.flush();
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		return result
				;
	}
	//用户验证密码是否相同
	public int validatePass(String userId, String prepass)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<String> list=sess.createQuery("select u.userPassword from User as u where u.userId=:userId").setString("userId", userId).list();
		if(list.get(0).toString().trim().equals(prepass))
		{
			tx.commit();
			sess.close();
			return 1;
		}
		else
		{
			tx.commit();
			sess.close();
			return 0;
		}
		
		
	}
	

}
