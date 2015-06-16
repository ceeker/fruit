package com.fruit.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vegetable implements Serializable
{
	private String vegetableID;
	private String vegetableName;
	private float vegetablePrice;
	private String vegetableInfo;
	private String vegetableCatagory;
	private int   isRecommend;
	private String vegetableKeyWords;
	private String vegetableUnit;
	private long  vegetableCommentCount;
	private long vegetableSaleCount;
	public long getVegetableCommentCount()
	{
		return vegetableCommentCount;
	}
	public void setVegetableCommentCount(long vegetableCommentCount)
	{
		this.vegetableCommentCount = vegetableCommentCount;
	}
	public long getVegetableSaleCount()
	{
		return vegetableSaleCount;
	}
	public void setVegetableSaleCount(long vegetableSaleCount)
	{
		this.vegetableSaleCount = vegetableSaleCount;
	}
	public String getVegetableCatagory()
	{
		return vegetableCatagory;
	}
	public void setVegetableCatagory(String vegetableCatagory)
	{
		this.vegetableCatagory = vegetableCatagory;
	}
	public int getIsRecommend()
	{
		return isRecommend;
	}
	public void setIsRecommend(int isRecommend)
	{
		this.isRecommend = isRecommend;
	}
	public String getVegetableKeyWords()
	{
		return vegetableKeyWords;
	}
	public void setVegetableKeyWords(String vegetableKeyWords)
	{
		this.vegetableKeyWords = vegetableKeyWords;
	}
	public String getVegetableUnit()
	{
		return vegetableUnit;
	}
	public void setVegetableUnit(String vegetableUnit)
	{
		this.vegetableUnit = vegetableUnit;
	}
	//蔬菜介绍信息以图片的形式进行插入
	private List<String> vegetableInfoPicAddr=new ArrayList<String>();
	public List<String> getVegetableInfoPicAddr()
	{
		return vegetableInfoPicAddr;
	}
	public void setVegetableInfoPicAddr(List<String> vegetableInfoPicAddr)
	{
		this.vegetableInfoPicAddr = vegetableInfoPicAddr;
	}
	private int vegetableQuantity;
	private	float  vegetableDiscount;
	private List<String> vegetablePicAddr=new ArrayList<String>();
	public String getVegetableID()
	{
		return vegetableID;
	}
	public void setVegetableID(String vegetableID)
	{
		this.vegetableID = vegetableID;
	}
	public String getVegetableName()
	{
		return vegetableName;
	}
	public void setVegetableName(String vegetableName)
	{
		this.vegetableName = vegetableName;
	}
	public float getVegetablePrice()
	{
		return vegetablePrice;
	}
	public void setVegetablePrice(float vegetablePrice)
	{
		this.vegetablePrice = vegetablePrice;
	}
	public String getVegetableInfo()
	{
		return vegetableInfo;
	}
	public void setVegetableInfo(String vegetableInfo)
	{
		this.vegetableInfo = vegetableInfo;
	}
	public int getVegetableQuantity()
	{
		return vegetableQuantity;
	}
	public void setVegetableQuantity(int vegetableQuantity)
	{
		this.vegetableQuantity = vegetableQuantity;
	}
	public float getVegetableDiscount()
	{
		return vegetableDiscount;
	}
	public void setVegetableDiscount(float vegetableDiscount)
	{
		this.vegetableDiscount = vegetableDiscount;
	}
	public List<String> getVegetablePicAddr()
	{
		return vegetablePicAddr;
	}
	public void setVegetablePicAddr(List<String> vegetablePicAddr)
	{
		this.vegetablePicAddr = vegetablePicAddr;
	}
	
}
