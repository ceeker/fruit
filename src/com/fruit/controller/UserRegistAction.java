package com.fruit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserRegistAction extends ActionSupport implements ServletRequestAware ,ServletResponseAware
{

		private HttpServletResponse response;
		private HttpServletRequest request;
		private String userId;
	public String getUserId()
		{
			return userId;
		}

		public void setUserId(String userId)
		{
			this.userId = userId;
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
	public void validateUserId() throws Exception
	{
		if(userId.equals("123456"))
		{
			response.getWriter().write("false");
		}
		else
		{
			response.getWriter().write("true");
		}
	}
	

}
