package com.fruit.inter;

import com.fruit.domain.PageBean;



public interface PageService
{
	public PageBean queryForPage(String hql,int pageSize,int currentPage);
	
}
