<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
</head>
<body>
	<s:property value="flag" />
	<s:form method="post" action="userLoginAction">
		<s:textfield name="user.userId" key="name" />
		<s:textfield name="user.userPassword" key="password" />
		<s:submit key="submit" />
		<s:reset key="reset" />
	</s:form>

</body>
</html>