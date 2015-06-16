package com.fruit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.service.UserBookService;
import com.opensymphony.xwork2.ActionSupport;

public class UserBookProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware
{
	private UserBookService userBookService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	public UserBookService getUserBookService()
	{
		return userBookService;
	}

	public void setUserBookService(UserBookService userBookService)
	{
		this.userBookService = userBookService;
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
	
	
}
