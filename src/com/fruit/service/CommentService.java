package com.fruit.service;

import java.util.List;

import com.fruit.dao.CommentDao;
import com.fruit.domain.Comment;
import com.fruit.domain.User;
import com.fruit.domain.Vegetable;

public class CommentService {

	private CommentDao commentDao;
	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	public int insertComment(String bookId,Comment comment) 
	{
		// TODO 自动生成的方法存根
	return commentDao.insertComment(bookId,comment);
	}
	public List<Comment> getCommentsByVegetableId(String vegetableId ) {
		return commentDao.getCommentsByVegetableId(vegetableId);
		
	}
	public List adminCommentsByVegetableId(String vegetableId ) {
		return commentDao.adminCommentsByVegetableId(vegetableId);
		
	}
	public List getCommentsByUserId(String userId ) {
		return commentDao.getCommentsByUserId(userId);
		
	}
	public int disVisible(String commentId){
   	 return commentDao.disVisiable(commentId);
   }

}
