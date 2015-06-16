package com.fruit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.Admin;
import com.fruit.domain.User;
import com.fruit.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware
{
	private Admin admin;
	private AdminService adminService;
	private String adminId;
	private String reAdminpassword;
	private String userId;
	private List<User> listAllUsers = new ArrayList<User>();
	public List<User> getListAllUsers()
	{
		return listAllUsers;
	}


	public void setListAllUsers(List<User> listAllUsers)
	{
		this.listAllUsers = listAllUsers;
	}


	public String getUserId()
	{
		return userId;
	}


	public void setUserId(String userId)
	{
		this.userId = userId;
	}


	public String getReAdminpassword()
	{
		return reAdminpassword;
	}


	public void setReAdminpassword(String reAdminpassword)
	{
		this.reAdminpassword = reAdminpassword;
	}
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String flag="";
	private List<Admin> listAdmins=new ArrayList<Admin>();
	public String getAdminId()
	{
		return adminId;
	}


	public void setAdminId(String adminId)
	{
		this.adminId = adminId;
	}
	
	public List<Admin> getListAdmins()
	{
		return listAdmins;
	}


	public void setListAdmins(List<Admin> listAdmins)
	{
		this.listAdmins = listAdmins;
	}


	public AdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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


	public String getFlag()
	{
		return flag;
	}


	public void setFlag(String flag)
	{
		this.flag = flag;
	}


	public Admin getAdmin()
	{
		return admin;
	}


	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}

	//管理员登陆
	public String adminLogin()
	{
		/*System.out.println(admin.getAdminId());	
		System.out.println(admin.getAdminId());*/
		List<String> result=adminService.adminLogin(admin.getAdminId(),admin.getAdminPassword());

		if(result.size()==0)
		{
			flag="fail";
			
			return "input";
		}
		else if(!result.get(0).equals(admin.getAdminPassword()))
		{
			flag="password is wrong";
			return "input";
		}else
		{
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			flag="ok";
			return "ok";
		}
			
	}


	@Override
	public void setServletResponse(HttpServletResponse response )
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
	//查找所有的管理员
	public  String  findAllAdmins()
	{
		try
		{
			listAdmins=adminService.findAllAdmins();
			if(listAdmins.size()==0)
			{
				        flag      ="no admin";
				return "fail";
			}else
			{
				flag="ok";
				return "ok";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
	}
	// 查找指定的管理员
	public String findAdminById()
	{
		try
		{	System.out.println(adminId);
			admin=adminService.findAdminById(adminId);
			if(admin!=null)
			{
				flag="ok";
				return "ok";
			}else
			{
				flag="fail";
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
	//管理员修改个人信息,修改自己本人
	public String updateAdminInfo()
	{
		/*System.out.println(admin.getAdminId());
		System.out.println(admin.getAdminPassword());
		System.out.println(reAdminpassword);*/
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		admin.setAdminPassword(reAdminpassword);
		try
		{
			int result=adminService.updateAdminInfo(admin);
			if(result==1)
			{
				flag="ok";
				return "ok";
			}
			else
			{
				flag="fail";
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
	//管理员查看所有的用户
		public String findAllUsers(){
			try
			{
				listAllUsers=adminService.findAllUsers();
				if(listAllUsers.size()==0)
				{
				    flag ="no user";
					return "fail";
				}else
				{
					flag="ok";
					return "ok";
				}
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag="error";
				return "error";
			}
		}
		//管理员删除某个用户
		public String deleteUserById(){
			int result = 0;
			System.out.println(userId);
			result = adminService.deleteUserById(userId);
			if(result ==1){
				return "ok";
			}
			
			return "fail";
		}
		

}
