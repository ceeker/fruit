package com.fruit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.GalleryPic;
import com.fruit.service.GalleryService;
import com.opensymphony.xwork2.ActionSupport;

public class GalleryPicProviderAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware
{

	private HttpServletResponse response;
	private HttpServletRequest request;
	private GalleryService  galleryService;
	List<GalleryPic> listGalleryPics=new ArrayList<GalleryPic>();
	private String galleryPicId;
	private GalleryPic galleryPic;
	private File galleryPicFile;
	private String galleryPicFileFileName;
	public String getGalleryPicFileFileName()
	{
		return galleryPicFileFileName;
	}

	public void setGalleryPicFileFileName(String galleryPicFileFileName)
	{
		this.galleryPicFileFileName = galleryPicFileFileName;
	}

	public File getGalleryPicFile()
	{
		return galleryPicFile;
	}

	public void setGalleryPicFile(File galleryPicFile)
	{
		this.galleryPicFile = galleryPicFile;
	}

	public GalleryPic getGalleryPic()
	{
		return galleryPic;
	}

	public void setGalleryPic(GalleryPic galleryPic)
	{
		this.galleryPic = galleryPic;
	}

	public String getGalleryPicId()
	{
		return galleryPicId;
	}

	public void setGalleryPicId(String galleryPicId)
	{
		this.galleryPicId = galleryPicId;
	}
	private String flag="";
	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public GalleryService getGalleryService()
	{
		return galleryService;
	}

	public void setGalleryService(GalleryService galleryService)
	{
		this.galleryService = galleryService;
	}

	public List<GalleryPic> getListGalleryPics()
	{
		return listGalleryPics;
	}

	public void setListGalleryPics(List<GalleryPic> listGalleryPics)
	{
		this.listGalleryPics = listGalleryPics;
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
	//查询所有的gallerypic
	public String findAllGalleryPics()
	{
		try
		{
			listGalleryPics=galleryService.findAllGalleryPics();
			System.out.println("gallery pic 1"+listGalleryPics.get(0).getGalleryPicAddr());
			if(listGalleryPics.size()==0)
			{
				flag="no data";
				return "fail";
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
	//查询指定的GalleryPic
	public String  findGalleryPicById()
	{
		try
		{
			galleryPic=galleryService.findGalleryPicById(galleryPicId);
			if(galleryPic!=null)
			{
				flag="ok";
				return "ok";
				
			}
			else
			{
				flag="no data";
				return "fail";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="服务器异常";
			return "error";
			
		}
		
	}
	//更新滚动栏图片信息
	public String updateGalleryPicById()
	{
		try
		{
			String result=galleryService.updateGalleryPicById(galleryPic);
			if(result.equals("0"))
			{
				flag="fail";
				return "fail";
						
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
	//更新滚动栏图片
	public String updateGalleryPic()
	{
		try
		{
			InputStream is=new FileInputStream(galleryPicFile);
			  
			//此处获取的root 路径为eclipse调试模式下的路径
			System.out.println(ServletActionContext.getServletContext());
			String root=ServletActionContext.getServletContext().getRealPath("/GalleryPicUpload");
			
			System.out.println(galleryPicFile.getAbsoluteFile().getAbsolutePath());
			
			File destFile=new File(root,galleryPicFileFileName);
			
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
			
			int result=galleryService.updateGalleryPic(galleryPicId,"/fruit/GalleryPicUpload/"+galleryPicFileFileName);
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
	
	
	
}
