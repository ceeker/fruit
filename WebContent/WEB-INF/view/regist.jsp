<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %> 
      <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
      <sx:head/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:fielderror></s:fielderror>
<s:form action="userRegistAction" theme="xhtml" validate="true">
	<s:textfield name="user.userId" key="userId"></s:textfield>
	<s:textfield name="user.userPassword" key="userPassword"></s:textfield>
	
	
	
</s:form>

</body>
</html>