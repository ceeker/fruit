package com.fruit.imp;

import java.util.List;

import com.fruit.domain.PageBean;
import com.fruit.domain.User;
import com.fruit.inter.PageDao;
import com.fruit.inter.PageService;



public class PageServiceImpl implements PageService
{
	private PageDao pageDao;

	public PageDao getPageDao()
	{
		return pageDao;
	}

	public void setPageDao(PageDao pageDao)
	{
		this.pageDao = pageDao;
	}

	@Override
	public PageBean queryForPage(String hql,int pageSize, int page)
	{
		// TODO Auto-generated method stub
		
		int allRow=pageDao.getAllRowCount(hql);
		int totalPage=PageBean.countTotalPage(pageSize, allRow);
		final int offset=PageBean.countOffset(pageSize, page);
		final int length=pageSize;
		final int currentPage=PageBean.countCurrentPage(page);
		List list=pageDao.queryForPage(hql, offset, length);
		PageBean pageBean=new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		
		
		
		return pageBean;
	}
	
}
