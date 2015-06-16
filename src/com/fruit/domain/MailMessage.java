package com.fruit.domain;

public class MailMessage
{
	//发件人
	private String from;
	//收件人
	private String to;
	//发件人，在邮件中显示
	private String dataFrom;
	//收件人，在邮件中显示
	private String dataTo;
	//主题
	private String subject;
	//内容
	private String content;
	//日期
	private String date;
	//发送邮箱用户名,邮箱名前缀
	private String user;
	//发送邮箱密码
	private String  password;
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	public String getDataFrom()
	{
		return dataFrom;
	}
	public void setDataFrom(String dataFrom)
	{
		this.dataFrom = dataFrom;
	}
	public String getDataTo()
	{
		return dataTo;
	}
	public void setDataTo(String dataTo)
	{
		this.dataTo = dataTo;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getUser()
	{
		return user;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	
	
}
