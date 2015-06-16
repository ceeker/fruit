package com.fruit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fruit.domain.Book;
import com.fruit.domain.Comment;
import com.fruit.domain.User;
import com.fruit.domain.Vegetable;
import com.fruit.util.HibernateUtil;
import com.fruit.util.SpringUtil;

public class CommentDao 
{
	private SpringUtil springUtil;

	public SpringUtil getSpringUtil() {
		return springUtil;
	}

	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}

	//插入评论
	public int insertComment(String bookId,Comment comment) 
	
	{
		// TODO 自动生成的方法存根
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		
		
		try {
			
			Book book=(Book)sess.get(Book.class, new String(bookId));
			
			Vegetable v=(Vegetable)book.getBookVegetable();
			String vegetableID=v.getVegetableID();
			User u=(User)sess.get(User.class, new String(comment.getCommentUser().getUserId()));
			
			long commentCount=v.getVegetableCommentCount()+1;//评论数加1
			//评论数加1
			
			
			//评论成功后将评论数加1
			
			Query query=sess.createQuery("update Vegetable set vegetableCommentCount='"+commentCount+"'where vegetableID=:vegetableID ").setString("vegetableID", vegetableID);
			
			query.executeUpdate();
			book.setIsConfirm(3);
			comment.setCommentUser(u);
			comment.setCommentVeg(v);
			sess.save(comment);
			sess.save(book);
			flag=1;
			
		} catch (Exception e) 
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
		
	}
	
	//根据蔬菜id获取该蔬菜的可显示评论  前台
		public List<Comment> getCommentsByVegetableId(String vegetableId) {
			
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			List<Comment> list=new ArrayList<Comment>();
			try {
				list=sess.createQuery("from Comment as c where c.commentVeg.vegetableID=:vegetableId and c.visible=:visible ").setString("vegetableId", vegetableId).setInteger("visible", 1).list();
			} catch (HibernateException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				tx.rollback();
			}finally
			{
				tx.commit();
				sess.close();
			}
			return list;
		}
		
		//根据蔬菜id获取该蔬菜的所有评论  后台
 		public List adminCommentsByVegetableId(String vegetableId ) {

			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			List<Comment> list=new ArrayList<Comment>();
			try {
				list=sess.createQuery("from Comment as c where c.commentVeg.vegetableID=:vegetableId").setString("vegetableId", vegetableId).list();
				
			} catch (HibernateException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				tx.rollback();
			}finally
			{
				tx.commit();
				sess.close();
			}
			return list;
		}
		
		
		//用户获取自己的评论
		public List getCommentsByUserId(String userId) {
			
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			List<Comment> list=new ArrayList<Comment>();
			try {
				list=sess.createQuery("from Comment as c where c.commentUser.userId=:userId order by c.commentDate desc").setString("userId", userId).list();
				
				sess.flush();
			} catch (HibernateException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				tx.rollback();
			}finally
			{
				tx.commit();
				sess.close();
			}
			return list;
			
		}
		//设置评论为不可见  默认为0，可见
				public int disVisiable(String commentId) {
					
					Session sess=springUtil.getSession();
					Transaction tx=sess.beginTransaction();
					
					int result=0;
					try {
						Comment comment = (Comment) sess.get(Comment.class,new String(commentId));
						comment.setVisible(0);
						sess.flush();
						sess.save(comment);
						result=1;
					} catch (HibernateException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						tx.rollback();
					}finally
					{
						tx.commit();
						sess.close();
					}
					return result;
				}

		
}
