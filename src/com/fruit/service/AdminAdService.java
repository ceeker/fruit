package com.fruit.service;

import java.util.List;

import com.fruit.dao.AdminAdDao;
import com.fruit.domain.Advertisement;

public class AdminAdService 
{

	private AdminAdDao adminAdDao;

	public AdminAdDao getAdminAdDao() {
		return adminAdDao;
	}

	public void setAdminAdDao(AdminAdDao adminAdDao) {
		this.adminAdDao = adminAdDao;
	}

	public int insertAd(Advertisement ad) 
	{
		// TODO 自动生成的方法存根
		return 	adminAdDao.insertAd(ad);
	}
	
	public int updateAd(Advertisement ad){
		return 	adminAdDao.updateAd(ad);
	}
	
	public  List<Advertisement> getAllAd(){
		return 	adminAdDao.getAllAd();
	}
	
	public Advertisement getAdById(String advertisementId ) {
		return adminAdDao.getAdById(advertisementId );
	}
	
	

}
