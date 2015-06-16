package com.fruit.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.Book;
import com.fruit.util.SpringUtil;

public class AdminBookDao
{
	private SpringUtil springUtil;
	private int flag=0;
	
	public SpringUtil getSpringUtil()
	{
		return springUtil;
	}


	public void setSpringUtil(SpringUtil springUtil)
	{
		this.springUtil = springUtil;
	}


	public List<Book> findAllBooks()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Book> list=new ArrayList<Book>();
		try
		{
			list=sess.createQuery("from Book where isConfirm=2").list();			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("服务器异常");
		}finally
		{
			tx.commit();
			sess.close();
			
		}
		return list;
	
	}


	public List<Book> findBooksByUserId(String userId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Book> listUserBooks=new ArrayList<Book>();
		try
		{
			listUserBooks=sess.createQuery("from Book b where b.bookUser.userId=:userId").setString("userId", userId).list();
			
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
		return listUserBooks;
		
		
	}


	public int  deleteBookById(String bookId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Book b=(Book)sess.get(Book.class, new String(bookId));
			b.setIsVisible(0);
			sess.save(b);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
		
	}

//管理员激活订单
	public int activeBookById(String bookId)
	{
		
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Book book=(Book)sess.get(Book.class, new String(bookId));
			book.setIsConfirm(2);
			sess.flush();
			sess.save(book);
			
			flag=1;
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统异常");
			
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}
	
	public List<Book> findUnDealBook() {
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Book> bookList=new ArrayList<Book>();
		try
		{
			bookList=sess.createQuery("from Book where isConfirm=1 order by bookUser.userId ASC").list();
		} catch (HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		return bookList;
		
	}
	
	


}
