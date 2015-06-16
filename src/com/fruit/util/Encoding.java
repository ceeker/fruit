package com.fruit.util;

public class Encoding 
{
	String str=null;
	byte[] b=new byte[1024];
	public void setStr(String s)
	{
		str=s;
	
	}
	public String codeToString(String str)
	{		str=str;
			if(str==null)
			{
				return null;
			}
		
	try
		{
		b=str.getBytes("ISO8859-1");
		
			return new String(b,"utf-8");
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
			return str;
		}
	}
	/*public static void main(String[] args)
	{
		Encoding e=new Encoding();
		String s=e.codeToString("我偶们");
		System.out.print(s);
	}*/
}
