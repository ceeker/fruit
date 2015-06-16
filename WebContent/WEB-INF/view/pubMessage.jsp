<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布信息页面</title>
</head>
<body>
<form action="InsertUserMessageAction" method="post">
<table>
<caption>发布信息</caption>
<tr>
<td><s:textfield name="userMessage.userMessageTitle" key="标题"/></td>
</tr>
<tr>
<td>
<textarea name="content" rows="8" cols="20">编辑留言内容</textarea>
</td>
</tr>
<tr><td><input type="submit" value="提交"></td><td><input type="reset" value="重置"></td></tr>
</table>
</form>
</body>
</html>