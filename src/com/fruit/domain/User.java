package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String userSex;
	private String userPassword;
	private String userPhone;
	private Date userBirth;
	private  String userMail;
	private String userAddr;
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserSex()
	{
		return userSex;
	}
	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone()
	{
		return userPhone;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
	public Date getUserBirth()
	{
		return userBirth;
	}
	public void setUserBirth(Date userBirth)
	{
		this.userBirth = userBirth;
	}
	public String getUserMail()
	{
		return userMail;
	}
	public void setUserMail(String userMail)
	{
		this.userMail = userMail;
	}
	public String getUserAddr()
	{
		return userAddr;
	}
	public void setUserAddr(String userAddr)
	{
		this.userAddr = userAddr;
	}
	
}
