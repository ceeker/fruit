package com.fruit.controller;

import com.fruit.domain.PageBean;
import com.fruit.inter.PageService;
import com.opensymphony.xwork2.ActionSupport;


public class PageAction extends ActionSupport
{
	public PageService pageService;
	private String hql;
	public String getHql()
	{
		return hql;
	}

	public void setHql(String hql)
	{
		this.hql = hql;
	}

	public PageService getPageService()
	{
		return pageService;
	}

	public void setPageService(PageService pageService)
	{
		this.pageService = pageService;
	}
	private int  page;//第几页
	private PageBean pageBean;

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public PageBean getPageBean()
	{
		return pageBean;
	}

	public void setPageBean(PageBean pageBean)
	{
		this.pageBean = pageBean;
	}
	public String page() throws Exception
	{
		
		this.pageBean=pageService.queryForPage(hql,2, page);
		return "ok";
	}
	
}
