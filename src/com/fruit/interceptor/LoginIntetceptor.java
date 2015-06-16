package com.fruit.interceptor;

import java.util.Date;

import com.fruit.controller.UserProviderAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntetceptor extends MethodFilterInterceptor
{

	private String name;
	
	
	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		// TODO Auto-generated method stub
		
		UserProviderAction upa=(UserProviderAction)invocation.getAction();
		
		System.out.println(name+"拦截器动作————————"+"开始登陆Action的时间为："+new Date());
		long start=System.currentTimeMillis();
		String result=invocation.invoke();
		System.out.println(name+"拦截器动作————————"+"结束登陆Action的时间为："+new Date());
		long end=System.currentTimeMillis();
		System.out.println(name+"拦截器动作————————"+"耗费时间为："+(start-end)+"毫秒");
		return result;
	}


}
