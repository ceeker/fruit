package com.fruit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.Admin;
import com.fruit.domain.User;
import com.fruit.util.SpringUtil;



public class AdminDao
{
	private Admin admin;
	private SpringUtil springUtil;
   
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public SpringUtil getSpringUtil()
	{
		return springUtil;
	}
	public void setSpringUtil(SpringUtil springUtil)
	{
		this.springUtil = springUtil;
	}
	public List<String> adminLogin(String adminId, String adminPassword)
	{
		// TODO Auto-generated method stub
		return springUtil.getSession().createQuery("select A.adminPassword from Admin A where A.adminId=:var1").setString("var1", adminId).list();
	
	
		
	}
	public List<Admin> findAllAdmins() 
	{
		// TODO Auto-generated method stub
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Admin> result=new ArrayList<Admin>();
		
	
		try
		{
			result=sess.createQuery("from  Admin").list();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统出现错误");
		}
		finally
		{
			tx.commit();
			sess.close();
			
		}
		return result;
		
		
	}
	public Admin findAdminById(String adminId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
	
		
		try
		{
			 admin=(Admin)sess.get(Admin.class, new String(adminId));
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return admin;
	}
	//管理员修改密码
	public int updateAdminInfo(Admin admin)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Admin admin1;
		int result=0;
		try
		{
			admin1=(Admin)sess.get(Admin.class, new String(admin.getAdminId()));
			
			admin1.setAdminPassword(admin.getAdminPassword());
			sess.save(admin1);
			sess.flush();
			result=1;
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
		
		return result;
	}
	//管理员查询所有的用户
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		List<User> result = new ArrayList<User>();
		try{
			result = sess.createQuery("from User").list();
			
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally{
			tx.commit();
			sess.close();
		}
		return result;
	}
	//管理员删除制定的用户
	public int deleteUserById(String userId) {
		// TODO Auto-generated method stub
		Session sess = springUtil.getSession();
		Transaction tx = sess.beginTransaction();
		int result;
	    //System.out.println(userId);
		try{
			String sql ="delete from User where userId=?";			
			result = sess.createSQLQuery(sql).setString(0,userId).executeUpdate();
			sess.flush();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally{
			tx.commit();
			sess.close();
		}
		return result;
	}

	
}
