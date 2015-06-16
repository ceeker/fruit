package com.fruit.service;

import java.util.List;

import com.fruit.dao.AdminDao;
import com.fruit.domain.Admin;
import com.fruit.domain.User;

public class AdminService
{
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<String> adminLogin(String adminId, String adminPassword)
	{
		// TODO Auto-generated method stub
		
		return adminDao.adminLogin(adminId,adminPassword);
		
	}

	public List<Admin> findAllAdmins()
	{
		// TODO Auto-generated method stub
		return adminDao.findAllAdmins();
	}

	public Admin findAdminById(String adminId)
	{
		// TODO Auto-generated method stub
		return adminDao.findAdminById(adminId);
	}

	public int updateAdminInfo(Admin admin)
	{
		// TODO Auto-generated method stub
		return adminDao.updateAdminInfo(admin);
				
	}
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return adminDao.findAllUsers();
	}

	public int deleteUserById(String userId) {
		// TODO Auto-generated method stub
		return adminDao.deleteUserById(userId);
	}

}
