package com.fruit.service;

import java.util.List;

import com.fruit.dao.AdminVegetableDao;
import com.fruit.domain.Vegetable;

public class AdminVegetableService
{
	private AdminVegetableDao adminVegetableDao;
	public AdminVegetableDao getAdminVegetableDao()
	{
		return adminVegetableDao;
	}
	public void setAdminVegetableDao(AdminVegetableDao adminVegetableDao)
	{
		this.adminVegetableDao = adminVegetableDao;
	}
	public List<Vegetable> findAllVegetables()
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findAllVegetables();
	}
	public Vegetable findVegetableById(String vegetableId)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findVegetableById(vegetableId);
		
	}
	public int insertIntoVegetable(Vegetable vegetable)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetable(vegetable);
		
	}
	public int insertIntoVegetablePic1(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic1(vegetableId,path);
	}
	public int insertIntoVegetablePic2(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic2(vegetableId,path);
		
	}
	public int insertIntoVegetablePic3(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic3(vegetableId,path);
		
		
	}
	public int insertIntoVegetablePic4(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic4(vegetableId,path);
		
	}
	public int insertIntoVegetablePic5(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic5(vegetableId,path);
	}
	
	public int insertIntoVegetablePic6(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic6(vegetableId,path);
	}
	public int insertIntoVegetablePic7(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic7(vegetableId,path);
	}
	public int insertIntoVegetablePic8(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic8(vegetableId,path);
	}
	public int insertIntoVegetablePic9(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic9(vegetableId,path);
	}
	public int insertIntoVegetablePic10(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic10(vegetableId,path);
	}
	public int insertIntoVegetablePic11(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetablePic11(vegetableId,path);
	}

	public int deleteVegetableById(String vegetableId)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.deleteVegetableById(vegetableId);
		
	}
	public int updateVegetableById(Vegetable vegetable)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.updateVegetableById(vegetable);
	}
	public int insertIntoVegetableInfoPicAddr1(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetableInfoPicAddr1(vegetableId,path);
				
		
	}

	public int insertIntoVegetableInfoPicAddr2(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetableInfoPicAddr2(vegetableId,path);
				
		
	}
	public int insertIntoVegetableInfoPicAddr3(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetableInfoPicAddr3(vegetableId,path);
				
		
	}
	public int insertIntoVegetableInfoPicAddr4(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.insertIntoVegetableInfoPicAddr4(vegetableId,path);
				
		
	}
	public List<Vegetable> findSameCatVegetable(String vegetableCatagory)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findSameCatVegetable(vegetableCatagory);
	}
	public List<Vegetable> findVegetablesBySale()
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findVegetablesBySale();
	}
	public List<Vegetable> findEightDiscountVeg()
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findEightDiscountVeg();
		
	}
	public List<Vegetable> findEightRecommandVeg()
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findEightRecommandVeg();
		
	}
	public List<String>  findHotKeyWords()
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findHotKeyWords();
		
	}
	public List<String> findHotKeysRefParam(String param)
	{
		// TODO Auto-generated method stub
		
		return adminVegetableDao.findHotKeysRefParam(param);
	}
	public List<String> findAllHotKeysRefParam(String param)
	{
		// TODO Auto-generated method stub
		return adminVegetableDao.findAllHotKeysRefParam(param);
	}
	
}
