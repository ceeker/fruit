package com.fruit.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


  public class DateFormatUtil
{
	/*public static void main(String[] args)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddhhmmss");
		Date date=new Date();
		String dateStr=sdf.format(date);
		System.out.print(dateStr);
		
	}*/
	 private  Date  date;
	private String dateStr;
	private static DateFormatUtil dfu;
	private DateFormatUtil()
	{
		
	}
	public static DateFormatUtil getInstance()
	{
		if(dfu==null)
		{
			return new DateFormatUtil();
		}
		return  dfu;
	}
	public String format(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		dateStr=sdf.format(date);
		return dateStr;
		
	}
	//将字符串转换为日期
	public Date formatToDate(String str) 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try
		{
			 date=sdf.parse(str);
			return date;
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("字符串转换日期异常");
			
		}
	}
}
