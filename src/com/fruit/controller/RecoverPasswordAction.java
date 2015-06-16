package com.fruit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.MailMessage;
import com.fruit.domain.User;
import com.fruit.imp.SendMailImp;
import com.fruit.inter.SendMail;
import com.fruit.service.RecoverPasswordService;
import com.opensymphony.xwork2.ActionSupport;

public class RecoverPasswordAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware
{
	private String userId;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private RecoverPasswordService  recoverPasswordService;

	public RecoverPasswordService getRecoverPasswordService()
	{
		return recoverPasswordService;
	}

	public void setRecoverPasswordService(
			RecoverPasswordService recoverPasswordService)
	{
		this.recoverPasswordService = recoverPasswordService;
	}

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
	public String recover()
	{
		List<User> list=recoverPasswordService.validateUser(userId);
		
		if(!list.isEmpty())
		{
			String to=list.get(0).getUserMail().toString().trim();
			MailMessage message=new MailMessage();
			message.setFrom("807858227@qq.com");
			message.setTo(to);
			message.setSubject("绿活在线网站找回密码");
			message.setUser("807858227");
			message.setContent("您的密码:"+list.get(0).getUserPassword());
			message.setDataFrom("807858227@qq.com");
			message.setDataTo(list.get(0).getUserMail());
			message.setPassword("sl18345167117");
			SendMail send=SendMailImp.getInstance(SendMailImp.QQ).setMessage(message);
			try
			{
				send.sendMail();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			return "ok";
		}
		
		return "fail";
	}

	
}
