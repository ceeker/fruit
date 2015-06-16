package com.fruit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.jboss.logging.Logger;

import com.fruit.domain.Advertisement;
import com.fruit.service.AdminAdService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;
import com.sun.xml.internal.bind.util.Which;

public class AdminAdProviderAction extends ActionSupport  implements  ServletRequestAware ,ServletResponseAware

{

	private HttpServletRequest request;
	private HttpServletResponse resposne;
	private Advertisement ad;
	private List<Advertisement> adList = new ArrayList<Advertisement>();
	
	public List<Advertisement> getAdList()
	{
		return adList;
	}

	public void setAdList(List<Advertisement> adList)
	{
		this.adList = adList;
	}

	public Advertisement getAd()
	{
		return ad;
	}

	public void setAd(Advertisement ad)
	{
		this.ad = ad;
	}

	private AdminAdService adminAdService;
	private File adFile;//广告图片文件
	private String fileName;
	private String flag;
	private String adId;
	private String advertisementId;
	public String getAdvertisementId()
	{
		return advertisementId;
	}

	public void setAdvertisementId(String advertisementId)
	{
		this.advertisementId = advertisementId;
	}

	/*private String adFileFileName;*/
	public File getAdFile() {
		return adFile;
	}

	public void setAdFile(File adFile) {
		this.adFile = adFile;
	}

	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public AdminAdService getAdminAdService() {
		return adminAdService;
	}

	public void setAdminAdService(AdminAdService adminAdService) {
		this.adminAdService = adminAdService;
	}

	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResposne() {
		return resposne;
	}

	public void setResposne(HttpServletResponse resposne) {
		this.resposne = resposne;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO 自动生成的方法存根
		this.resposne=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO 自动生成的方法存根
		this.request=request;
	}
	
	/**
	 * 设置广告图片名
	 * @param ad
	 * @return
	 */
	private String setFileName(Advertisement ad) {
		int num=Integer.parseInt(advertisementId);
		String fileName="default.jpg";
		switch (num) {
		case 1:
			fileName="1.jpg";
			break;
		case 2:
			fileName="2.jpg";
			break;
		case 3:
			fileName="3.jpg";
			break;
		case 4:
			fileName="4.jpg";
			break;
		case 5:
			fileName="5.jpg";
			break;
		case 6:
			fileName="6.jpg";
			break;
		case 7:
			fileName="7.jpg";
			break;
		case 8:
			fileName="8.jpg";
			break;
		default:
			fileName="default.jpg";
			break;
		}
		return fileName;
	}
	
	//管理员插入广告
	public String insertAd()
	{		
		try 
		{				
			//struts已经可以自动解析文件域，无需手动解析
			InputStream is=new FileInputStream(adFile); //读取文件	
			String path=ServletActionContext.getServletContext().getRealPath("/adPic");//广告存放路径
			String fileName=setFileName(ad);//重命名文件
			File f=new File(path,fileName);
			f.getParentFile().mkdir();	//确保adPic文件夹存在 
			OutputStream os=new FileOutputStream(f);  //将文件写入到adPic文件夹下
			byte[] b=new byte[1024];	//字节缓存
			int len=0;
			while((len=is.read(b))!=-1){  //循环写入直到结束
				os.write(b, 0, len);	//写入文件
			}
			is.close();
			os.close();
			String url="/fruit/adPic/"+fileName;			
			ad.setAdvertisementPicAddr(url);//设置广告文件的url相对地址
			int result=-1;
			if(checkHaveAd(advertisementId)){ 
				result=updataAd(ad); //数据库中已有该Ad，则更新该Ad
			}else{
				result=adminAdService.insertAd(ad);//插入广告
			}
			
			if(result==1)
			{
				flag="ok";
				return "ok";
			}else
			{
				flag="插入失败";
				return "fail";
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			flag="系统异常";
			return "error";
			}
		}
	
	public int  updataAd(Advertisement ad) {
		int result=adminAdService.updateAd(ad);
		return result;
	}
	
	//根据id查找数据库是否已存在该广告
	public Boolean  checkHaveAd(String id ) {
		Advertisement findAd=null; 
		findAd=adminAdService.getAdById(advertisementId);//根据id查找数据库是否已存在该广告
		if(findAd==null){
			return false;
		}else{
			return true;
		}
	  }
	
	//根据广告id查询广告
	public String getAdById() {
		/*System.out.println("广告的ID"+adId);
		System.out.println("广告的地址"+ad.getAdvertisementPicAddr());
		System.out.println("广告title"+ad.getAdvertisementTitle());*/
		try{
			ad=adminAdService.getAdById(advertisementId);//根据id查找数据库广告
			if(ad!=null)
			{
				flag="ok";
				return "ok";
			}else
			{
				flag="查找失败";
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag="系统异常";
			return "error";
		}
		
		
	}

	
	
	//查找所有广告
		public String getAllAd() {
			
			try{
				adList=adminAdService.getAllAd();
				if(adList.size()!=0)
				{
					flag="ok";
					return "ok";
				}else
				{
					flag="插入失败";
					return "fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				flag="系统异常";
				return "error";
			}
			
		}

	
	}
		
