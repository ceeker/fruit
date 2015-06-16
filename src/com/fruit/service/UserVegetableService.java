package com.fruit.service;

import java.util.List;

import com.fruit.dao.UserVegetableDao;
import com.fruit.domain.Book;
import com.fruit.domain.Cart;
import com.fruit.domain.Vegetable;

public class UserVegetableService
{

	private UserVegetableDao userVegetableDao;

	public UserVegetableDao getUserVegetableDao()
	{
		return userVegetableDao;
	}

	public void setUserVegetableDao(UserVegetableDao userVegetableDao)
	{
		this.userVegetableDao = userVegetableDao;
	}

	public List<Vegetable> getAllVegetables()
	{
		// TODO Auto-generated method stub
		return userVegetableDao.getAllVegetables();
	}

	public Vegetable findVegtableById(String vegetableID)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findVegetableById(vegetableID);
	}

	public List<Vegetable> findVegetableByKeyWord(int offset,int length,String keyWord,String order,String sort)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findVegetableByKeyWord(offset,length,keyWord,order,sort);
	}

	public int insertIntoCart(String userId, String vegetableID ,int vegetableMount ) 
	{
		// TODO Auto-generated method stub
		return userVegetableDao.insertIntoCart(userId,vegetableID, vegetableMount);
		
	}

	public int updateCartVegetableMount(String cartId,int vegetableMount)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.updateVegetableMount(cartId,vegetableMount);
	}

	public int deleteCart(String cartId)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.deleteCart(cartId);
	}

	public Cart findCart(String cartId)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findCart(cartId);
	}

	public long countCart(String userId)
	{
		// TODO Auto-generated method stub
		
		return userVegetableDao.countCart(userId);
	}

	public List findAllCart(String userId)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findAllCart(userId);
	}

	public List<Book> book(List<Book> listBooks)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.book(listBooks);
	}

	public List<Vegetable>  findSaleVegetables(Integer hotoffset, Integer hotlength,
			String order, String sort)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findSaleVegetables(hotoffset,hotlength,order,sort);
		
	}

	public List<Vegetable> findFreshVegetables(Integer freshoffset,
			Integer freshlength, String order, String sort)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findFreshVegetables(freshoffset,freshlength,order,sort);
		
	}

	public List<Vegetable> findDiscountVegetables(Integer discountoffset,
			Integer discountlength, String order, String sort)
	{
		// TODO Auto-generated method stub
		return userVegetableDao.findDiscountVegetables(discountoffset,discountlength,order,sort);
	}

	public List<Book> findBook(String userId)
	{
		// TODO Auto-generated method stub
		
		return userVegetableDao.findBook(userId);
	}

}
