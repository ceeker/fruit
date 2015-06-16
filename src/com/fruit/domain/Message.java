package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
	private String messageId;
	private String messageTitle;
	private Admin  messageAdmin;
	private String messageContent;
	private Date messageDate;
	public String getMessageId()
	{
		return messageId;
	}
	public void setMessageId(String messageId)
	{
		this.messageId = messageId;
	}
	public String getMessageTitle()
	{
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle)
	{
		this.messageTitle = messageTitle;
	}
	public Admin getMessageAdmin()
	{
		return messageAdmin;
	}
	public void setMessageAdmin(Admin messageAdmin)
	{
		this.messageAdmin = messageAdmin;
	}
	public String getMessageContent()
	{
		return messageContent;
	}
	public void setMessageContent(String messageContent)
	{
		this.messageContent = messageContent;
	}
	public Date getMessageDate()
	{
		return messageDate;
	}
	public void setMessageDate(Date messageDate)
	{
		this.messageDate = messageDate;
	}
	
}
