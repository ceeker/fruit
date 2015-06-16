package com.fruit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.Admin;
import com.fruit.domain.Message;
import com.fruit.domain.PageBean;
import com.fruit.inter.PageService;
import com.fruit.service.AdminMessageService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminMessageProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private AdminMessageService adminMessageService;
	private String flag;
	private List<Message> messageList=new ArrayList<Message>();
	private Message message;
	private String messageId;
	private String messageTitle;
	private String messageContent;
	private Date messageDate;
	private PageBean pageBean;
	private PageService pageService;
	private String hql;
	private int page;
	
	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public String getHql()
	{
		return hql;
	}

	public void setHql(String hql)
	{
		this.hql = hql;
	}

	public PageService getPageService()
	{
		return pageService;
	}

	public void setPageService(PageService pageService)
	{
		this.pageService = pageService;
	}

	public PageBean getPageBean()
	{
		return pageBean;
	}

	public void setPageBean(PageBean pageBean)
	{
		this.pageBean = pageBean;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public AdminMessageService getAdminMessageService() {
		return adminMessageService;
	}

	public void setAdminMessageService(AdminMessageService adminMessageService) {
		this.adminMessageService = adminMessageService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
  
	//管理员查询所有已发布的公告；
	public String queryAllMessage()
	{
		try{
		 messageList=adminMessageService.queryAllMessage();		
		if(messageList.isEmpty()){
			
			
			flag="fail";
			
			return "fail";
			
			
		}else{
			
			
			flag="OK";
		
			return "ok";
		}
		}catch(Exception e){
			
			
			e.printStackTrace();
			flag="error";
					
			return "error";		
		}
	}

	//管理员添加新的公告信息；
	public String insertMessage(){
		 HttpSession session=request.getSession();
		 Admin admin=(Admin) session.getAttribute("admin");
		 
		/*String adminId=(String)request.getSession().getAttribute("adminId");*/
		if(admin==null)
		{
			
			flag="没有登录";
			return "fail";
		}else
		{
			String adminId=admin.getAdminId();	
			try {
				int result=adminMessageService.insertMessage(message,adminId);
				if(result==1)
				{
					
					flag="ok";
					return "ok";
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag="系统异常";
				return "error";
			}
			flag="fail";
			return "fail";
		}
		
		}

	
	//管理员通过MessageId删除信息；
	
	public String deleteMessageById(){
		try
		{	
			int result=adminMessageService.deleteMessageById(messageId);
			if(result==1)
			{
				return "ok";
			}
			else
			{
				return "fail";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		}
	
	
	
	//管理员修改信息；
	public String updateMessageById()
	{	
		int result=adminMessageService.updateMessage(message);
		if(result==1)
		{
			return "ok";
			
		}else
		{
			return "fail";
		}
	}	
	
	//后加：管理员根据messageId查询某个公告
		public String findMessageById(){
			try{
				 message=adminMessageService.findMessageById(messageId);
				if(message==null){
					flag="fail";
					return "fail";
				}else{
					flag="OK";
					return "ok";
				}
				}catch(Exception e){
					e.printStackTrace();
					flag="error";
					return "error";		
				}
		}

	public String page() throws Exception
	{
		
		this.pageBean=pageService.queryForPage(hql,5, page);
		flag="";
		return "ok";
	}
}
