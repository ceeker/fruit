package com.fruit.dao;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.fruit.domain.Book;
import com.fruit.domain.Cart;
import com.fruit.domain.User;
import com.fruit.domain.Vegetable;
import com.fruit.util.DateFormatUtil;
import com.fruit.util.SpringUtil;

public class UserVegetableDao
{
	
	private SpringUtil springUtil;
	public SpringUtil getSpringUtil()
	{
		return springUtil;
	}
	public void setSpringUtil(SpringUtil springUtil)
	{
		this.springUtil = springUtil;
	}
	//获取所有的蔬菜
	public List<Vegetable> getAllVegetables()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> listVegetables=new ArrayList<Vegetable>();
		try
		{
			listVegetables=sess.createQuery("from  Vegetable").list();
			
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
			
		}finally
		{
			tx.commit();
			sess.close();
		}
		return listVegetables;
		
	}
	
	//用户查询单个蔬菜
	public Vegetable findVegetableById(String vegetableID)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Vegetable v;
		try
		{
			v=(Vegetable)sess.get(Vegetable.class, new String(vegetableID));			
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
			
		}finally
		{
			tx.commit();
			sess.close();
		}
		return v;
		
		
		
		
	
		
		
		
	}
	
	//用户根据关键字查询所有的蔬菜
	public List<Vegetable> findVegetableByKeyWord(int offset,int length,String keyWord,String order,String sort)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		String sql;
		sql="select * from Vegetable as v where v.vegetableKeyWords like '%"+keyWord+"%'";
		System.out.println("value:"+order);
		System.out.println("value:"+sort);
		System.out.println(order.equals("vegetableSaleCount"));
		System.out.println(sort.equals("desc"));
		System.out.println(order.equals("vegetableSaleCount")&&sort.equals("desc"));
		if(order.equals("vegetableSaleCount")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable as v where v.vegetableKeyWords like '%"+keyWord+"%' order by v.vegetableSaleCount desc";
		}
		if(order.equals("vegetableSaleCount")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v where v.vegetableKeyWords like '%"+keyWord+"%' order by v.vegetableSaleCount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v where v.vegetableKeyWords like '%"+keyWord+"%' order by v.vegetablePrice*v.vegetableDiscount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable as v where v.vegetableKeyWords like '%"+keyWord+"%' order by v.vegetablePrice*v.vegetableDiscount desc";
		}

			
		
		
		List<Vegetable> listVegetables=new ArrayList<Vegetable>();
		
		
		try
		{
			
			listVegetables=sess.createSQLQuery(sql).addEntity(Vegetable.class).setFirstResult(offset).setMaxResults(length).list();
			System.out.println(sql);
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		
		return listVegetables;
		
		
	}
	//用户将蔬菜添加到购物车
	public int  insertIntoCart(String userId,String vegetableID,int vegetableMount)
	{
		// TODO Auto-generated method stub
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
	
		
		
		
		try
		{
			User  u=(User)sess.get(User.class, new String(userId));
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableID));
			Cart cart=new Cart();
			cart.setCartId(userId+DateFormatUtil.getInstance().format(new Date()));
			cart.setCartVegetable(v);
			cart.setVegetableMount(vegetableMount);
			cart.setUser(u);
			cart.setCartDate(new Date());
			sess.save(cart);
			sess.flush();
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
			
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		
		return 1;
		
		
		
		
	}
	//用户修改购物车此蔬菜的数量
	public int updateVegetableMount(String cartId,int vegetableMount)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int flag=0;
		try
		{
			Cart cart=(Cart)sess.get(Cart.class, new String(cartId));
			cart.setVegetableMount(vegetableMount);
			sess.save(cart);
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
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
	
	//用户删除购物车蔬菜
	public int deleteCart(String cartId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		String hql="delete Cart as cart where cart.cartId=:cartId";
		int flag=0;
		try
		{
			flag=sess.createQuery(hql).setString("cartId", cartId).executeUpdate();
			sess.flush();
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw  new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		return flag;
		
		
		
	}
	//用户查询购物车中的蔬菜
	public Cart findCart(String cartId)
	{
		// TODO Auto-generated method stub
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Cart cart;
		try
		{
			cart=(Cart)sess.get(Cart.class, new String(cartId));
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		tx.rollback();
		throw new HibernateException("系统异常");
			
			
		}finally
		{
			tx.commit();
			sess.close();
		}
		return cart;
		
		
	}
	//查询购物车中蔬菜数量
	public long countCart(String userId)
	{
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Cart cart;
		
		long size=0;
		try
		{
			User user=(User)sess.get(User.class, new String(userId));
			System.out.print("计算购物车数量中传入的userId"+userId);
			System.out.print("user 对象中的主键"+user.getUserId());
			size=(Long)sess.createQuery("select count(*) from Cart as c where c.user.userId=:userId").setString("userId", userId).uniqueResult();
			System.out.print("执行了查询购物车数量的dao");
			/*System.out.print("list 的size"+list.size());
			System.out.print("购物车list是否空"+list.isEmpty());*/
			/*if(list.isEmpty())
			{
				size=0;
				
			}
			else
			{*/
				/*size=Integer.parseInt(list.get(0).toString());*/
				System.out.print("购物车数量"+size);
			/*}*/
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		tx.rollback();
		throw new HibernateException("系统异常");
			
			
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return size;
		
		
		
	}
	//查看购物车中所有的蔬菜
	public List findAllCart(String userId)
	{
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Cart cart;
		List<Cart> list=new ArrayList<Cart>();
		long size=0;
		try
		{
			User user=(User)sess.get(User.class, new String(userId));
			System.out.print("计算购物车数量中传入的userId"+userId);
			System.out.print("user 对象中的主键"+user.getUserId());
			size=countCart(userId);
			if(size==0)
			{
				return list;
			}
			
				list=sess.createQuery(" from Cart as c where c.user.userId=:userId order by c.cartDate desc").setString("userId", userId).list();
		
			
			System.out.print("执行了查询购物车数量的dao");
			
				System.out.print("购物车数量"+size);
		
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		tx.rollback();
		throw new HibernateException("系统异常");
			
			
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return list;
		
		
	}
	//用户将购物车中的东西转发成订单
	public List<Book> book(List<Book> listBooks)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Book> listBook=new ArrayList<Book>();
		try
		{
			for(Book book:listBooks)
			{
				Cart cart =(Cart)sess.createQuery("from Cart as c where c.cartId=:cartId").setString("cartId", book.getBookId()).list().get(0);
				book.setBookVegetable(cart.getCartVegetable());
				book.setBookUser(cart.getUser());
				book.setBookId(cart.getUser().getUserId().toString()+DateFormatUtil.getInstance().format(new Date()));
				book.setBookDate(new Date());
				
				listBook.add(book);
				//删除购物车里的记录
				sess.createQuery("delete from Cart as c where c.cartId=:cartId").setString("cartId", book.getBookId()).executeUpdate();
				
				
				
				
			}
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			flag=0;
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return listBook;
	}
	//pay
	public void pay(List<Book> listBooks)
	{
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Book> listBook=new ArrayList<Book>();
		try
		{
			for(Book book:listBooks)
			{
				Cart cart =(Cart)sess.createQuery("from cart as c where c.cartId=:cartId").setString("cartId", book.getBookId()).list().get(0);
				book.setBookVegetable(cart.getCartVegetable());
				book.setBookUser(cart.getUser());
				book.setBookId(cart.getUser().getUserId().toString()+DateFormatUtil.getInstance().format(new Date()));
				book.setBookDate(new Date());
				sess.save(book);
				listBook.add(book);
				//删除购物车里的记录
				sess.createQuery("delete from Cart as c where c.cartId=:cartId").setString("cartId", book.getBookId()).executeUpdate();
				
				
				
				
			}
			flag=1;
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			flag=0;
			throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
	
	}
	
	
	//查询所有热销商品
	
	public List<Vegetable> findSaleVegetables(Integer hotoffset,
			Integer hotlength, String order, String sort)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		String sql;
		sql="select * from Vegetable";
		System.out.println("value:"+order);
		System.out.println("value:"+sort);
		System.out.println(order.equals("vegetableSaleCount"));
		System.out.println(sort.equals("desc"));
		System.out.println(order.equals("vegetableSaleCount")&&sort.equals("desc"));
		if(order.equals("vegetableSaleCount")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable as v order by v.vegetableSaleCount desc";
		}
		if(order.equals("vegetableSaleCount")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v  order by v.vegetableSaleCount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v order by v.vegetablePrice*v.vegetableDiscount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable  as v  order by v.vegetablePrice*v.vegetableDiscount desc";
		}

			
		
		
		List<Vegetable> listVegetables=new ArrayList<Vegetable>();
		
		
		try
		{
			
			listVegetables=sess.createSQLQuery(sql).addEntity(Vegetable.class).setFirstResult(hotoffset).setMaxResults(hotlength).list();
			System.out.println(sql);
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		
		return listVegetables;
	}
	
	//查找新鲜说过
	public List<Vegetable> findFreshVegetables(Integer freshoffset,
			Integer freshlength, String order, String sort)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		String sql;
		sql="select * from Vegetable";
		System.out.println("value:"+order);
		System.out.println("value:"+sort);
		System.out.println(order.equals("vegetableSaleCount"));
		System.out.println(sort.equals("desc"));
		System.out.println(order.equals("vegetableSaleCount")&&sort.equals("desc"));
		if(order.equals("vegetableSaleCount")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable as v order by v.vegetableSaleCount desc";
		}
		if(order.equals("vegetableSaleCount")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v  order by v.vegetableSaleCount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v order by v.vegetablePrice*v.vegetableDiscount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable  as v  order by v.vegetablePrice*v.vegetableDiscount desc";
		}

			
		
		
		List<Vegetable> listVegetables=new ArrayList<Vegetable>();
		
		
		try
		{
			
			listVegetables=sess.createSQLQuery(sql).addEntity(Vegetable.class).setFirstResult(freshoffset).setMaxResults(freshlength).list();
			System.out.println(sql);
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		
		return listVegetables;
	}
	public List<Vegetable> findDiscountVegetables(Integer discountoffset,
			Integer discountlength, String order, String sort)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		String sql;
		sql="select * from Vegetable as v order by v.vegetableDiscount asc";
		System.out.println("value:"+order);
		System.out.println("value:"+sort);
		System.out.println(order.equals("vegetableSaleCount"));
		System.out.println(sort.equals("desc"));
		System.out.println(order.equals("vegetableSaleCount")&&sort.equals("desc"));
		if(order.equals("vegetableSaleCount")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable as v order by v.vegetableSaleCount desc";
		}
		if(order.equals("vegetableSaleCount")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v  order by v.vegetableSaleCount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("asc"))
		{
			 sql="select * from Vegetable as v order by v.vegetablePrice*v.vegetableDiscount asc";
		}
		if(order.equals("vegetablePrice")&&sort.equals("desc"))
		{
			 sql="select * from Vegetable  as v  order by v.vegetablePrice*v.vegetableDiscount desc";
		}

			
		
		
		List<Vegetable> listVegetables=new ArrayList<Vegetable>();
		
		
		try
		{
			
			listVegetables=sess.createSQLQuery(sql).addEntity(Vegetable.class).setFirstResult(discountoffset).setMaxResults(discountlength).list();
			System.out.println(sql);
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统异常");
		}
		finally
		{
			tx.commit();
			sess.close();
		}
		
		
		
		return listVegetables;
	}
	//查询个人的订单
	public List<Book> findBook(String userId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Book> listBooks=new ArrayList<Book>();
		try
		{
			listBooks=sess.createQuery("from Book as b where b.bookUser.userId=:userId  and b.isVisible=1 order by b.bookDate desc").setString("userId", userId).list();
			sess.flush();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		
		
		return listBooks;
	}
	
	
}
