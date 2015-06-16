package com.fruit.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


final public class HibernateUtil {
	private static SessionFactory sessionFactory =null;
	//使用线程局部模式
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	//把构造器做成私有的保证单例
	private HibernateUtil(){
		
	};
	
	//静态代码块保证只允许类去调用
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	
	//获取全新的session
	public static Session openSession(){
		return sessionFactory.openSession();
		
	}
	
	//返回和线程关联的session
	
	public static Session getCurrentSession(){
		Session session = threadLocal.get();
		if(session==null){
			session = sessionFactory.openSession();
			//把session和线程关联
			threadLocal.set(session);
		}
		return session;
	}
	
	//提供一个统一的查询方法
	public static List executeQuery(String hql){
		Session session = null;
		Transaction ts = null;
		List list = null;
		try{
			session = HibernateUtil.getCurrentSession();
			ts = session.beginTransaction();
		    list = session.createQuery(hql).list();
			ts.commit();
			
		}catch(Exception e){
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException("出现错误！");
			
			
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
			
		}
		return list;
	}
	
	
	//提供一个统一的带参数的查询方法
	public static List executeQuery(String hql,String [] parameters){
		
		Session session = null;
		List list = null;
		try{
			session = HibernateUtil.openSession();
			Query query = session.createQuery(hql);
			//先判断是否有参数要注入
			if(parameters!=null&&parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				}
			}
			list = query.list();
			
		}catch(Exception e){
			e.printStackTrace();
	
			throw new RuntimeException("e.getMessage()");
				
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
			
		}
		return list;
	}
	
	//提供一个统一的分页查询
	
public static List executeQueryByPage(String hql,String [] parameters,int pageSize,int pageNow){
		//pageSize-->每页显示多少条；pageNow-->显示第几页
	
		Session session = null;
		Transaction ts = null;
		List list = null;
		try{
			session = HibernateUtil.openSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			//先判断是否有参数要注入
			if(parameters!=null&&parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setString(i, parameters[i]);
				}
			}
			query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
			list = query.list();
			ts.commit();
			
		}catch(Exception e){
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException("出现错误！");
			
			
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
			
		}
		return list;
	}

//统一的添加方法

public static void save(Object obj){

	Session session = null;
	Transaction ts = null;
	try{
		session = HibernateUtil.openSession();
		ts = session.beginTransaction();
		session.save(obj);
		ts.commit();
		
	}catch(Exception e){
		if(ts!=null){
			ts.rollback();
		}
		throw new RuntimeException("出现错误！");
		
		
	}finally{
		if(session!=null&&session.isOpen()){
			session.close();
		}
		
	}
	
}

//统一的修改和删除(批量的哦)
public static void executeUpdate(String hql,String [] parameters){
	Session session = null;
	Transaction ts = null;
	try{
		session = HibernateUtil.openSession();
		Query query = session.createQuery(hql);
		//先判断是否有参数要注入
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setString(i, parameters[i]);
			}
		}
		query.executeUpdate();
		ts.commit();
		
	}catch(Exception e){
		e.printStackTrace();
		throw new RuntimeException("出现错误！");
		
		
	}finally{
		if(session!=null&&session.isOpen()){
			session.close();
		}
		
	}
	
	
}





}
