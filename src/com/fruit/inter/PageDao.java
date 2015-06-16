package com.fruit.inter;

import java.util.List;

import org.hibernate.Query;

public interface PageDao 
{
	/**
	 * 
	 * @param hql  查询条件
 	 * @param offet 开始记录
	 * @param length 每次查询几条记录
	 * @return  返回的每页结果集
	 */
	
	public List queryForPage(String hql,int offet,int length);
	
	
	
	/**
	 * @param hql 查询条件
	 * @return  总记录数
	 */
	public  int getAllRowCount(String hql);
	
	
	
	/*public List queryForPart(Query query,int offet, int length);*/
	
	
	
	
}
