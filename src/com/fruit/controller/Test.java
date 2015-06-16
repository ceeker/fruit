package com.fruit.controller;

import java.io.IOException;

import com.fruit.domain.MailMessage;
import com.fruit.imp.SendMailImp;
import com.fruit.inter.SendMail;

public class Test
{
	public static void main(String[] args)
	{
		MailMessage message=new MailMessage();
		message.setFrom("807858227@qq.com");
		message.setTo("slsongliang@163.com");
		message.setSubject("这是一个简单的邮箱测试");
		message.setUser("807858227");
		message.setContent("this is the simple mail test, we hope this can be used to recover your password\n您好这是一个简单的邮件测试希望能作为密码找回功能。");
		message.setDataFrom("807858227@qq.com");
		message.setDataTo("373724750@qq.com");
		message.setPassword("sl18345167117");
		SendMail send=SendMailImp.getInstance(SendMailImp.QQ).setMessage(message);
		try
		{
			send.sendMail();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
