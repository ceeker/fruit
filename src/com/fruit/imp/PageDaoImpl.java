package com.fruit.imp;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fruit.inter.PageDao;
import com.fruit.util.SpringUtil;



public class PageDaoImpl   implements PageDao
{

	/* (non-Javadoc)
	 * @see com.test.inter.PageDao#queryForPage(java.lang.String, int, int)
	 * 
	 */
	private SpringUtil springUtil;
	public SpringUtil getSpringUtil()
	{
		return springUtil;
	}


	public void setSpringUtil(SpringUtil springUtil)
	{
		this.springUtil = springUtil;
	}
	private List list;
	public List getList()
	{
		return list;
	}


	public void setList(List list)
	{
		this.list = list;
	}
	private SessionFactory sessionFactory;
	private HibernateTemplate hf=null;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
	private Query query;
	public Query getQuery()
	{
		return query;
	}


	public void setQuery(Query query)
	{
		this.query = query;
	}


	@Override
	public List queryForPage(final String hql, final int offet, final int length)
	{
		// TODO Auto-generated method stub
		
		
		/*List list=getHibernateTemplate().executeFind(new HibernateCallback()
		{

			@Override
			public Object doInHibernate(Session sess)
					throws HibernateException, SQLException
			{
				// TODO Auto-generated method stub
				Query query=sess.createQuery(hql);
				query.setFirstResult(offet);
				query.setMaxResults(length);
				List list=query.list();
				
				return list;
			}
			
		});

		*/
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		list=sess.createQuery(hql).setFirstResult(offet).setMaxResults(length).list();
		
		tx.commit();
		sess.close();
		
		return  list;
	
	}

	/* (non-Javadoc)
	 * @see com.test.inter.PageDao#getAllRowCount(java.lang.String)
	 */
	@Override
	public int getAllRowCount(String hql)
	{
		// TODO Auto-generated method stub
		System.out.println("hqlde zhi "+hql);
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int size=sess.createQuery(hql).list().size();
		tx.commit();
		sess.close();
		return size;
	}


	/*@Override*/
	/*public List queryForPart(Query query, int offet, int length)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		list=query.setMaxResults(length).setFirstResult(offet).list();
		tx.commit();
		sess.close();
		
		return  list;
		
		
		
	}*/

}
