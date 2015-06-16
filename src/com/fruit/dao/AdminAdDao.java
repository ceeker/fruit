package com.fruit.dao;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fruit.domain.Advertisement;
import com.fruit.util.SpringUtil;

public class AdminAdDao 
{

	private SpringUtil springUtil;
	
	public SpringUtil getSpringUtil() {
		return springUtil;
	}
	
	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}


	//管理员插入广告
	public int insertAd(Advertisement ad)
	{
		// TODO 自动生成的方法存根
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int flag=0;
		try {
			sess.save(ad);
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			tx.rollback();
			
			throw new HibernateException("系统异常");
			
		}
		finally
		{
			tx.commit();
			sess.close();
		}
				
		return flag;
	}
	
	//广告更新
	public int updateAd(Advertisement ad) {
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int flag=0;
		try {
			sess.update(ad);
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
			
		}
		finally
		{
			tx.commit();
			sess.close();
		}
				
		return flag;
		
	}
	
	//查找所有广告
	public List<Advertisement> getAllAd() {
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Advertisement> listAd=new ArrayList<Advertisement>();
		try
		{
			listAd=sess.createQuery("from Advertisement").list();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
			
		}finally
		{
			tx.commit();
			sess.close();
			
		}
		
		return listAd;
		
	}
	
	//根据id查找广告
	public Advertisement getAdById(String advertisementId ) {
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Advertisement advertisement;
		try
		{
			advertisement=(Advertisement) sess.get(Advertisement.class, new String(advertisementId));
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return advertisement;
	}
	

}
