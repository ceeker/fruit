package com.fruit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.Book;
import com.fruit.service.AdminBookService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminBookProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware
{

	private HttpServletResponse response;
	private HttpServletRequest request;
	private AdminBookService adminBookService;
	private List<Book> listBooks=new ArrayList<Book>();
	
	public List<Book> getBookList()
	{
		return bookList;
	}

	public void setBookList(List<Book> bookList)
	{
		this.bookList = bookList;
	}

	private List<Book> bookList = new ArrayList<Book>();
	private String flag;
	private String userId;
	private List<Book> listUserBooks=new ArrayList<Book>();
	private String bookId;
	public String getBookId()
	{
		return bookId;
	}

	public void setBookId(String bookId)
	{
		this.bookId = bookId;
	}

	public List<Book> getListUserBooks()
	{
		return listUserBooks;
	}

	public void setListUserBooks(List<Book> listUserBooks)
	{
		this.listUserBooks = listUserBooks;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public List<Book> getListBooks()
	{
		return listBooks;
	}

	public void setListBooks(List<Book> listBooks)
	{
		this.listBooks = listBooks;
	}

	public HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	public AdminBookService getAdminBookService()
	{
		return adminBookService;
	}

	public void setAdminBookService(AdminBookService adminBookService)
	{
		this.adminBookService = adminBookService;
	}

	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		this.request=request;
	}
	//管理员查询所有的订单
	public String findAllBooks()
	{
		try
		{
		listBooks=adminBookService.findAllBooks();
		if(listBooks.size()==0)
		{
			flag="no data";
			return "fail";
		}
		else
		{
			flag="ok";
			return  "ok";
					
		}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="服务器异常";
			return "error";
		}
	}
	//管理员某人的订单
	public String findBooksByUserId()
	{
		try
		{
			listUserBooks=adminBookService.findBooksByUserId(userId);
			if(listUserBooks.size()==0)
			{
				flag="no data";
				return "fail";
			}
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
		
	}
	//删除订单,认为订单无效
	public String deleteBookById()
	{
		try
		{
			int result=adminBookService.deleteBookById(bookId);
			if(result==0)
			{
				flag="fail";
				return "fail";
			}
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="服务器异常";
			return "error";
		}
	}
	//激活订单
	public void activeBookById()
	{
		try
		{
			
			System.out.println(bookId);
			
			int result=adminBookService.activeBookById(bookId);
			if(result==1)
			{
				flag="ok";
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/plain");
				response.getWriter().write("true");
			}
			else
			{
			flag="fail";
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain");
			response.getWriter().write("false");
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
	}
	
	//待处理订单
	public String findUnDealBook(){
		try
		{
			bookList=adminBookService.findUnDealBook();
			System.out.println(bookList.size());
			if(bookList.size()==0)
			{
				flag="no data";
				return "fail";
			}
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
	}

 }
