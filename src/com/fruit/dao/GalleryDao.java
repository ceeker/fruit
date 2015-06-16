package com.fruit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.GalleryPic;
import com.fruit.util.SpringUtil;

public class GalleryDao
{
	
	private SpringUtil springUtil;
	
	
	public SpringUtil getSpringUtil()
	{
		return springUtil;
	}


	public void setSpringUtil(SpringUtil springUtil)
	{
		this.springUtil = springUtil;
	}

//查询所有的滚动栏图片
	public List<GalleryPic> findAllGalleryPics()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<GalleryPic> list=new ArrayList<GalleryPic>();
		try
		{
			list=sess.createQuery("from GalleryPic").list();
			
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return list;
		
	}


	public GalleryPic findGalleryPicById(String galleryPicId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		GalleryPic galleryPic;
		try
		{
			galleryPic=(GalleryPic)sess.get(GalleryPic.class,new String(galleryPicId));
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return galleryPic;
		
	}


	public String updateGalleryPicById(GalleryPic galleryPic)
	{
		// TODO Auto-generated method stub
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		GalleryPic gp;
		String flag="0";
		try
		{
			gp=(GalleryPic)sess.get(GalleryPic.class,new String(galleryPic.getGalleryPicId()));
			/*gp.setGalleryPicAddr(galleryPic.getGalleryPicAddr());*/
			gp.setGalleryPicHref(galleryPic.getGalleryPicHref());
			gp.setGalleryPicInfo(galleryPic.getGalleryPicInfo());
			gp.setGalleryPicTitle(galleryPic.getGalleryPicTitle());
			sess.save(gp);
			sess.flush();
			flag="1";
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
		
	}


	public int updateGalleryPic(String galleryPicId, String path)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int flag=0;
		try
		{
			GalleryPic gp=(GalleryPic)sess.get(GalleryPic.class, new String(galleryPicId));
			gp.setGalleryPicAddr(path);
			sess.save(gp);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
	}
	
}
