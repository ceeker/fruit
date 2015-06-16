package com.fruit.domain;

import java.io.Serializable;

public class Advertisement implements Serializable
{	
	private String advertisementId;
	private String advertisementTitle;
	private String advertisementInfo;
	private String advertisementPicAddr;
	private String advertisementHref;
	public String getAdvertisementId()
	{
		return advertisementId;
	}
	public void setAdvertisementId(String advertisementId)
	{
		this.advertisementId = advertisementId;
	}
	public String getAdvertisementTitle()
	{
		return advertisementTitle;
	}
	public void setAdvertisementTitle(String advertisementTitle)
	{
		this.advertisementTitle = advertisementTitle;
	}
	public String getAdvertisementInfo()
	{
		return advertisementInfo;
	}
	public void setAdvertisementInfo(String advertisementInfo)
	{
		this.advertisementInfo = advertisementInfo;
	}
	public String getAdvertisementPicAddr()
	{
		return advertisementPicAddr;
	}
	public void setAdvertisementPicAddr(String advertisementPicAddr)
	{
		this.advertisementPicAddr = advertisementPicAddr;
	}
	public String getAdvertisementHref()
	{
		return advertisementHref;
	}
	public void setAdvertisementHref(String advertisementHref)
	{
		this.advertisementHref = advertisementHref;
	}
	
}
