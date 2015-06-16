package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;

public class UserMessage implements Serializable
{
	private String userMessageId;
	private String userMessageTitle;
	private String userMessageContent;
	private User userMessageAuthor;
	private int isConfirm;//“0”表示未通过管理员的审核，“1”表示已通过管理员的审核
	private Date userMessageDate;
	public String getUserMessageId()
	{
		return userMessageId;
	}
	public void setUserMessageId(String userMessageId)
	{
		this.userMessageId = userMessageId;
	}
	public String getUserMessageTitle() {
		return userMessageTitle;
	}
	public void setUserMessageTitle(String userMessageTitle) {
		this.userMessageTitle = userMessageTitle;
	}
	public String getUserMessageContent()
	{
		return userMessageContent;
	}
	public void setUserMessageContent(String userMessageContent)
	{
		this.userMessageContent = userMessageContent;
	}
	public User getUserMessageAuthor() {
		return userMessageAuthor;
	}
	public void setUserMessageAuthor(User userMessageAuthor) {
		this.userMessageAuthor = userMessageAuthor;
	}
	public int getIsConfirm()
	{
		return isConfirm;
	}
	public void setIsConfirm(int isConfirm)
	{
		this.isConfirm = isConfirm;
	}
	
	public Date getUserMessageDate()
	{
		return userMessageDate;
	}
	public void setUserMessageDate(Date userMessageDate)
	{
		this.userMessageDate = userMessageDate;
	}
	
	
}
