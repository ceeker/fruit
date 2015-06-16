package com.fruit.domain;

import java.io.Serializable;

public class GalleryPic implements Serializable
{
	private String galleryPicId;
	private String galleryPicTitle;
	private String galleryPicInfo;
	private String galleryPicAddr;
	private String galleryPicHref;
	public String getGalleryPicId()
	{
		return galleryPicId;
	}
	public void setGalleryPicId(String galleryPicId)
	{
		this.galleryPicId = galleryPicId;
	}
	public String getGalleryPicTitle()
	{
		return galleryPicTitle;
	}
	public void setGalleryPicTitle(String galleryPicTitle)
	{
		this.galleryPicTitle = galleryPicTitle;
	}
	public String getGalleryPicInfo()
	{
		return galleryPicInfo;
	}
	public void setGalleryPicInfo(String galleryPicInfo)
	{
		this.galleryPicInfo = galleryPicInfo;
	}
	public String getGalleryPicAddr()
	{
		return galleryPicAddr;
	}
	public void setGalleryPicAddr(String galleryPicAddr)
	{
		this.galleryPicAddr = galleryPicAddr;
	}
	public String getGalleryPicHref()
	{
		return galleryPicHref;
	}
	public void setGalleryPicHref(String galleryPicHref)
	{
		this.galleryPicHref = galleryPicHref;
	}
	
}
