package com.fruit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.fruit.domain.Comment;
import com.fruit.domain.User;
import com.fruit.domain.Vegetable;
import com.fruit.service.CommentService;
import com.fruit.util.DateFormatUtil;

import com.opensymphony.xwork2.ActionSupport;

public class CommentProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware 
{
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String flag;
	private User user;
	private Vegetable vegetable;
	private Comment comment;
	private CommentService commentService;
	private String vegetableId;
	private String bookId;
	//后加
	private List<Comment> list;
	private String commentId;


	public List<Comment> getList()
	{
		return list;
	}
	public void setList(List<Comment> list)
	{
		this.list = list;
	}
	public String getCommentId()
	{
		return commentId;
	}
	public void setCommentId(String commentId)
	{
		this.commentId = commentId;
	}
	public String getBookId()
	{
		return bookId;
	}
	public void setBookId(String bookId)
	{
		this.bookId = bookId;
	}
	public String getVegetableId()
	{
		return vegetableId;
	}
	public void setVegetableId(String vegetableId)
	{
		this.vegetableId = vegetableId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Vegetable getVegetable() {
		return vegetable;
	}
	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	
	public CommentProviderAction() 
	{
		// TODO 自动生成的构造函数存根
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO 自动生成的方法存根
		this.response=response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		// TODO 自动生成的方法存根
		this.request=request;
	}
	
	//插入评价
	public  void insertComment() throws Exception
	{
		
		String userId=request.getSession().getAttribute("userId").toString();
		User user=new User();
		user.setUserId(userId);
		
		System.out.println("userId:"+userId);
		System.out.println("commentScore:"+comment.getCommentScore());
		
		System.out.println("commentInfo:"+comment.getCommentInfo());
		comment.setCommentId(userId+DateFormatUtil.getInstance().format(new Date()));
		
		comment.setCommentUser(user);
		
	
		comment.setCommentDate(new Date());		
		try {
			int result=commentService.insertComment(bookId,comment);
			if(result==1)
			{
				flag="ok";
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("true");
			}else
			{
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("false");
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			flag="系统异常";
			response.setContentType("text/plain;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
		}
		
	}
	
	//根据蔬菜id获取该蔬菜的所有评论
	public void getCommentsByVegetableId() {
		
		List<Comment> list=null;
		JSONArray ja=new JSONArray();
		try {
			list = commentService.getCommentsByVegetableId(vegetableId);
			if(list.size()==0){
				flag="该商品暂无评论！";
				
				response.getWriter().write(ja.toString());
			
			}else{
				for(Comment  comment:list)
				{
					JSONObject jo=new JSONObject();
				
					jo.put("commentInfo", comment.getCommentInfo());
					jo.put("commentScore", comment.getCommentScore());
					jo.put("commentDate", comment.getCommentDate().toLocaleString());
					jo.put("commentUser", comment.getCommentUser().getUserId());
					ja.add(jo);
				}
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(ja.toString());
				flag="ok";
				
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			flag="系统异常";
		
		}
	}
	
	//根据蔬菜id获取该蔬菜的所有评论  管理端
		public String adminCommentsByVegetableId() {
			try {
				list = commentService.adminCommentsByVegetableId(vegetableId);
				if(list.size()==0){
					flag = "fail";
					return "fail";	
				}else{
					flag="ok";
					return "ok";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				flag="系统异常";
				return "error";
			}
		}

	
	//用户获取自己的评论
	public void getCommentsByUserId() throws Exception
	{
		List<Comment> list=null;
		JSONArray ja=new JSONArray();
		Object o=request.getSession().getAttribute("userId");
		if(o==null)
		{
			flag="您还没有登录，请先登录后查看个人评论";
			
			response.getWriter().write(ja.toString());
		}else
		{
			
		
		String userId=o.toString();
		try {
			list = commentService.getCommentsByUserId(userId);
			if(list.size()==0){
				flag="该商品暂无评论！";
				
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(ja.toString());
					
			}else{
				for(Comment  comment:list)
				{
					JSONObject jo=new JSONObject();
					jo.put("commentVeg", comment.getCommentVeg().getVegetableName());
					jo.put("commentInfo", comment.getCommentInfo());
					jo.put("commentScore", comment.getCommentScore());
					jo.put("commentDate", comment.getCommentDate().toLocaleString());
					jo.put("commentUser", comment.getCommentUser().getUserId());
					ja.add(jo);
				}
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(ja.toString());
				flag="ok";
				
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			flag="系统异常";
			
		}
		}
	}
	
	
	
	//后改的！！！！comment 的显示状态为不可显示
		public void disVisiable() {
			try {
				int result=commentService.disVisible(commentId);
				if(result==0){
					flag="fail";
					//return "fail";
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/plain");
					response.getWriter().write("false");
				}else{
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/plain");
					response.getWriter().write("true");	
				}
				
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				flag="系统异常";
				
			}
			
		}


}
