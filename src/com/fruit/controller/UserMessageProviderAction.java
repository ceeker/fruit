package com.fruit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fruit.domain.PageBean;
import com.fruit.domain.User;
import com.fruit.domain.UserMessage;
import com.fruit.inter.PageService;
import com.fruit.service.UserMessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//用户留言的action
public class UserMessageProviderAction extends ActionSupport  implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserMessage userMessage;
	private String flag="";
	private UserMessageService userMessageService;
	private List<UserMessage> myUserMessages;
	private HttpServletResponse  response;
	private HttpServletRequest request;
	private String insertSuccess;
	public String getInsertSuccess()
	{
		return insertSuccess;
	}

	public void setInsertSuccess(String insertSuccess)
	{
		this.insertSuccess = insertSuccess;
	}


	private String userMessageTitle;
	public String getUserMessageTitle() {
		return userMessageTitle;
	}

	public void setUserMessageTitle(String userMessageTitle) {
		this.userMessageTitle = userMessageTitle;
	}

	
	private String userMessageContent;
	private int isConfirm;
	private Date userMessageDate;
	private String userMessageAuthor;
	private String userMessageId;
	
	private String hql;
	private int page;
	private PageBean pageBean;
	public PageBean getPageBean()
	{
		return pageBean;
	}

	public void setPageBean(PageBean pageBean)
	{
		this.pageBean = pageBean;
	}

	public PageService getPageService()
	{
		return pageService;
	}

	public void setPageService(PageService pageService)
	{
		this.pageService = pageService;
	}


	private PageService pageService;
	public String getHql()
	{
		return hql;
	}

	public void setHql(String hql)
	{
		this.hql = hql;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public String getUserMessageContent() {
		return userMessageContent;
	}

	public void setUserMessageContent(String userMessageContent) {
		this.userMessageContent = userMessageContent;
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

	public String getUserMessageAuthor() {
		return userMessageAuthor;
	}

	public void setUserMessageAuthor(String userMessageAuthor) {
		this.userMessageAuthor = userMessageAuthor;
	}

	public String getUserMessageId() {
		return userMessageId;
	}

	public void setUserMessageId(String userMessageId) {
		this.userMessageId = userMessageId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public List<UserMessage> getMyUserMessages() {
		return myUserMessages;
	}

	public void setMyUserMessages(List<UserMessage> myUserMessages) {
		this.myUserMessages = myUserMessages;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public UserMessageService getUserMessageService() {
		return userMessageService;
	}

	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
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
	
	
	
	//查看自己的留言
	public String findMyUserMessages()
	{
		
		User user=(User)request.getSession().getAttribute("userInfo");
		if(user==null)
		{
			flag="您还没有登录,请先登录!";
			
			return "login";
		}
		myUserMessages = userMessageService.findMyUserMessages(user);
		if(myUserMessages.size()==0){
			flag="no usermessage";
			return 	ERROR;
		}else{
			flag="find all myusermessages as follow";
			return "ok";
		}
	}

	
	//用户发表留言即插入留言
	public String insertUserMessage(){

		Object user=request.getSession().getAttribute("userId");
		
		if(user==null ||user.equals(""))
		{
			insertSuccess="您还没有登录,请登录";
			return "ok";
		}
		String userId=user.toString();
//	    String userMessageId = userMessgeAuthor + useMessageDate.toString();
//		userMessage.setUserMessageId(userMessageId);
//		userMessage.setUserMessageAuthor(userMessageAuthor);
//		userMessage.setUserMessageContent(userMessageContent);
//		userMessage.setUserMessageDate(new Date());
		int result=userMessageService.insertIntoUserMessage(userMessageId,userMessageContent,userId,userMessageDate);
		if(result==1)
		{
			insertSuccess="您已经插入成功，等待管理员审核";
			return "ok";
			
		}
		else
		{
			insertSuccess="插入失败，系统出现异常";
			return "fail";
		}
		
		
		
		
	}
	//查询所有的已通过审核留言
	public String page() throws Exception
	{
		this.pageBean=pageService.queryForPage(hql,5, page);
		flag="";
		return "ok";
	}
	
	
}
