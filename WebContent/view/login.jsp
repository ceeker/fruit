<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
<s:property value="flag"/>
<s:form action="adminLoginAction">
	<s:textfield name="admin.adminId" key="name"></s:textfield>
	<s:password name="admin.adminPassword" key="password"></s:password>
	<s:submit key="submit"></s:submit>
	<s:reset key="reset"></s:reset>
</s:form>
</body>
</html>