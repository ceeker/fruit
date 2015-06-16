package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable
{
	private String adminId;
	private String adminName;
	private String adminPassword;
	private String adminSex;
	private Date  adminBirth;
	private int adminRight;
	public String getAdminId()
	{
		return adminId;
	}
	public void setAdminId(String adminId)
	{
		this.adminId = adminId;
	}
	public String getAdminName()
	{
		return adminName;
	}
	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}
	public String getAdminPassword()
	{
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword)
	{
		this.adminPassword = adminPassword;
	}
	public String getAdminSex()
	{
		return adminSex;
	}
	public void setAdminSex(String adminSex)
	{
		this.adminSex = adminSex;
	}
	public Date getAdminBirth()
	{
		return adminBirth;
	}
	public void setAdminBirth(Date adminBirth)
	{
		this.adminBirth = adminBirth;
	}
	public int getAdminRight()
	{
		return adminRight;
	}
	public void setAdminRight(int adminRight)
	{
		this.adminRight = adminRight;
	} 
}
