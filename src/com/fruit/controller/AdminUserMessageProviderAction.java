package com.fruit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.PageBean;
import com.fruit.domain.User;
import com.fruit.domain.UserMessage;
import com.fruit.inter.PageService;
import com.fruit.service.AdminUserMessageService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserMessageProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private AdminUserMessageService adminUserMessageService;
	private String flag;
	private List<UserMessage> userMessageList = new ArrayList<UserMessage>();
	private UserMessage userMessage;
	private String userMessageId;
	private String userMessageTitle;
	private String userMessageContent;
	private User userMessageAuthor;
	private int isConfirm;//“0”表示未通过管理员的审核，“1”表示已通过管理员的审核
	private Date userMessageDate; 
	private PageBean pageBean;
	private PageService pageService;
	private String hql;
	private int page;
	public AdminUserMessageService getAdminUserMessageService() {
		return adminUserMessageService;
	}

	public void setAdminUserMessageService(
			AdminUserMessageService adminUserMessageService) {
		this.adminUserMessageService = adminUserMessageService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<UserMessage> getUserMessageList() {
		return userMessageList;
	}

	public void setUserMessageList(List<UserMessage> userMessageList) {
		this.userMessageList = userMessageList;
	}

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}

	public String getUserMessageId() {
		return userMessageId;
	}

	public void setUserMessageId(String userMessageId) {
		this.userMessageId = userMessageId;
	}

	public String getUserMessageTitle() {
		return userMessageTitle;
	}

	public void setUserMessageTitle(String userMessageTitle) {
		this.userMessageTitle = userMessageTitle;
	}

	public String getUserMessageContent() {
		return userMessageContent;
	}

	public void setUserMessageContent(String userMessageContent) {
		this.userMessageContent = userMessageContent;
	}

	public User getUserMessageAuthor() {
		return userMessageAuthor;
	}

	public void setUserMessageAuthor(User userMessageAuthor) {
		this.userMessageAuthor = userMessageAuthor;
	}

	public int getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(int isConfirm) {
		this.isConfirm = isConfirm;
	}

	public Date getUserMessageDate() {
		return userMessageDate;
	}

	public void setUserMessageDate(Date userMessageDate) {
		this.userMessageDate = userMessageDate;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
	//查看所有用户留言
	//管理员查询所有已发布的公告；
		public String findAllUserMessage()
		{
			try{
			 userMessageList=adminUserMessageService.findAllUserMessage();
			
			if(userMessageList.isEmpty()){
				flag="没有用户留言";
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
   //删除某个用户留言
		public String deleteUserMessageById(){
			try{
			int result=adminUserMessageService.deleteUserMessageById(userMessageId);
			if(result==1){
				flag="ok";
				return "ok";
			}else{
				flag="fail";
				return "fail";
			}
			}catch(Exception e){
				e.printStackTrace();
				flag="error";
				return "error";
			}
		}
	//查看某个用户留言
	    public String findUserMessageById(){
	    	try{
	    		userMessage = adminUserMessageService.findUserMessageById(userMessageId);
	    		if(userMessage==null){
	    			flag="fail";
	    			return "fail";
	    		}else{
	    			flag="ok";
	    			return "ok";
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		flag="error";
	    		return "error";
	    	}
	    }
	 //管理员审核用户留言
	    public String updateUserMessageById(){
	    	try{
	    		int result = adminUserMessageService.updateUserMessageById(userMessage);
	    		if(result==1){
	    			flag="ok";
	    			return "ok";
	    		}else{
	    			flag="fail";
	    			return "fail";
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		flag = "error";
	    		return "error";
	    	}
	    }


}
