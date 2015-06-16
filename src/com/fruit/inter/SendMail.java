package com.fruit.inter;

import java.io.IOException;

public interface SendMail
{
	/**
	 * 向服务器发送命令
	 * @param order
	 * 			向服务器发送的命令行
	 * @return 返回服务器状态
	 */
	
	public int sendToServer(String order);
	
	/**
	 * 解析服务器返回的应答信息
	 * @return 返回服务器状态
	 */
	public int getResult();
	
	/**
	 * 向服务器发起会话
	 * @throws IOException
	 */
	public void regist()throws IOException;
	
	/**
	 * 登录到服务器
	 * @throws IOException
	 */
	public void login() throws IOException;
	
	/**
	 * s设置邮件源地址
	 * @throws IOException
	 */
	public void setMailFrom() throws IOException;
	
	
	
	/**
	 * 设置邮件发送地址
	 * @throws IOException
	 */
	public void setMailTo() throws IOException;
	
	
	/**
	 * 设置邮件内容
	 * @throws IOException
	 */
	public void setData() throws IOException;
	/**
	 * 退出服务器
	 */
	public void quit() throws IOException;
	
	
	/**
	 * 发送邮件主程序
	 * @return 是否成功
	 * @throws IOException
	 */
	public boolean sendMail() throws IOException;
}	
	
	
	

