package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Book implements Serializable
{
	public Vegetable getBookVegetable()
	{
		return bookVegetable;
	}
	public void setBookVegetable(Vegetable bookVegetable)
	{
		this.bookVegetable = bookVegetable;
	}
	
	private String bookId;
	
	private Vegetable bookVegetable;
	private User bookUser;
	private String bookAddr;
	private String bookPhone;
	public String getBookPhone()
	{
		return bookPhone;
	}
	public void setBookPhone(String bookPhone)
	{
		this.bookPhone = bookPhone;
	}
	public String getBookAddr()
	{
		return bookAddr;
	}
	public void setBookAddr(String bookAddr)
	{
		this.bookAddr = bookAddr;
	}
	public User getBookUser()
	{
		return bookUser;
	}
	public void setBookUser(User bookUser)
	{
		this.bookUser = bookUser;
	}

	private int bookQuantity;
	private Date bookDate;
	private int isConfirm;
	private int isVisible;
	public int getIsVisible()
	{
		return isVisible;
	}
	public void setIsVisible(int isVisible)
	{
		this.isVisible = isVisible;
	}
	public String getBookId()
	{
		return bookId;
	}
	public void setBookId(String bookId)
	{
		this.bookId = bookId;
	}
	
	public int getBookQuantity()
	{
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity)
	{
		this.bookQuantity = bookQuantity;
	}
	public Date getBookDate()
	{
		return bookDate;
	}
	public void setBookDate(Date bookDate)
	{
		this.bookDate = bookDate;
	}
	public int getIsConfirm()
	{
		return isConfirm;
	}
	public void setIsConfirm(int isConfirm)
	{
		this.isConfirm = isConfirm;
	}
	
	
}
