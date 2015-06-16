package com.fruit.service;

import java.util.List;

import com.fruit.dao.GalleryDao;
import com.fruit.domain.GalleryPic;

public class GalleryService
{
	private GalleryDao galleryDao;

	public GalleryDao getGalleryDao()
	{
		return galleryDao;
	}

	public void setGalleryDao(GalleryDao galleryDao)
	{
		this.galleryDao = galleryDao;
	}

	public List<GalleryPic> findAllGalleryPics()
	{
		// TODO Auto-generated method stub
		return galleryDao.findAllGalleryPics();
	}

	public GalleryPic findGalleryPicById(String galleryPicId)
	{
		// TODO Auto-generated method stub
		return galleryDao.findGalleryPicById(galleryPicId);
	}

	public String updateGalleryPicById(GalleryPic galleryPic)
	{
		// TODO Auto-generated method stub
		return galleryDao.updateGalleryPicById(galleryPic);
		
	}

	public int updateGalleryPic(String galleryPicId, String path)
	{
		// TODO Auto-generated method stub
		
		return galleryDao.updateGalleryPic(galleryPicId,path);
	}
}
