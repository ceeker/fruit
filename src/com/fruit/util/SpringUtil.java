package com.fruit.util;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringUtil 
{
	private WebApplicationContext ctx;
	private SessionFactory sf;
	private Session sess;
		
	public void setWebApplicationContext(WebApplicationContext ctx)
	{
		this.ctx=ctx;
	}
	public WebApplicationContext getWebApplicationContext()
	{
		return (WebApplicationContext)ServletActionContext.getRequest().getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}
	public SessionFactory getSessionFactory()
	{
		SessionFactory factory = (SessionFactory)getWebApplicationContext().getBean("sessionFactory");

		return factory;
	}
	public Session getSession()
	{
		sess=getSessionFactory().openSession();
		return sess;
	}
	public void closeSession()
	{
		this.sess.close();
		
	}
}
