package com.fruit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.Admin;
import com.fruit.domain.Vegetable;
import com.fruit.service.AdminVegetableService;
import com.opensymphony.xwork2.ActionSupport;
import com.fruit.util.*;
public class AdminVegetableProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware
{
	private List<Vegetable> listVegetables=new ArrayList<Vegetable>();
	
	private String flag;
	private Vegetable vegetable;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private AdminVegetableService adminVegetableService;
	private String vegetableId;
	
	private File  vegetablePic1;
	private File  vegetablePic2;
	private File  vegetablePic3;
	private File  vegetablePic4;
	private File  vegetablePic5;
	private File  vegetablePic6;
	private File  vegetablePic7;
	private File  vegetablePic8;
	private File  vegetablePic9;
	private File  vegetablePic10;
	private File  vegetablePic11;

	private String vegetablePic1FileName;
	private String vegetablePic2FileName;
	private String vegetablePic3FileName;
	private String vegetablePic4FileName;
	private String vegetablePic5FileName;
	private String vegetablePic6FileName;
	private String vegetablePic7FileName;
	private String vegetablePic8FileName;
	private String vegetablePic9FileName;
	private String vegetablePic10FileName;
	private String vegetablePic11FileName;

	private File vegetableInfoPicAddr1;
	private File vegetableInfoPicAddr2;	
	private File vegetableInfoPicAddr3;
	private File vegetableInfoPicAddr4;
	private String vegetableInfoPicAddr1FileName;
	private String vegetableInfoPicAddr2FileName;
	private String vegetableInfoPicAddr3FileName;
	private String vegetableInfoPicAddr4FileName;
	private String vegetableID;


	private String vegetableCatagory;
	private List<Vegetable> listOfCat=new ArrayList<Vegetable>();
	private List<Vegetable> listOfEgihtDiscount=new ArrayList<Vegetable>();
	private List<Vegetable> listOfEgihtRecommand=new ArrayList<Vegetable>();
	private List<String> listKeyWords=new ArrayList<String>();
	private String param;//根据类别去查找关键字
	
	
	public String getVegetableID()
	{
		return vegetableID;
	}

	public void setVegetableID(String vegetableID)
	{
		this.vegetableID = vegetableID;
	}

	public String getVegetablePic7FileName()
	{
		return vegetablePic7FileName;
	}

	public void setVegetablePic7FileName(String vegetablePic7FileName)
	{
		this.vegetablePic7FileName = vegetablePic7FileName;
	}

	public String getVegetablePic8FileName()
	{
		return vegetablePic8FileName;
	}

	public void setVegetablePic8FileName(String vegetablePic8FileName)
	{
		this.vegetablePic8FileName = vegetablePic8FileName;
	}

	public String getVegetablePic9FileName()
	{
		return vegetablePic9FileName;
	}

	public void setVegetablePic9FileName(String vegetablePic9FileName)
	{
		this.vegetablePic9FileName = vegetablePic9FileName;
	}

	public String getVegetablePic10FileName()
	{
		return vegetablePic10FileName;
	}

	public void setVegetablePic10FileName(String vegetablePic10FileName)
	{
		this.vegetablePic10FileName = vegetablePic10FileName;
	}

	public String getVegetablePic11FileName()
	{
		return vegetablePic11FileName;
	}

	public void setVegetablePic11FileName(String vegetablePic11FileName)
	{
		this.vegetablePic11FileName = vegetablePic11FileName;
	}

	public File getVegetablePic7()
	{
		return vegetablePic7;
	}

	public void setVegetablePic7(File vegetablePic7)
	{
		this.vegetablePic7 = vegetablePic7;
	}

	public File getVegetablePic8()
	{
		return vegetablePic8;
	}

	public void setVegetablePic8(File vegetablePic8)
	{
		this.vegetablePic8 = vegetablePic8;
	}

	public File getVegetablePic9()
	{
		return vegetablePic9;
	}

	public void setVegetablePic9(File vegetablePic9)
	{
		this.vegetablePic9 = vegetablePic9;
	}

	public File getVegetablePic10()
	{
		return vegetablePic10;
	}

	public void setVegetablePic10(File vegetablePic10)
	{
		this.vegetablePic10 = vegetablePic10;
	}

	public File getVegetablePic11()
	{
		return vegetablePic11;
	}

	public void setVegetablePic11(File vegetablePic11)
	{
		this.vegetablePic11 = vegetablePic11;
	}

	public String getParam()
	{
		return param;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public List<String> getListKeyWords()
	{
		return listKeyWords;
	}

	public void setListKeyWords(List<String> listKeyWords)
	{
		this.listKeyWords = listKeyWords;
	}

	public List<Vegetable> getListOfEgihtRecommand()
	{
		return listOfEgihtRecommand;
	}

	public void setListOfEgihtRecommand(List<Vegetable> listOfEgihtRecommand)
	{
		this.listOfEgihtRecommand = listOfEgihtRecommand;
	}

	public List<Vegetable> getListOfEgihtDiscount()
	{
		return listOfEgihtDiscount;
	}

	public void setListOfEgihtDiscount(List<Vegetable> listOfEgihtDiscount)
	{
		this.listOfEgihtDiscount = listOfEgihtDiscount;
	}
	private List<Vegetable> listOfSale=new ArrayList<Vegetable>();
	
	public List<Vegetable> getListOfSale()
	{
		return listOfSale;
	}

	public void setListOfSale(List<Vegetable> listOfSale)
	{
		this.listOfSale = listOfSale;
	}

	

	public List<Vegetable> getListOfCat()
	{
		return listOfCat;
	}

	public void setListOfCat(List<Vegetable> listOfCat)
	{
		this.listOfCat = listOfCat;
	}

	public String getVegetableCatagory()
	{
		return vegetableCatagory;
	}

	public void setVegetableCatagory(String vegetableCatagory)
	{
		this.vegetableCatagory = vegetableCatagory;
	}

	public String getVegetablePic6FileName()
	{
		return vegetablePic6FileName;
	}

	public void setVegetablePic6FileName(String vegetablePic6FileName)
	{
		this.vegetablePic6FileName = vegetablePic6FileName;
	}

	public File getVegetablePic6()
	{
		return vegetablePic6;
	}

	public void setVegetablePic6(File vegetablePic6)
	{
		this.vegetablePic6 = vegetablePic6;
	}

	public File getVegetableInfoPicAddr1()
	{
		return vegetableInfoPicAddr1;
	}

	public void setVegetableInfoPicAddr1(File vegetableInfoPicAddr1)
	{
		this.vegetableInfoPicAddr1 = vegetableInfoPicAddr1;
	}

	public File getVegetableInfoPicAddr2()
	{
		return vegetableInfoPicAddr2;
	}

	public void setVegetableInfoPicAddr2(File vegetableInfoPicAddr2)
	{
		this.vegetableInfoPicAddr2 = vegetableInfoPicAddr2;
	}

	public File getVegetableInfoPicAddr3()
	{
		return vegetableInfoPicAddr3;
	}

	public void setVegetableInfoPicAddr3(File vegetableInfoPicAddr3)
	{
		this.vegetableInfoPicAddr3 = vegetableInfoPicAddr3;
	}

	public File getVegetableInfoPicAddr4()
	{
		return vegetableInfoPicAddr4;
	}

	public void setVegetableInfoPicAddr4(File vegetableInfoPicAddr4)
	{
		this.vegetableInfoPicAddr4 = vegetableInfoPicAddr4;
	}

	public String getVegetableInfoPicAddr1FileName()
	{
		return vegetableInfoPicAddr1FileName;
	}

	public void setVegetableInfoPicAddr1FileName(
			String vegetableInfoPicAddr1FileName)
	{
		this.vegetableInfoPicAddr1FileName = vegetableInfoPicAddr1FileName;
	}

	public String getVegetableInfoPicAddr2FileName()
	{
		return vegetableInfoPicAddr2FileName;
	}

	public void setVegetableInfoPicAddr2FileName(
			String vegetableInfoPicAddr2FileName)
	{
		this.vegetableInfoPicAddr2FileName = vegetableInfoPicAddr2FileName;
	}

	public String getVegetableInfoPicAddr3FileName()
	{
		return vegetableInfoPicAddr3FileName;
	}

	public void setVegetableInfoPicAddr3FileName(
			String vegetableInfoPicAddr3FileName)
	{
		this.vegetableInfoPicAddr3FileName = vegetableInfoPicAddr3FileName;
	}

	public String getVegetableInfoPicAddr4FileName()
	{
		return vegetableInfoPicAddr4FileName;
	}

	public void setVegetableInfoPicAddr4FileName(
			String vegetableInfoPicAddr4FileName)
	{
		this.vegetableInfoPicAddr4FileName = vegetableInfoPicAddr4FileName;
	}
	
	
	
	public String getVegetablePic1FileName()
	{
		return vegetablePic1FileName;
	}

	public void setVegetablePic1FileName(String vegetablePic1FileName)
	{
		this.vegetablePic1FileName = vegetablePic1FileName;
	}

	public String getVegetablePic2FileName()
	{
		return vegetablePic2FileName;
	}

	public void setVegetablePic2FileName(String vegetablePic2FileName)
	{
		this.vegetablePic2FileName = vegetablePic2FileName;
	}

	public String getVegetablePic3FileName()
	{
		return vegetablePic3FileName;
	}

	public void setVegetablePic3FileName(String vegetablePic3FileName)
	{
		this.vegetablePic3FileName = vegetablePic3FileName;
	}

	public String getVegetablePic4FileName()
	{
		return vegetablePic4FileName;
	}

	public void setVegetablePic4FileName(String vegetablePic4FileName)
	{
		this.vegetablePic4FileName = vegetablePic4FileName;
	}

	public String getVegetablePic5FileName()
	{
		return vegetablePic5FileName;
	}

	public void setVegetablePic5FileName(String vegetablePic5FileName)
	{
		this.vegetablePic5FileName = vegetablePic5FileName;
	}

	public File getVegetablePic1()
	{
		return vegetablePic1;
	}

	public void setVegetablePic1(File vegetablePic1)
	{
		this.vegetablePic1 = vegetablePic1;
	}

	public File getVegetablePic2()
	{
		return vegetablePic2;
	}

	public void setVegetablePic2(File vegetablePic2)
	{
		this.vegetablePic2 = vegetablePic2;
	}

	public File getVegetablePic3()
	{
		return vegetablePic3;
	}

	public void setVegetablePic3(File vegetablePic3)
	{
		this.vegetablePic3 = vegetablePic3;
	}

	public File getVegetablePic4()
	{
		return vegetablePic4;
	}

	public void setVegetablePic4(File vegetablePic4)
	{
		this.vegetablePic4 = vegetablePic4;
	}

	public File getVegetablePic5()
	{
		return vegetablePic5;
	}

	public void setVegetablePic5(File vegetablePic5)
	{
		this.vegetablePic5 = vegetablePic5;
	}
	
	public Vegetable getVegetable()
	{
		return vegetable;
	}

	public void setVegetable(Vegetable vegetable)
	{
		this.vegetable = vegetable;
	}
	public String getVegetableId()
	{
		return vegetableId;
	}

	public void setVegetableId(String vegetableId)
	{
		this.vegetableId = vegetableId;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public AdminVegetableService getAdminVegetableService()
	{
		return adminVegetableService;
	}

	public void setAdminVegetableService(AdminVegetableService adminVegetableService)
	{
		this.adminVegetableService = adminVegetableService;
	}

	

	public HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	public List<Vegetable> getListVegetables()
	{
		return listVegetables;
	}

	public void setListVegetables(List<Vegetable> listVegetables)
	{
		this.listVegetables = listVegetables;
	}
	
	
	
	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		this.response=response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		// TODO Auto-generated method stub
		this.request=request;
	}
	//管理员查询所有的蔬菜
	public String findAllVegetables()
	{
		try
		{
			listVegetables=adminVegetableService.findAllVegetables();
			if(listVegetables.size()==0)
			{ 
				flag="no vegetales";
				return "ok";
			}
			else
			{
				flag="ok";
				return "ok";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="服务器异常";
			return "error";
		}
	}
	//管理员查看单个蔬菜
	public String findVegetableById()
	{
		try
		{
			vegetable=adminVegetableService.findVegetableById(vegetableId);
			if(vegetable!=null)
			{
				flag="ok";
				System.out.print("蔬菜图片的地址"+vegetable.getVegetablePicAddr().get(2).toString());
				System.out.println("应用根路径"+ServletActionContext.getServletContext().getContextPath());
						return "ok";
			}
			else
			{
				flag="no vegetbable";
				return "fail";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
	
	}
	//插入蔬菜
	public String insertIntoVegetable()
	{
		try
		{
			Admin o=(Admin) request.getSession().getAttribute("admin");
			if(o==null)
			{
				flag="您还没有登陆 ，请先登陆之后再进行蔬菜的插入操作！";
				return "fail";
			}
			vegetableID=o.getAdminId()+DateFormatUtil.getInstance().format(new Date());
			vegetable.setVegetableID(vegetableID);
			int result=adminVegetableService.insertIntoVegetable(vegetable);
			if(result==1)
			{
				flag="ok";
				return "ok";
			}
			else
			{
				flag="insert fail";
				return "fail";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
		
	}

	//插入蔬菜图片1
	public String insertOrUpdateVegetablePic1()
	{
		try
		{
			InputStream is=new FileInputStream(vegetablePic1);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
			
			System.out.println(vegetablePic1.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetablePic1FileName);
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetablePic1(vegetableId,"/vegetableUpload/"+vegetablePic1FileName);
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	//插入蔬菜图片2
	public String insertOrUpdateVegetablePic2()
	{
		try
		{
			InputStream is=new FileInputStream(vegetablePic2);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
			
			System.out.println(vegetablePic2.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetablePic2FileName);
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetablePic2(vegetableId,"/vegetableUpload/"+vegetablePic2FileName);
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	//插入蔬菜图片3
	public String insertOrUpdateVegetablePic3()
	{
		try
		{
			InputStream is=new FileInputStream(vegetablePic3);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
			
			System.out.println(vegetablePic3.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetablePic3FileName);
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetablePic3(vegetableId,"/vegetableUpload/"+vegetablePic3FileName);
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	//插入蔬菜图片4
	public String insertOrUpdateVegetablePic4()
	{
		try
		{
			InputStream is=new FileInputStream(vegetablePic4);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
			
			System.out.println(vegetablePic4.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetablePic4FileName);
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetablePic4(vegetableId,"/vegetableUpload/"+vegetablePic4FileName);
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	//插入蔬菜图片5
	public String insertOrUpdateVegetablePic5()
	{
		try
		{
			InputStream is=new FileInputStream(vegetablePic5);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
			
			System.out.println(vegetablePic5.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetablePic5FileName);
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetablePic5(vegetableId,"/vegetableUpload/"+vegetablePic5FileName);
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	public String insertOrUpdateVegetablePic6()
	{
		try
		{
			InputStream is=new FileInputStream(vegetablePic6);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
			
			System.out.println(vegetablePic6.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetablePic6FileName);
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetablePic6(vegetableId,"/vegetableUpload/"+vegetablePic6FileName);
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	
	//插入蔬菜图片7
			public String insertOrUpdateVegetablePic7()
			{
				try
				{
					InputStream is=new FileInputStream(vegetablePic7);
					  
					//此处获取的root 路径为eclipse调试模式下的路径
					//System.out.println(ServletActionContext.getServletContext());
					String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
					
					//System.out.println(vegetablePic1.getAbsoluteFile().getAbsolutePath());
					
					File destFile=new File(root,vegetablePic7FileName);
					
					//System.out.println(destFile.getAbsolutePath());
					//System.out.println(root);
					if(!destFile.exists())
					{
					destFile.getParentFile().mkdirs();
					}
					destFile.setReadable(true);
					destFile.setWritable(true);

					
					OutputStream os=new FileOutputStream(destFile);
					byte[] buffer=new byte[1024];
					int length=0;
					while((length=is.read(buffer))>0)
					{
						os.write(buffer, 0, length);
						
					}
					is.close();
					os.close();
					
					int result=adminVegetableService.insertIntoVegetablePic7(vegetableId,"/vegetableUpload/"+vegetablePic7FileName);
					if(result==1)
					{
						return "ok";
					}
					
				} 
				catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error";
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error";
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error";
				}
				return "fail";
			}
			
			
			//插入蔬菜图片8
					public String insertOrUpdateVegetablePic8()
					{
						try
						{
							InputStream is=new FileInputStream(vegetablePic8);
							  
							//此处获取的root 路径为eclipse调试模式下的路径
							//System.out.println(ServletActionContext.getServletContext());
							String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
							
							//System.out.println(vegetablePic1.getAbsoluteFile().getAbsolutePath());
							
							File destFile=new File(root,vegetablePic8FileName);
							
							//System.out.println(destFile.getAbsolutePath());
							//System.out.println(root);
							if(!destFile.exists())
							{
							destFile.getParentFile().mkdirs();
							}
							destFile.setReadable(true);
							destFile.setWritable(true);

							
							OutputStream os=new FileOutputStream(destFile);
							byte[] buffer=new byte[1024];
							int length=0;
							while((length=is.read(buffer))>0)
							{
								os.write(buffer, 0, length);
								
							}
							is.close();
							os.close();
							
							int result=adminVegetableService.insertIntoVegetablePic8(vegetableId,"/vegetableUpload/"+vegetablePic8FileName);
							if(result==1)
							{
								return "ok";
							}
							
						} 
						catch (FileNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						}
						return "fail";
					}
					//插入蔬菜图片9
					public String insertOrUpdateVegetablePic9()
					{
						try
						{
							InputStream is=new FileInputStream(vegetablePic9);
							  
							//此处获取的root 路径为eclipse调试模式下的路径
							//System.out.println(ServletActionContext.getServletContext());
							String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
							
							//System.out.println(vegetablePic1.getAbsoluteFile().getAbsolutePath());
							
							File destFile=new File(root,vegetablePic9FileName);
							
							//System.out.println(destFile.getAbsolutePath());
							//System.out.println(root);
							if(!destFile.exists())
							{
							destFile.getParentFile().mkdirs();
							}
							destFile.setReadable(true);
							destFile.setWritable(true);

							
							OutputStream os=new FileOutputStream(destFile);
							byte[] buffer=new byte[1024];
							int length=0;
							while((length=is.read(buffer))>0)
							{
								os.write(buffer, 0, length);
								
							}
							is.close();
							os.close();
							
							int result=adminVegetableService.insertIntoVegetablePic9(vegetableId,"/vegetableUpload/"+vegetablePic9FileName);
							if(result==1)
							{
								return "ok";
							}
							
						} 
						catch (FileNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						}
						return "fail";
					}	
		
					//插入蔬菜图片8
					public String insertOrUpdateVegetablePic10()
					{
						try
						{
							InputStream is=new FileInputStream(vegetablePic10);
							  
							//此处获取的root 路径为eclipse调试模式下的路径
							//System.out.println(ServletActionContext.getServletContext());
							String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
							
							//System.out.println(vegetablePic1.getAbsoluteFile().getAbsolutePath());
							
							File destFile=new File(root,vegetablePic10FileName);
							
							//System.out.println(destFile.getAbsolutePath());
							//System.out.println(root);
							if(!destFile.exists())
							{
							destFile.getParentFile().mkdirs();
							}
							destFile.setReadable(true);
							destFile.setWritable(true);

							
							OutputStream os=new FileOutputStream(destFile);
							byte[] buffer=new byte[1024];
							int length=0;
							while((length=is.read(buffer))>0)
							{
								os.write(buffer, 0, length);
								
							}
							is.close();
							os.close();
							
							int result=adminVegetableService.insertIntoVegetablePic10(vegetableId,"/vegetableUpload/"+vegetablePic10FileName);
							if(result==1)
							{
								return "ok";
							}
							
						} 
						catch (FileNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						}
						return "fail";
					}
					
					//插入蔬菜图片11
					public String insertOrUpdateVegetablePic11()
					{
						try
						{
							InputStream is=new FileInputStream(vegetablePic11);
							  
							//此处获取的root 路径为eclipse调试模式下的路径
							//System.out.println(ServletActionContext.getServletContext());
							String root=ServletActionContext.getServletContext().getRealPath("/vegetableUpload");
							
							//System.out.println(vegetablePic11.getAbsoluteFile().getAbsolutePath());
							
							File destFile=new File(root,vegetablePic11FileName);
							
							//System.out.println(destFile.getAbsolutePath());
							//System.out.println(root);
							if(!destFile.exists())
							{
							destFile.getParentFile().mkdirs();
							}
							destFile.setReadable(true);
							destFile.setWritable(true);

							
							OutputStream os=new FileOutputStream(destFile);
							byte[] buffer=new byte[1024];
							int length=0;
							while((length=is.read(buffer))>0)
							{
								os.write(buffer, 0, length);
								
							}
							is.close();
							os.close();
							
							int result=adminVegetableService.insertIntoVegetablePic11(vegetableId,"/vegetableUpload/"+vegetablePic11FileName);
							if(result==1)
							{
								return "ok";
							}
							
						} 
						catch (FileNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						} catch (Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							return "error";
						}
						return "fail";
					}
	//管理员删除指定蔬菜
	public String deleteVegetableById()
	{
		try
		{
			int result=adminVegetableService.deleteVegetableById(vegetableId);
			if(result==1)
			{
				return "ok";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	//管理员更新指定蔬菜
	public String updateVegetableById()
	{
		try
		{
			int result=adminVegetableService.updateVegetableById(vegetable);
			if(result==1)
			{
				return "ok";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	//管理员插入蔬菜图片描述信息1
	public String insertIntoVegetableInfoPicAdddr1()
	{
		
		
		try
		{
			InputStream is=new FileInputStream(vegetableInfoPicAddr1);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableInfoPicUpload");
			
			System.out.println(vegetableInfoPicAddr1.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetableInfoPicAddr1FileName+DateFormatUtil.getInstance().format(new Date()));
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetableInfoPicAddr1(vegetableId,"/vegetableInfoPicUpload/"+vegetableInfoPicAddr1FileName+DateFormatUtil.getInstance().format(new Date()));
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
		
	}
	
	public String insertIntoVegetableInfoPicAdddr2()
	{
		
		
		try
		{
			InputStream is=new FileInputStream(vegetableInfoPicAddr2);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableInfoPicUpload");
			
			System.out.println(vegetableInfoPicAddr2.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetableInfoPicAddr2FileName+DateFormatUtil.getInstance().format(new Date()));
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetableInfoPicAddr2(vegetableId,"/vegetableInfoPicUpload/"+vegetableInfoPicAddr2FileName+DateFormatUtil.getInstance().format(new Date()));
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
		
	}
	public String insertIntoVegetableInfoPicAdddr3()
	{
		
		
		try
		{
			InputStream is=new FileInputStream(vegetableInfoPicAddr3);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableInfoPicUpload");
			
			System.out.println(vegetableInfoPicAddr3.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetableInfoPicAddr3FileName+DateFormatUtil.getInstance().format(new Date()));
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetableInfoPicAddr3(vegetableId,"/vegetableInfoPicUpload/"+vegetableInfoPicAddr3FileName+DateFormatUtil.getInstance().format(new Date()));
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
		
	}

	public String insertIntoVegetableInfoPicAdddr4()
	{
		
		
		try
		{
			InputStream is=new FileInputStream(vegetableInfoPicAddr4);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/vegetableInfoPicUpload");
			
			System.out.println(vegetableInfoPicAddr4.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,vegetableInfoPicAddr4FileName+DateFormatUtil.getInstance().format(new Date()));
			
			System.out.println(destFile.getAbsolutePath());
			System.out.println(root);
			if(!destFile.exists())
			{
			destFile.getParentFile().mkdirs();
			}
			destFile.setReadable(true);
			destFile.setWritable(true);

			
			OutputStream os=new FileOutputStream(destFile);
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=is.read(buffer))>0)
			{
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			
			int result=adminVegetableService.insertIntoVegetableInfoPicAddr4(vegetableId,"/vegetableInfoPicUpload/"+vegetableInfoPicAddr4FileName+DateFormatUtil.getInstance().format(new Date()));
			if(result==1)
			{
				return "ok";
			}
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "fail";
		
	}

	
	//根据蔬菜的类别查找蔬菜
	public String findVegetablesByCat()
	{
		try
		{
			System.out.println("传过来的catalog参数"+vegetableCatagory);
			listOfCat=adminVegetableService.findSameCatVegetable(vegetableCatagory);
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
		
		
		
	}
	//查找热销商品
	public String findVegetablesBySale()
	{
		try
		{
			System.out.println("执行查询热销商品的方法");
			listOfSale=adminVegetableService.findVegetablesBySale();
			flag="ok";
			return"ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
		
		
		
	}
	//查询随机所有的八个特价商品,用于首页展示
	public String findEightDisCountVeg()
	{
		
		try
		{
			listOfEgihtDiscount=adminVegetableService.findEightDiscountVeg();
			
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
		
		
		
		
	}
	//随机查询八个推荐蔬菜，用于首页展示
	public String findEightRecommandVeg()
	{
		try
		{
			listOfEgihtRecommand=adminVegetableService.findEightRecommandVeg();
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
	}
	//向首页提供热门关键字
	public String findHotKeyWords()
	{
		listKeyWords=adminVegetableService.findHotKeyWords();
		return "ok";
	}
	
	//提供关键词，在productslist.jsp
	public String findHotKeysRefParam()
	{
		System.out.println("hotKeys  param value:"+param);
		listKeyWords=adminVegetableService.findHotKeysRefParam(param);
		
		return "ok";
	}
	//查找全部关键字，根据参数，在listproducts。jsp
	public String findAllHotKeysRefParam()
	{
		System.out.println("allhotKeys  param value:"+param);
		listKeyWords=adminVegetableService.findAllHotKeysRefParam(param);
		
		return "ok";
	}
	
 
}
