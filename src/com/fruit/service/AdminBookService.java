package com.fruit.service;

import java.util.List;

import com.fruit.dao.AdminBookDao;
import com.fruit.domain.Book;

public class AdminBookService
{

	private AdminBookDao adminBookDao;

	public AdminBookDao getAdminBookDao()
	{
		return adminBookDao;
	}

	public void setAdminBookDao(AdminBookDao adminBookDao)
	{
		this.adminBookDao = adminBookDao;
	}

	public List<Book> findAllBooks()
	{
		// TODO Auto-generated method stub
		return adminBookDao.findAllBooks();
				
	}

	public List<Book> findBooksByUserId(String userId)
	{
		// TODO Auto-generated method stub
		return adminBookDao.findBooksByUserId(userId);
	}

	public int deleteBookById(String bookId)
	{
		// TODO Auto-generated method stub
		return adminBookDao.deleteBookById(bookId);
	}

	public int activeBookById(String bookId)
	{
		// TODO Auto-generated method stub
		return adminBookDao.activeBookById(bookId);
	}
	public List<Book> findUnDealBook() {
		// TODO Auto-generated method stub
		return adminBookDao.findUnDealBook();
	}


}
