<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户的个人中心展示留言信息页面</title>
</head>
<body>
	<a href="#">发布信息</a>
	<a href="#">退出系统</a> 
	留言信息:
	<s:property value="flag" />
	<table>
		<tr>
			<td>留言内容</td>
			<td>发布时间</td>
			<td>是否通过审核</td>
		</tr>

		<s:iterator value="myUserMessages" id="um">
			<tr>
				<%-- <s:property value="#um.userMessageId"/> --%>
				<td><s:property value="#um.userMessageContent" /></td>
				<td><s:property value="#um.userMessageDate" /></td>
				<td><s:property value="#um.isConfirm" /></td>
			<tr>
		</s:iterator>
	</table>
</body>
</html>