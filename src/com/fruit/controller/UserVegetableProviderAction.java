package com.fruit.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.fruit.domain.Book;
import com.fruit.domain.Cart;
import com.fruit.domain.Vegetable;
import com.fruit.service.UserVegetableService;
import com.fruit.util.Encoding;
import com.opensymphony.xwork2.ActionSupport;

public class UserVegetableProviderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware
{

	

	private HttpServletResponse response;
	private HttpServletRequest request;
	private UserVegetableService userVegetableService;
	private List<Vegetable> listVegetables=new ArrayList<Vegetable>();
	private String flag;
	private String vegetableID;
	private Vegetable vegetable;
	private String keyWord;
	private int vegetableMount;
	private String cartId;
	private Cart cart;
	private long countCart;
	private String json;
	private String order;
	private String sort;
	private String from;
	private String isEmpty;
	private ServletContext servletContext;
	private List<Book> listBooks=new ArrayList<Book>();
	private String bookPhone;
	public String getBookPhone()
	{
		return bookPhone;
	}

	public void setBookPhone(String bookPhone)
	{
		this.bookPhone = bookPhone;
	}

	public String getBookAddr()
	{
		return bookAddr;
	}

	public void setBookAddr(String bookAddr)
	{
		this.bookAddr = bookAddr;
	}
	private String bookAddr;
	public List<Book> getListBooks()
	{
		return listBooks;
	}

	public void setListBooks(List<Book> listBooks)
	{
		this.listBooks = listBooks;
	}
	private String hot;
	public String getHot()
	{
		return hot;
	}

	public void setHot(String hot)
	{
		this.hot = hot;
	}

	public String getIsEmpty()
	{
		return isEmpty;
	}

	public void setIsEmpty(String isEmpty)
	{
		this.isEmpty = isEmpty;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getSort()
	{
		return sort;
	}

	public void setSort(String sort)
	{
		this.sort = sort;
	}

	public String getOrder()
	{
		return order;
	}

	public void setOrder(String order)
	{
		this.order = order;
	}
	private List<Book> listOfResult=new ArrayList<Book>();
	public JSONObject jo=new JSONObject();

	public JSONObject getJo()
	{
		return jo;
	}

	public void setJo(JSONObject jo)
	{
		this.jo = jo;
	}

	public List<Book> getListOfResult()
	{
		return listOfResult;
	}

	public void setListOfResult(List<Book> listOfResult)
	{
		this.listOfResult = listOfResult;
	}

	public String getJson()
	{
		return json;
	}

	public void setJson(String json)
	{
		this.json = json;
	}
	private List<Cart> listCart=new ArrayList<Cart>();
	
	public List<Cart> getListCart()
	{
		return listCart;
	}

	public void setListCart(List<Cart> listCart)
	{
		this.listCart = listCart;
	}

	public long  getCountCart()
	{
		return countCart;
	}

	public void setCountCart(long countCart)
	{
		this.countCart = countCart;
	}

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(Cart cart)
	{
		this.cart = cart;
	}

	public UserVegetableService getUserVegetableService()
	{
		return userVegetableService;
	}

	public void setUserVegetableService(UserVegetableService userVegetableService)
	{
		this.userVegetableService = userVegetableService;
	}

	public String getCartId()
	{
		return cartId;
	}

	public void setCartId(String cartId)
	{
		this.cartId = cartId;
	}

	public int getVegetableMount()
	{
		return vegetableMount;
	}

	public void setVegetableMount(int vegetableMount)
	{
		this.vegetableMount = vegetableMount;
	}

	public String getKeyWord()
	{
		return new Encoding().codeToString(keyWord);
	}

	public void setKeyWord(String keyWord)
	{
		this.keyWord = keyWord;
	}

	public Vegetable getVegetable()
	{
		return vegetable;
	}

	public void setVegetable(Vegetable vegetable)
	{
		this.vegetable = vegetable;
	}

	public String getVegetableID()
	{
		return vegetableID;
	}

	public void setVegetableID(String vegetableID)
	{
		this.vegetableID = vegetableID;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public List<Vegetable> getListVegetables()
	{
		return listVegetables;
	}

	public void setListVegetables(List<Vegetable> listVegetables)
	{
		this.listVegetables = listVegetables;
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
	//用户查询所有的蔬菜
	public String getAllVegetables()
	{
		try
		{
			listVegetables=userVegetableService.getAllVegetables();
			if(listVegetables.size()==0)
		{
				flag="no data";
				return "fail"; 
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="系统异常";
			return "error";
		}
		flag="ok";
		return "ok";
	}
	//用户查询单个蔬菜
	public String findVegetableById()
	{
		try
		{
			vegetable=userVegetableService.findVegtableById(vegetableID);
			if(vegetable!=null)
			{
				flag="no data";
				return "fail"; 
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="系统异常";
			return "error";
		}
		flag="ok";
		return "ok";
		
	}
	//用户根据关键字查询蔬菜
	public String findVegetableByKeyWord()
	{
		try
		{
			
			Integer offset=(Integer)request.getSession().getAttribute("offset");
			Integer length=(Integer)request.getSession().getAttribute("length");
			String isLast=(String)request.getSession().getAttribute("isLast");
			System.out.println("from 是否等于0"+from.equals("0"));
			
			System.out.println("offset的值："+offset);
			if(offset==null||length==null||isLast==null)
			{
				offset=0;
				length=20;
				
				isLast="false";
			}
			
			if(from.equals("0"))
			{
				offset=0;
				length=20;
				
				isLast="false";
			}
			System.out.println("from 的值："+from);
			
			
			
			listVegetables=userVegetableService.findVegetableByKeyWord(offset,length,new Encoding().codeToString(keyWord),order,sort);
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			if(listVegetables.size()==0)
			{
				isEmpty="yes";
				
				
			}else
			{
				isEmpty="false";
			}
			if(listVegetables.size()!=20)
			{
				
				
				isLast="true";
				
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
			request.getSession().setAttribute("offset", listVegetables.size());
			request.getSession().setAttribute("length", 20);
			request.getSession().setAttribute("isLast", isLast);
			
			/*
			if(offset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice", v.getVegetablePrice()*v.getVegetableDiscount()/10);
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
				}
				
				
				
				jo.put("isLast", isLast);
				jo.put("data", ja);
				response.setContentType("text/json;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			*/
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
		return "ok";
	}
	//返回json 瀑布流
	public void findVegetableFlow()
	{
		try
		{
			Integer offset=(Integer)request.getSession().getAttribute("offset");
			Integer length=(Integer)request.getSession().getAttribute("length");
			String isLast=(String)request.getSession().getAttribute("isLast");
			
			System.out.println("offset的值："+offset);
			System.out.println("length的值："+length);
			System.out.println("isLast的值："+isLast);
			
			
			listVegetables=userVegetableService.findVegetableByKeyWord(offset,length,new Encoding().codeToString(keyWord),order,sort);
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			System.out.println(" flow  keyWord:"+keyWord);
		
			if(listVegetables.size()!=20)
			{
				flag="no such Vegetables";
				
				isLast="true";
				
			}else
			{
				isLast="false";
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
		/*	ServletActionContext.getPageContext().setAttribute("offset",listVegetables.size()+20);
			ServletActionContext.getPageContext().setAttribute("length",20);
			ServletActionContext.getPageContext().setAttribute("isLast",isLast);*/
			request.getSession().setAttribute("offset", listVegetables.size()+20);
			request.getSession().setAttribute("length", 20);
			request.getSession().setAttribute("isLast", isLast);
			
			
			if(offset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					
					BigDecimal   b   =   new   BigDecimal(v.getVegetablePrice()*v.getVegetableDiscount()/10);
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice",b.setScale(2, BigDecimal.ROUND_HALF_UP));
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
					
				}
				
				
				
				jo.put("isLast", isLast);
				jo.put("data", ja);
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
		
	}
	
	
	
	
	//用户将蔬菜添加到购物车
	public void insertIntoCart() throws Exception
	{
		
		Object user=request.getSession().getAttribute("userId");
		if(user==null ||user.equals(""))
		{
			flag="您还没有登录,请登录";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
	
		}else
		{
			
		
		String userId=user.toString();
		int result=userVegetableService.insertIntoCart(userId,vegetableID,vegetableMount);
		if(result==1)
		{
			flag="ok";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("true");
			
		}
		else
		{
			flag="fail";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
		}
		
		}
	}
	//修改购物车中此蔬菜的数量
	public String updateCartVegetableMount()
	{
		
		try
		{
			int result=userVegetableService.updateCartVegetableMount(cartId,vegetableMount);
			if(result==1)
			{
				flag="ok";
				return "ok";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="系统异常";
			return "error";
		}
		flag="修改失败";
		return "fail";
		
		
	}
	//删除购物车的蔬菜
	public void deleteCart() throws Exception
	{
		try
		{
			System.out.println("cartId 的值"+cartId);
			int result=userVegetableService.deleteCart(cartId);
			System.out.println("result 的值"+result);
			if(result==1)
			{
				flag="ok";
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("true");
			}
			else
			{
				flag="删除失败";
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write("false");
			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("false");
		}
	}		
	
	//查询购物车中的蔬菜
		public String findCart()
		{
			
			try
			{
				cart=userVegetableService.findCart(cartId);
				if(cart!=null)
				{
					flag="ok";
					return "ok";
				}
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag="error";
				return "error";
				
			}
		
		flag="fail";
		return "fail";
		
		}

	//订购蔬菜,即将购物车转化为订单
	public void book()throws Exception
	{
		JSONArray ja=JSONArray.fromObject(json);
		System.out.print(ja);
		List<Book> listBooks=new ArrayList<Book>();
		for(int i=0;i<ja.size();i++)
		{
			Book book=new Book();
			JSONObject jo=(JSONObject)ja.get(i);
			book.setBookId(jo.getString("cartID"));
			book.setBookQuantity(jo.getInt("count"));
			
			listBooks.add(book);
			
		}
		
		
		
		
		try
		{
			listOfResult=userVegetableService.book(listBooks);
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="系统异常";
			
		}
		request.getSession().setAttribute("listBooks", listOfResult);
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("true");
	}
	//去付款
	public String pay()
	{
		Object o=request.getSession().getAttribute("listBooks");
		if(o==null)
		{
			flag="您没有订单！";
			return "fail";
		}else
		{
			List listOfResult=(List<Book>)o;
			List listBooks1=new ArrayList<Book>();
			for(int i=0;i<listOfResult.size();i++)
			{
				Book book=(Book)listOfResult.get(i);
				book.setBookAddr(bookAddr);
				book.setBookPhone(bookPhone);
				listBooks1.add(book);
			}
			try
			{
				listOfResult=userVegetableService.book(listBooks1);
				
				return "ok";
				
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag="系统异常";
				return "error";
			}
			
		}
	} 
	
	
	
	
	
	
	
	
	//用户查询自己的订单
	public void findBook() throws Exception
	{
		Object o=request.getSession().getAttribute("userId");
		JSONArray ja=new JSONArray();
		if(o==null)
		{
			return ;
		}
		else
		{
			String userId=o.toString();
		
			listBooks=userVegetableService.findBook(userId);
			if(listBooks.size()==0)
			{
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(ja.toString());
			}
			else
			{
				for(Book book:listBooks)
				{
					BigDecimal   b   =   new   BigDecimal(book.getBookVegetable().getVegetableDiscount()*book.getBookVegetable().getVegetablePrice()*book.getBookQuantity()/10);
					JSONObject jo=new JSONObject();
					jo.put("bookId", book.getBookId());
					jo.put("bookVegetable", book.getBookVegetable().getVegetableName());
					jo.put("bookVegetablePic", book.getBookVegetable().getVegetablePicAddr().get(2));
					jo.put("bookUser", book.getBookUser().getUserName());
					jo.put("bookDate",book.getBookDate().toLocaleString());
					jo.put("bookVegetableHref", "findVegetableByIdAction?vegetableId="+book.getBookVegetable().getVegetableID());
					jo.put("bookVegetablePrice", b.setScale(2, BigDecimal.ROUND_HALF_UP));
					jo.put("bookQuantity", book.getBookQuantity());
					jo.put("isConfirm", book.getIsConfirm());
					
					ja.add(jo);
				}
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(ja.toString());
			}
		}
	}
	
	
	//查询购物车中蔬菜的数量
	public String countCart()
	{
		
		Object user=request.getSession().getAttribute("userId");
		System.out.print("session 中的用户是否为空"+user==null);
		if(user==null)
		{
			countCart=0;
			System.out.print("session 中的用户是否为空"+user==null);
			
			return "ok";
		}
		else{
		
		try
		{
			String userId=user.toString();
			System.out.println("session 中德userId"+userId);
			countCart=userVegetableService.countCart(userId);
			flag="ok";
			return "ok";
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			return "error";
		}
		
		}
	}
	//用户查询所有的购物车
	public String findAllCart()
	{
		Object user=request.getSession().getAttribute("userId");
		System.out.print("session 中的用户是否为空"+user==null);
		if(user==null)
		{
			countCart=0;
			System.out.print("session 中的用户是否为空"+user==null);
			flag="fail";
			return "ok";
		}
		
			String userId=user.toString();
			listCart=userVegetableService.findAllCart(userId);
			if(listCart.isEmpty())
			{
				flag="ok";
				return "ok";
			}
			flag="ok";
			System.out.println("购物车中蔬菜的名字"+listCart.get(0).getCartVegetable().getVegetableName());
			return "ok";
		
		
	}

	@Override
	public void setServletContext(ServletContext servletContext)
	{
		// TODO Auto-generated method stub
		this.servletContext=servletContext;
	}
	
	//查找所有热销商品，同样以瀑布流的形式
	
	public String findSaleVegetables()
	{
		System.out.println("查找所有热销商品，同样以瀑布流的形式");
		try
		{
			
			Integer hotoffset=(Integer)request.getSession().getAttribute("hotoffset");
			Integer hotlength=(Integer)request.getSession().getAttribute("hotlength");
			String hotisLast=(String)request.getSession().getAttribute("hotisLast");
			System.out.println("from 是否等于0"+from.equals("0"));
			
			hot="hot";
			if(hotoffset==null||hotlength==null||hotisLast==null)
			{
				hotoffset=0;
				hotlength=20;
				
				hotisLast="false";
			}
			
			if(from.equals("0"))
			{
				hotoffset=0;
				hotlength=20;
				
				hotisLast="false";
			}
			System.out.println("from 的值："+from);
			
			
			
			
			
			listVegetables=userVegetableService.findSaleVegetables(hotoffset,hotlength,order,sort);
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			if(listVegetables.size()==0)
			{
				isEmpty="yes";
				
				
			}else
			{
				isEmpty="false";
			}
			if(listVegetables.size()!=20)
			{
				
				
				hotisLast="true";
				
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
			request.getSession().setAttribute("hotoffset", listVegetables.size());
			request.getSession().setAttribute("hotlength", 20);
			request.getSession().setAttribute("hotisLast", hotisLast);
			
			/*
			if(offset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice", v.getVegetablePrice()*v.getVegetableDiscount()/10);
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
				}
				
				
				
				jo.put("isLast", isLast);
				jo.put("data", ja);
				response.setContentType("text/json;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			*/
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
		return "ok";
	}
	//查找所有热销商品，以Ajax瀑布流的形式
	public void findSaleVegetablesFlow()
	{
		hot="hot";
		try
		{
			Integer hotoffset=(Integer)request.getSession().getAttribute("hotoffset");
			Integer hotlength=(Integer)request.getSession().getAttribute("hotlength");
			String hotisLast=(String)request.getSession().getAttribute("hotisLast");
			
			System.out.println("offset的值："+hotoffset);
			System.out.println("length的值："+hotlength);
			System.out.println("isLast的值："+hotisLast);
			
			listVegetables=userVegetableService.findSaleVegetables(hotoffset,hotlength,order,sort);
			
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			System.out.println(" flow  keyWord:"+keyWord);
		
			if(listVegetables.size()!=20)
			{
				flag="no such Vegetables";
				
				hotisLast="true";
				
			}else
			{
				hotisLast="false";
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
		/*	ServletActionContext.getPageContext().setAttribute("offset",listVegetables.size()+20);
			ServletActionContext.getPageContext().setAttribute("length",20);
			ServletActionContext.getPageContext().setAttribute("isLast",isLast);*/
			request.getSession().setAttribute("hotoffset", listVegetables.size()+20);
			request.getSession().setAttribute("hotlength", 20);
			request.getSession().setAttribute("hotisLast", hotisLast);
			
			
			if(hotoffset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					
					BigDecimal   b   =   new   BigDecimal(v.getVegetablePrice()*v.getVegetableDiscount()/10);
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice",b.setScale(2, BigDecimal.ROUND_HALF_UP));
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
					
				}
				
				
				
				jo.put("hotisLast", hotisLast);
				jo.put("data", ja);
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
	}
	//用户查询所有的新鲜蔬果
	public String findFreshVegetables()
	{
		System.out.println("查找所有热销商品，同样以瀑布流的形式");
		try
		{
			
			Integer freshoffset=(Integer)request.getSession().getAttribute("freshoffset");
			Integer freshlength=(Integer)request.getSession().getAttribute("freshlength");
			String freshisLast=(String)request.getSession().getAttribute("freshisLast");
			System.out.println("from 是否等于0"+from.equals("0"));
			
			
			if(freshoffset==null||freshlength==null||freshisLast==null)
			{
				freshoffset=0;
				freshlength=20;
				
				freshisLast="false";
			}
			
			if(from.equals("0"))
			{
				freshoffset=0;
				freshlength=20;
				
				freshisLast="false";
			}
			System.out.println("from 的值："+from);
			
			
			
			
			
			listVegetables=userVegetableService.findFreshVegetables(freshoffset,freshlength,order,sort);
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			if(listVegetables.size()==0)
			{
				isEmpty="yes";
				
				
			}else
			{
				isEmpty="false";
			}
			if(listVegetables.size()!=20)
			{
				
				
				freshisLast="true";
				
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
			request.getSession().setAttribute("freshoffset", listVegetables.size());
			request.getSession().setAttribute("freshlength", 20);
			request.getSession().setAttribute("freshisLast", freshisLast);
			
			/*
			if(offset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice", v.getVegetablePrice()*v.getVegetableDiscount()/10);
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
				}
				
				
				
				jo.put("isLast", isLast);
				jo.put("data", ja);
				response.setContentType("text/json;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			*/
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
		return "ok";
	}
	//查找新鲜水果，以瀑布流的形式
	public void findFreshVegetablesFlow()
	{
		
		try
		{
			Integer freshoffset=(Integer)request.getSession().getAttribute("freshoffset");
			Integer freshlength=(Integer)request.getSession().getAttribute("freshlength");
			String freshisLast=(String)request.getSession().getAttribute("freshisLast");
			
			System.out.println("offset的值："+freshoffset);
			System.out.println("length的值："+freshlength);
			System.out.println("isLast的值："+freshisLast);
			
			listVegetables=userVegetableService.findFreshVegetables(freshoffset,freshlength,order,sort);
			
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			System.out.println(" flow  keyWord:"+keyWord);
		
			if(listVegetables.size()!=20)
			{
				flag="no such Vegetables";
				
				freshisLast="true";
				
			}else
			{
				freshisLast="false";
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
		/*	ServletActionContext.getPageContext().setAttribute("offset",listVegetables.size()+20);
			ServletActionContext.getPageContext().setAttribute("length",20);
			ServletActionContext.getPageContext().setAttribute("isLast",isLast);*/
			request.getSession().setAttribute("freshoffset", listVegetables.size()+20);
			request.getSession().setAttribute("freshlength", 20);
			request.getSession().setAttribute("freshisLast", freshisLast);
			
			
			if(freshoffset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					
					BigDecimal   b   =   new   BigDecimal(v.getVegetablePrice()*v.getVegetableDiscount()/10);
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice",b.setScale(2, BigDecimal.ROUND_HALF_UP));
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
					
				}
				
				
				
				jo.put("freshisLast", freshisLast);
				jo.put("data", ja);
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
	}
	//查找所有的优惠商品
	public String findDiscountVegetables()
	{
		System.out.println("查找所有热销商品，同样以瀑布流的形式");
		try
		{
			
			Integer discountoffset=(Integer)request.getSession().getAttribute("freshoffset");
			Integer discountlength=(Integer)request.getSession().getAttribute("freshlength");
			String discountisLast=(String)request.getSession().getAttribute("freshisLast");
			System.out.println("from 是否等于0"+from.equals("0"));
			
			
			if(discountoffset==null||discountlength==null||discountisLast==null)
			{
				discountoffset=0;
				discountlength=20;
				
				discountisLast="false";
			}
			
			if(from.equals("0"))
			{
				discountoffset=0;
				discountlength=20;
				
				discountisLast="false";
			}
			System.out.println("from 的值："+from);
			
			
			
			
			
			listVegetables=userVegetableService.findDiscountVegetables(discountoffset,discountlength,order,sort);
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			if(listVegetables.size()==0)
			{
				isEmpty="yes";
				
				
			}else
			{
				isEmpty="false";
			}
			if(listVegetables.size()!=20)
			{
				
				
				discountisLast="true";
				
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
			request.getSession().setAttribute("discountoffset", listVegetables.size());
			request.getSession().setAttribute("discountlength", 20);
			request.getSession().setAttribute("discountisLast", discountisLast);
			
			/*
			if(offset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice", v.getVegetablePrice()*v.getVegetableDiscount()/10);
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
				}
				
				
				
				jo.put("isLast", isLast);
				jo.put("data", ja);
				response.setContentType("text/json;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			*/
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
		return "ok";
	}
	
	//查询所有的特惠商品，以瀑布的形式
	public void findDiscountVegetablesFlow()
	{
		try
		{
			Integer discountoffset=(Integer)request.getSession().getAttribute("discountoffset");
			Integer discountlength=(Integer)request.getSession().getAttribute("discountlength");
			String discountisLast=(String)request.getSession().getAttribute("discountisLast");
			
			System.out.println("offset的值："+discountoffset);
			System.out.println("length的值："+discountlength);
			System.out.println("isLast的值："+discountisLast);
			
			listVegetables=userVegetableService.findDiscountVegetables(discountoffset,discountlength,order,sort);
			
			System.out.println("list的size："+listVegetables.size());
			System.out.println(isEmpty);
			System.out.println(" flow  keyWord:"+keyWord);
		
			if(listVegetables.size()!=20)
			{
				flag="no such Vegetables";
				
				discountisLast="true";
				
			}else
			{
				discountisLast="false";
			}
			for(Vegetable v:listVegetables)
			{
				System.out.println("vegetable saleCount："+v.getVegetableSaleCount());
			}
			
			
		/*	ServletActionContext.getPageContext().setAttribute("offset",listVegetables.size()+20);
			ServletActionContext.getPageContext().setAttribute("length",20);
			ServletActionContext.getPageContext().setAttribute("isLast",isLast);*/
			request.getSession().setAttribute("discountoffset", listVegetables.size()+20);
			request.getSession().setAttribute("discountlength", 20);
			request.getSession().setAttribute("discountisLast", discountisLast);
			
			
			if(discountoffset>=20)
			{
				Map<String,JSONArray> data=new HashMap<String,JSONArray>();
				JSONArray ja=new JSONArray();
				for(Vegetable v:listVegetables)
				{
					
					BigDecimal   b   =   new   BigDecimal(v.getVegetablePrice()*v.getVegetableDiscount()/10);
					JSONObject joIn=new JSONObject();
					joIn.put("vegetableID", v.getVegetableID());
					System.out.println("vegetableID:"+v.getVegetableID());
					joIn.put("vegetableName", v.getVegetableName());
					joIn.put("vegetableNowPrice",b.setScale(2, BigDecimal.ROUND_HALF_UP));
					joIn.put("vegetableSaleCount", v.getVegetableSaleCount());
					joIn.put("vegetablePicAddr", v.getVegetablePicAddr().get(1));
					joIn.put("src", "findVegetableByIdAction?vegetableId="+v.getVegetableID());
					ja.add(joIn);
					
					
				}
				
				
				
				jo.put("discountisLast", discountisLast);
				jo.put("data", ja);
				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jo.toString());
			}
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag="error";
			
		}
		flag="ok";
	
	}
	
}
