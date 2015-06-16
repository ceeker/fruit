package com.fruit.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.User;
import com.fruit.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware
{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private User  user;
	private UserService userService;
	private String flag;
	private String userId;
	private String userMail;
	private String userAddr;
	private String userPhone;
	private String prepass;
	public String getPrepass()
	{
		return prepass;
	}

	public void setPrepass(String prepass)
	{
		this.prepass = prepass;
	}

	public String getUserPhone()
	{
		return userPhone;
	}

	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getUserAddr()
	{
		return userAddr;
	}

	public void setUserAddr(String userAddr)
	{
		this.userAddr = userAddr;
	}

	public String getUserMail()
	{
		return userMail;
	}

	public void setUserMail(String userMail)
	{
		this.userMail = userMail;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public User getUser()
	{
		return user;
	}

	public void  setUser(User user)
	{
		this.user = user;
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
	//用户登录
	public void userLogin() throws Exception
	{
	/*	System.out.println("传入的userId 参数"+user.getUserId());	
		System.out.println("传入的userPass参数"+user.getUserPassword());*/
		List<String> result=userService.userLogin(user.getUserId(),user.getUserPassword());
		/*System.out.println("返回的数据库中用户密码"+result.get(0));*/
		/*System.out.println(result.get(0).equals(user.getUserPassword()));*/
		if(result.size()==0)
		{
			flag="nouser";
			
			response.getWriter().write("nouser");
		}
		else if(!result.get(0).equals(user.getUserPassword()))
		{
			flag="passwrong";
			response.getWriter().write("passwrong");
		}else
		{
			flag="true";
			request.getSession().setAttribute("userId", user.getUserId());
			
			Cookie cUserId =new Cookie("userId", user.getUserId());
			Cookie cUserPassword=new Cookie("userPassword",user.getUserPassword());
			cUserId.setMaxAge(30*24*60*60);
			cUserPassword.setMaxAge(30*24*60*60);
			response.addCookie(cUserId);
			response.addCookie(cUserPassword);
			
			response.getWriter().write("true");
		}
			
	}
	//用户注册
	public String  userRegist()
	{
		try
		{
			
			int result=userService.userRegist(user);
			if(result==1)
			{
				flag="ok";
				return "ok";
			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="系统异常";
			return "error";
		}
		flag="fail";
		return "fail";
	}
	//修改个人信息
	public String updateUserInfo()
	{
		try
		{
			int result=userService.updateUserInfo(user);
			if(result==1)
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
		flag="fail";
		return "fail";
		
	}
	//用户修改密码
	public void userUpdatePassword() throws Exception
	{
		try
		{
				
			int success=userService.validatePass(user.getUserId(),prepass);
			if(success==1)
			{
				int result=userService.userUpdatePassword(user);
				if(result==1)
				{
					flag="ok";
					response.setContentType("text/plain");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write("true");
					return ;
				}
			}
			else
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("passwrong");
				return ;
			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
			return ;
		}
		flag="fail";
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("false");
		return ;
	}
	//修改个人邮箱
	public void updateMail() throws Exception
	{
			Object user=request.getSession().getAttribute("userId");
		
	
			String userId=user.toString();
			List list=userService.mailExist(userMail);
			if(list.size()==0)
			{
				int result=userService.updateMail(userId,userMail);
				System.out.println("result的值："+result);
				if(result==1)	
				{
					response.setContentType("text/plain");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write("true");
				}
				else
				{
					response.setContentType("text/plain");
					response.setCharacterEncoding("utf-8");
					response.getWriter().write("error");
				}
			
				
				
				
			}
			else
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("had");
				
			}
			
		
	}
	//用户查询个人信息
	public String findUserInfoById()
	{
		Object o=request.getSession().getAttribute("userId");
		if(o==null)
		{
			flag="您还没有登录，请先登录";
			System.out.println("执行了判断session:");
			return "fail";
		}	
		try
		{
			String userId=o.toString();
			user=userService.findUserInfoById(userId);
			if(user==null)
			{
				flag="no user";
				return "fail";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="系统异常";
			return"error";
		}
		flag="ok";
		return "ok";
		
		
	}
	//查询用户名是否存在
	public void  isExist() throws Exception
	{
		try
		{
			
			
			List list=userService.isExist(user.getUserId());
			System.out.println("list 是否为空"+list.isEmpty());
			if(list.isEmpty())
			{
				request.getSession().setAttribute("userId", user.getUserId());
				response.getWriter().write("true");
			}else
			{
				response.getWriter().write("false");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			response.getWriter().write("false");
		}
	}
	
	//校验邮箱是否重复
	public void mailExist() throws Exception
	{
		try
		{
			List list=userService.mailExist(user.getUserMail());
			if(list.isEmpty())
			{
				request.getSession().setAttribute("userId", user.getUserId());
				response.getWriter().write("true");
			}else
			{
				response.getWriter().write("false");
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			response.getWriter().write("false");
		}
	}
	//用户注销
	public String userLogout()
	{
		request.getSession().removeAttribute("userId");
		return "ok";
		
	}
	//用户修改个人地址
	public void updateAddr() throws Exception
	{
		Object user=request.getSession().getAttribute("userId");
		if(user==null)
		{
			flag="您还没有登录，请先登录";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
			return ;
		}else
		{
			String userId=user.toString();
			int result=userService.updateAddr(userId,userAddr);
			if(result==1)
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("true");
			}
			else
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("false");
			}
		}
	}
	//用户修改电话号码
	public void updatePhone() throws Exception
	{
		Object user=request.getSession().getAttribute("userId");
		if(user==null)
		{
			flag="您还没有登录，请先登录";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
			return ;
		}else
		{
			String userId=user.toString();
			int result=userService.updatePhone(userId,userPhone);
			if(result==1)
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("true");
			}
			else
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("false");
			}
		}
	}
	
	
}
