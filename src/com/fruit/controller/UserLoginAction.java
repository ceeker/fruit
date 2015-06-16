package com.fruit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fruit.domain.User;
import com.fruit.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {

	private User user;
	private String flag="";
    private UserService userService;
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() throws Exception{
		List<String> result = userService.validateLogin(user.getUserId());
		if(result.size()==0){   //找不到用户
			flag="No User";
			return "input";
		}else if(!result.get(0).equals(user.getUserPassword())){  //密码错误
			flag="The password is wrong";
			return "input";
		}else{
			flag="ok";
			ActionContext actxt = ActionContext.getContext();
			Map<String,Object> session = actxt.getSession();
			session.put("useinfo",user);//把用户的信息保存在session中
			HttpServletResponse response = ServletActionContext.getResponse();
			Cookie cookie = new Cookie("userId",user.getUserId());//把用户的账号保存在cookie中
			cookie.setMaxAge(30000);
			response.addCookie(cookie);
			return "ok";
		}
			
		
	}
	
}
