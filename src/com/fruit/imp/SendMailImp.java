package com.fruit.imp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;




import com.fruit.domain.MailMessage;
import com.fruit.inter.SendMail;

import sun.misc.BASE64Encoder;

public class SendMailImp implements SendMail
{
	public static final int SINA=0;
	public static final int QQ=1;
	public static final int FOXMAIL=2;
	public static final int WANGYI163=3;
	public static final int YEAH=4;
	public static final int HOTMAIL=5;
	public static final int YAHOO=6;
	public static final int GMAIL=7;
	
	private  Socket socket=null;
	private BufferedReader input=null;
	private BufferedWriter output=null;
	private String server=null;
	private int port;
	private MailMessage message;
	
	
	public Socket getSocket()
	{
		return socket;
	}

	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}

	public BufferedReader getInput()
	{
		return input;
	}

	public void setInput(BufferedReader input)
	{
		this.input = input;
	}

	public BufferedWriter getOutput()
	{
		return output;
	}

	public void setOutput(BufferedWriter output)
	{
		this.output = output;
	}

	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public MailMessage getMessage()
	{
		return message;
	}
	//设置邮件的信息内容,以方法连得方式实现
	public SendMailImp setMessage(MailMessage message)
	{
		this.message = message;
		return this;
	}

	@Override
	public int sendToServer(String order)
	{
		// TODO Auto-generated method stub
		
		try
		{
			this.getOutput().write(order);
			this.getOutput().newLine();
			this.getOutput().flush();
			System.out.println("已发送命令"+order);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return getResult();
	}

	@Override
	public int getResult()
	{
		// TODO Auto-generated method stub
		String line ="";
		try
		{
			line=this.getInput().readLine();
			System.out.println("服务器返回状态:"+line);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		//从服务器返回消息中获取状态码，并转换整数码返回
		StringTokenizer get=new StringTokenizer(line," ");
		return Integer.parseInt(get.nextToken());
	
	}

	@Override
	public void regist() throws IOException
	{
		// TODO Auto-generated method stub
		int result=getResult();
		if(result!=220)
		{
			throw new IOException("连接服务器失败");
			
		}
		result=sendToServer("HELO "+this.getServer());
		//HELO命令成功后，返回250应答
		if(result!=250)
		{
			throw new IOException("注册邮箱服务器失败");
		}
	}

	@Override
	public void login() throws IOException
	{
		// TODO Auto-generated method stub
		BASE64Encoder encoder=new BASE64Encoder();
		int result=sendToServer("AUTH LOGIN");
		//登录服务器成功，返回334应答
		if(result!=334)
		{
			throw new IOException("登录服务器失败");
		}
		//对邮箱用户名进行验证
		result=sendToServer(encoder.encode(this.message.getUser().getBytes()));
		if(result!=334)
		{
			throw new IOException("用户名错误");
		}
		//对邮箱密码进行验证
		result=sendToServer(encoder.encode(message.getPassword().getBytes()));
		if(result!=235)
		{
			throw new IOException("用户验证错误");
		}
	}

	@Override
	public void setMailFrom() throws IOException
	{
		// TODO Auto-generated method stub
		int result=sendToServer("MAIL FROM:<"+this.getMessage().getFrom()+">");
		if(result!=250)
		{
			throw new IOException("邮件源地址错误");
		}
		
	}

	@Override
	public void setMailTo() throws IOException
	{
		// TODO Auto-generated method stub
		int result=sendToServer("RCPT TO:<"+this.getMessage().getTo()+">");
		if(result!=250)
		{
			throw new IOException("邮件目的地错误");
		}
	}

	@Override
	public void setData() throws IOException
	{
		// TODO Auto-generated method stub
		int result=sendToServer("DATA");
		if(result!=354)
		{
			throw new IOException("不能发送数据");
			
		}
		this.getOutput().write("FROM:"+this.getMessage().getDataFrom());
		this.getOutput().newLine();
		this.getOutput().write("TO:"+this.getMessage().getDataTo());
		this.getOutput().newLine();
		this.getOutput().write("SUBJECT:"+this.getMessage().getSubject());
		this.getOutput().newLine();
		//注意，主题和内容之间应该换两行。
		this.getOutput().newLine();
		this.getOutput().write(this.getMessage().getContent());
		this.getOutput().newLine();
		//句点加回车结束邮件内容
		result=sendToServer(".");
		if(result!=250)
		{
			throw new IOException("发送数据失败");
		}
		
	}

	@Override
	public void quit() throws IOException
	{
		// TODO Auto-generated method stub
		int result=sendToServer("QUIT");
		if(result!=221)
		{
			throw new IOException("为嫩正确退出");
		}
		this.getInput().close();
		this.getOutput().close();
	}

	@Override
	public boolean sendMail() throws IOException
	{
		// TODO Auto-generated method stub
		boolean success=true;
		try
		{
			regist();
			login();
			setMailFrom();
			setMailTo();
			setData();
			quit();
		}catch(Exception e)
		{
			e.printStackTrace();
			success=false;
		}
		
		return success;
	}
	/**
	 * 根据邮箱类型，设置发送邮箱服务器和端口号
	 * @param sendMailTye
	 * @return
	 */
	public static  SendMailImp getInstance(int sendMailType)
	{
		SendMailImp sendMailImp=new SendMailImp();
		switch(sendMailType)
		{
		case SINA:
			sendMailImp.setServer("smtp.sina.com");
			sendMailImp.setPort(25);
			break;
		case QQ:
			sendMailImp.setServer("smtp.qq.com");
			sendMailImp.setPort(25);
			break;
		case FOXMAIL:
			sendMailImp.setServer("smtp.foxmail.com");
			sendMailImp.setPort(25);
			break;
		case WANGYI163:
			sendMailImp.setServer("smtp.163.com");
			sendMailImp.setPort(25);
			break;
			
		case YEAH:
			sendMailImp.setServer("smtp.yeah.net");
			sendMailImp.setPort(25);
			break;
		case HOTMAIL:
			sendMailImp.setServer("smtp.live.com");
			sendMailImp.setPort(25);
			break;
		case GMAIL:
			sendMailImp.setServer("smtp.gmail.com");
			sendMailImp.setPort(465);
			break;
		case YAHOO:
			sendMailImp.setServer("smtp.mail.yahoo.com");
			sendMailImp.setPort(25);
			break;
		default: 
			break;
			
		}
		try
		{
			Socket socket=new Socket(sendMailImp.getServer(),sendMailImp.getPort());
			BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			sendMailImp.setSocket(socket);
			sendMailImp.setInput(input);
			sendMailImp.setOutput(output);
		
		}catch(UnknownHostException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return sendMailImp;
		
	}
	
	

}
