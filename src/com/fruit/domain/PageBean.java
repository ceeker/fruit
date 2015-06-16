package com.fruit.domain;

import java.util.List;

public class PageBean
{
	private List list; //返回某一页的所有记录
	private int allRow;// 总记录数
	private int totalPage;
	private int currentPage;
	private int pageSize;
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	public List getList()
	{
		return list;
	}
	public void setList(List list)
	{
		this.list = list;
	}
	public int getAllRow()
	{
		return allRow;
	}
	public void setAllRow(int allRow)
	{
		this.allRow = allRow;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	
	
	
	public boolean isFirstPage()
	{
		return currentPage==1;
	}
	public boolean isLastPage()
	{
		return currentPage==totalPage;
		
	}
	public boolean isHasPreviousPage()
	{
		return currentPage!=1;
	}
	public boolean isHasNextPage()
	{
		return currentPage!=totalPage;
	}
	public void init()
	{
		this.isFirstPage=isFirstPage();
		this.isLastPage=isLastPage();
		this.hasPreviousPage=isHasPreviousPage();
		this.hasNextPage=isHasNextPage();
	}
	
	
	/**
	 *计算当前页开始记录
	 * @param pageSize  每页记录数
	 * @param currentPage 当前页代码
	 * @return 起始位置
	 */
	public static int countOffset(final int pageSize,final int currentPage)
	{
		final int offset=pageSize*(currentPage-1);
		return offset;
	}
	
	
	/**
	 * 计算当前页
	 * @param page
  	 * @return
	 */
	public static int countCurrentPage(int page)
	{
		final int curPage=(page==0?1:page);
		return curPage;
	}
	
	public static int  countTotalPage(final int pageSize,final int allRow)
	{
		int totalPage=allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1;
		return totalPage;
	}
	
	
	
	
	
}
