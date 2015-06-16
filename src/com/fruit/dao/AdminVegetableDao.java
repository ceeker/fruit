package com.fruit.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;






import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.fruit.domain.Vegetable;
import com.fruit.util.SpringUtil;

public class AdminVegetableDao
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
	//g管理员查看所有的蔬菜
	public List<Vegetable> findAllVegetables()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> listVegetables=new ArrayList<Vegetable>();
		
		try
		{
			 listVegetables=sess.createQuery("from Vegetable").list();
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
	//管理员查看单个蔬菜
	public Vegetable findVegetableById(String vegetableId)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		Vegetable  vegetable;
		try
		{
			  vegetable=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new HibernateException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return vegetable;
	}

	public int insertIntoVegetable(Vegetable vegetable)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{	
			ArrayList<String> listPic=new ArrayList<String>();
			
				for(int i=0;i<=10;i++)
				{
					System.out.print("start");
					listPic.add("/vegetableUpload/logo.png");
				}
			
			
			ArrayList<String> listInfoPic=new ArrayList<String>();
		
				for(int i=0;i<=3;i++)
				{
					listInfoPic.add("/vegetableUpload/logo.png");
				}
	
			vegetable.setVegetablePicAddr(listPic);
			vegetable.setVegetableInfoPicAddr(listInfoPic);
			sess.save(vegetable);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}


	public int insertIntoVegetablePic1(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetablePicAddr();
			if(list.size()==0)
			{
				list.add(0, path);	
			}else
			{
				list.set(0, path);	
			}
			
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}

	public int insertIntoVegetablePic2(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetablePicAddr();
			if(list.size()==0)
			{
				list.add(1, path);
			}else
			{
				list.set(1, path);
			}
			
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}

		
	public int insertIntoVegetablePic3(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetablePicAddr();
			if(list.size()==0)
			{
				list.add(2, path);	
			}else
			{
				list.set(2, path);	
			}
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}

	public int insertIntoVegetablePic4(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetablePicAddr();
			if(list.size()==0)
			{
				list.add(3, path);	
			}else
			{
				list.set(3, path);	
			}
			
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}

	public int insertIntoVegetablePic5(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetablePicAddr();
			if(list.size()==0)
			{
				list.add(4, path);	
			}else
			{
				list.set(4, path);	
			}
			
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}
	
	//插入蔬菜图片6
	
		public int insertIntoVegetablePic6(String vegetableId, String path)
		{
			// TODO Auto-generated method stub
			int flag=0;
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			try
			{
				Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
				List<String> list=v.getVegetablePicAddr();
				list.set(5, path);
				sess.save(v);
				sess.flush();
				flag=1;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
				throw new RuntimeException("系统错误");
			}finally
			{
				tx.commit();
				sess.close();
			}
			
			return flag;
		}
		//插入蔬菜图片7
		public int insertIntoVegetablePic7(String vegetableId, String path)
		{
			// TODO Auto-generated method stub
			int flag=0;
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			try
			{
				Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
				List<String> list=v.getVegetablePicAddr();
				list.set(6, path);
				sess.save(v);
				sess.flush();
				flag=1;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
				throw new RuntimeException("系统错误");
			}finally
			{
				tx.commit();
				sess.close();
			}
			
			return flag;
		}
		//插入蔬菜图片8
		public int insertIntoVegetablePic8(String vegetableId, String path)
		{
			// TODO Auto-generated method stub
			int flag=0;
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			try
			{
				Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
				List<String> list=v.getVegetablePicAddr();
				list.set(7, path);
				sess.save(v);
				sess.flush();
				flag=1;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
				throw new RuntimeException("系统错误");
			}finally
			{
				tx.commit();
				sess.close();
			}
			
			return flag;
		}
		//插入蔬菜图片9
		public int insertIntoVegetablePic9(String vegetableId, String path)
		{
			// TODO Auto-generated method stub
			int flag=0;
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			try
			{
				Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
				List<String> list=v.getVegetablePicAddr();
				list.set(8, path);
				sess.save(v);
				sess.flush();
				flag=1;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
				throw new RuntimeException("系统错误");
			}finally
			{
				tx.commit();
				sess.close();
			}
			
			return flag;
		}
		//插入蔬菜图片10
		public int insertIntoVegetablePic10(String vegetableId, String path)
		{
			// TODO Auto-generated method stub
			int flag=0;
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			try
			{
				Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
				List<String> list=v.getVegetablePicAddr();
				list.set(9, path);
				sess.save(v);
				sess.flush();
				flag=1;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
				throw new RuntimeException("系统错误");
			}finally
			{
				tx.commit();
				sess.close();
			}
			
			return flag;
		}
		//插入蔬菜图片11
		public int insertIntoVegetablePic11(String vegetableId, String path)
		{
			// TODO Auto-generated method stub
			int flag=0;
			Session sess=springUtil.getSession();
			Transaction tx=sess.beginTransaction();
			try
			{
				Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
				List<String> list=v.getVegetablePicAddr();
				list.set(10, path);
				sess.save(v);
				sess.flush();
				flag=1;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
				throw new RuntimeException("系统错误");
			}finally
			{
				tx.commit();
				sess.close();
			}
			
			return flag;
		}
		

	public int deleteVegetableById(String vegetableId)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		int  result;
		try
		{
			String sql="delete  from vegetable where vegetableID=?";
			 result= sess.createSQLQuery(sql).setString(0, vegetableId).executeUpdate();
			/*int result=sess.createQuery("delete Vegetable v where v.vegetableID=:vegetableID ").setString("vegetableID", vegetableId).executeUpdate();
			flag=1;*/
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return result;
		
		
		
	}

	public int updateVegetableById(Vegetable vegetable)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			
			
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetable.getVegetableID()));
			v.setVegetableName(vegetable.getVegetableName());
			v.setVegetableDiscount(vegetable.getVegetableDiscount());
			v.setVegetableInfo(vegetable.getVegetableInfo());
			v.setVegetablePrice(vegetable.getVegetablePrice());
			v.setVegetableQuantity(vegetable.getVegetableQuantity());
			v.setVegetableCatagory(vegetable.getVegetableCatagory());
			v.setVegetableKeyWords(vegetable.getVegetableKeyWords());
			v.setVegetableUnit(vegetable.getVegetableUnit());
			v.setVegetableSaleCount(vegetable.getVegetableSaleCount());
			v.setIsRecommend(vegetable.getIsRecommend());
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;	
	}

//管理员插入更新蔬菜简介图片地址1
	public int insertIntoVegetableInfoPicAddr1(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetableInfoPicAddr();
			if(list.size()==0)
			{
				list.add(0,path);
			}else
			{
				list.set(0, path);	
			}
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}
	//管理员插入更新蔬菜简介图片地址2
	public int insertIntoVegetableInfoPicAddr2(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetableInfoPicAddr();
			if(list.size()==0)
			{
				list.add(1, path);	
			}else
			{
				list.set(1, path);
			}
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}

	//管理员插入更新蔬菜简介图片地址3
	public int insertIntoVegetableInfoPicAddr3(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetableInfoPicAddr();
			if(list.size()==0)
			{
				list.add(2, path);	
			}else
			{
				list.set(2, path);	
			}
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}

	//管理员插入更新蔬菜简介图片地址4
	public int insertIntoVegetableInfoPicAddr4(String vegetableId, String path)
	{
		// TODO Auto-generated method stub
		int flag=0;
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Vegetable v=(Vegetable)sess.get(Vegetable.class, new String(vegetableId));
			List<String> list=v.getVegetableInfoPicAddr();
			if(list.size()==0)
			{
				list.add(3, path);	
			}else
			{
				list.set(3, path);	
			}
			
			sess.save(v);
			sess.flush();
			flag=1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("系统错误");
		}finally
		{
			tx.commit();
			sess.close();
		}
		
		return flag;
	}
	//随机查询相同类别蔬菜3个
	public List<Vegetable> findSameCatVegetable(String vegetableCatagory)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> list=new ArrayList<Vegetable>();
		List<Vegetable>  list2=new ArrayList<Vegetable>();
		try
		{
			
			list=sess.createQuery("from Vegetable as v where v.vegetableCatagory=:vegetableCatagory").setString("vegetableCatagory", vegetableCatagory).list();
			int size=list.size();
			if(size<=3)
			{
				return list;
			}
			/*double i,j,k;
			i=Math.floor(size%3)*1;
			j=Math.floor(size%3)*2;
			k=Math.floor(size%3)*3;*/
			
			Random r=new Random();
			
			for(int i=1;i<=3;i++)
			{
				/*Vegetable v=list.get(r.nextInt(Integer.parseInt(String.valueOf(i))*3));*/
				
				Vegetable v=list.remove(r.nextInt(list.size()));
				
				list2.add(v);
			}
			
			return list2;
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();sess.close();
		}
			
		
	}
//查找热销商品
	public List<Vegetable> findVegetablesBySale()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> list=new ArrayList<Vegetable>();
		try
		{
			
			list=sess.createCriteria(Vegetable.class).addOrder(Order.desc("vegetableSaleCount")).setMaxResults(3).list();
			
			
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();sess.close();
		}
			
		return list;
		
	}

	//随机产生八个特价商品，用于主页显示
	public List<Vegetable> findEightDiscountVeg()
	{
		// TODO Auto-generated method stub
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> list=new ArrayList<Vegetable>();
		List<Vegetable>  list2=new ArrayList<Vegetable>();
		try
		{
			
			list=sess.createCriteria(Vegetable.class).addOrder(Order.desc("vegetableSaleCount")).list();
			int size=list.size();
			if(size<=8)
			{
				return list;
			}
			/*double i,j,k;
			i=Math.floor(size%3)*1;
			j=Math.floor(size%3)*2;
			k=Math.floor(size%3)*3;*/
			
			Random r=new Random();
			for(int i=1;i<=8;i++)
			{
				/*Vegetable v=list.get(r.nextInt(Integer.parseInt(String.valueOf(i))*3));*/
				
				Vegetable v=list.remove(r.nextInt(list.size()));
				list2.add(v);
			}
			return list2;
			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();sess.close();
		}
		
		
	}

	public List<Vegetable> findEightRecommandVeg()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> list=new ArrayList<Vegetable>();
		List<Vegetable> list2=new ArrayList<Vegetable>();
		try
		{
			
			list=sess.createCriteria(Vegetable.class).add(Restrictions.eq("isRecommend", 1)).addOrder(Order.desc("vegetableSaleCount")).list();
			int size=list.size();
			if(size<=8)
			{
				return list;
			}
			/*double i,j,k;
			i=Math.floor(size%3)*1;
			j=Math.floor(size%3)*2;
			k=Math.floor(size%3)*3;*/
			
			Random r=new Random();
			for(int i=1;i<=8;i++)
			{
				/*Vegetable v=list.get(r.nextInt(Integer.parseInt(String.valueOf(i))*3));*/
				
				Vegetable v=list.remove(r.nextInt(list.size()));
				list2.add(v);
			}
			return list2;

			
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();throw new HibernateException("系统异常");
		}finally
		{
			tx.commit();sess.close();
		}
		
		
		
		
		
	}

	//查询热点关键词，提供给首页
	public List<String> findHotKeyWords()
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		List<Vegetable> list=sess.createCriteria(Vegetable.class).addOrder(Order.desc("vegetableSaleCount")).setMaxResults(5).list();
		StringBuilder sb=new StringBuilder();
		List<String> listKeyWords=new ArrayList<String>();
		for(Vegetable v:list)
		{
			
			sb.append(","+v.getVegetableKeyWords());
			
		}
		System.out.println("keyWords:"+sb.toString());
		String[] keyWords=sb.toString().split(",");
		List<String> temp=new ArrayList<String>();
		for(String keyWord:keyWords)
		{
			temp.add(keyWord);
		}
		System.out.println("keyWords.length:"+keyWords.length);
		Set set=new HashSet();
		for( Iterator ite=temp.iterator(); ite.hasNext();)
		{
		Object element=ite.next();
			if(set.add(element))
			{
				
				listKeyWords.add((String)element);
			}
			
		}
		
		/*for(int i=0;i<temp.size()-1;i++)
		{
			for(int j=i+1;j<temp.size();j++)
			{
				if(temp.get(i).equals(temp.get(j)))
				{
					
					
					continue;
				}
				
			}
		}	*/
		
		for(String keyWord:listKeyWords)
		{
			System.out.println("keywords:"+keyWord);
		}
		tx.commit();sess.close();
		
		return listKeyWords;
	}
//根据类别查找热门关键字
	public List<String> findHotKeysRefParam(String param)
	{
		// TODO Auto-generated method stub
		
		
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		
		String hql="from Vegetable as v where v.vegetableCatagory=:param order by v.vegetableSaleCount";
		List<Vegetable> list=sess.createQuery(hql).setString("param", param).setMaxResults(5).list();
		StringBuilder sb=new StringBuilder();
		List<String> listKeyWords=new ArrayList<String>();
		for(Vegetable v:list)
		{
			
			sb.append(","+v.getVegetableKeyWords());
			
		}
		System.out.println("keyWords:"+sb.toString());
		String[] keyWords=sb.toString().split(",");
		List<String> temp=new ArrayList<String>();
		for(String keyWord:keyWords)
		{
			temp.add(keyWord);
		}
		System.out.println("keyWords.length:"+keyWords.length);
		Set set=new HashSet();
		for( Iterator ite=temp.iterator(); ite.hasNext();)
		{
		Object element=ite.next();
			if(set.add(element))
			{
				
				listKeyWords.add((String)element);
			}
			
		}
		
		/*for(int i=0;i<temp.size()-1;i++)
		{
			for(int j=i+1;j<temp.size();j++)
			{
				if(temp.get(i).equals(temp.get(j)))
				{
					
					
					continue;
				}
				
			}
		}	*/
		
		for(String keyWord:listKeyWords)
		{
			System.out.println("keywords:"+keyWord);
		}
		tx.commit();sess.close();
		
		return listKeyWords;
	}
//根据类别查找所有的关键词。放在listproducts.jsp
	public List<String> findAllHotKeysRefParam(String param)
	{
		// TODO Auto-generated method stub
		Session sess=springUtil.getSession();
		Transaction tx=sess.beginTransaction();
		
		String hql="from Vegetable as v where v.vegetableCatagory=:param order by v.vegetableSaleCount";
		List<Vegetable> list=sess.createQuery(hql).setString("param", param).setMaxResults(10).list();
		StringBuilder sb=new StringBuilder();
		List<String> listKeyWords=new ArrayList<String>();
		for(Vegetable v:list)
		{
			
			sb.append(","+v.getVegetableKeyWords());
			
		}
		System.out.println("keyWords:"+sb.toString());
		String[] keyWords=sb.toString().split(",");
		List<String> temp=new ArrayList<String>();
		for(String keyWord:keyWords)
		{
			temp.add(keyWord);
		}
		System.out.println("keyWords.length:"+keyWords.length);
		Set set=new HashSet();
		for( Iterator ite=temp.iterator(); ite.hasNext();)
		{
		Object element=ite.next();
			if(set.add(element))
			{
				
				listKeyWords.add((String)element);
			}
			
		}
		
		/*for(int i=0;i<temp.size()-1;i++)
		{
			for(int j=i+1;j<temp.size();j++)
			{
				if(temp.get(i).equals(temp.get(j)))
				{
					
					
					continue;
				}
				
			}
		}	*/
		
		for(String keyWord:listKeyWords)
		{
			System.out.println("keywords:"+keyWord);
		}
		tx.commit();sess.close();
		
		return listKeyWords;
	}


		
		
	

	
}
