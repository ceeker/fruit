package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable
{
	private String cartId;
	private Vegetable cartVegetable;
	private int  vegetableMount;
	private User user;
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public int getVegetableMount()
	{
		return vegetableMount;
	}
	public void setVegetableMount(int vegetableMount)
	{
		this.vegetableMount = vegetableMount;
	}
	private Date cartDate;
	public Date getCartDate()
	{
		return cartDate;
	}
	public void setCartDate(Date cartDate)
	{
		this.cartDate = cartDate;
	}
	public String getCartId()
	{
		return cartId;
	}
	public void setCartId(String cartId)
	{
		this.cartId = cartId;
	}
	public Vegetable getCartVegetable()
	{
		return cartVegetable;
	}
	public void setCartVegetable(Vegetable cartVegetable)
	{
		this.cartVegetable = cartVegetable;
	}
	
	
	
	
}
