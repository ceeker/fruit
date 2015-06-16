package com.fruit.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String commentId;
	private Vegetable commentVeg;
	private User commentUser;
	private String commentInfo;
	private float commentScore;
	private  int  visible;
	private Date commentDate;
	public String getCommentId()
	{
		return commentId;
	}
	public void setCommentId(String commentId)
	{
		this.commentId = commentId;
	}
	public Vegetable getCommentVeg()
	{
		return commentVeg;
	}
	public void setCommentVeg(Vegetable commentVeg)
	{
		this.commentVeg = commentVeg;
	}
	public User getCommentUser()
	{
		return commentUser;
	}
	public void setCommentUser(User commentUser)
	{
		this.commentUser = commentUser;
	}
	public String getCommentInfo()
	{
		return commentInfo;
	}
	public void setCommentInfo(String commentInfo)
	{
		this.commentInfo = commentInfo;
	}
	public float getCommentScore()
	{
		return commentScore;
	}
	public void setCommentScore(float commentScore)
	{
		this.commentScore = commentScore;
	}
	public int getVisible()
	{
		return visible;
	}
	public void setVisible(int visible)
	{
		this.visible = visible;
	}
	public Date getCommentDate()
	{
		return commentDate;
	}
	public void setCommentDate(Date commentDate)
	{
		this.commentDate = commentDate;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	
	
}
