<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:iterator value="pageBean.list" var="user">
<s:property value="user.userName"/>




</s:iterator>
共<s:property value="pageBean.allRow"/>条记录
共<s:property value="pageBean.totalPage"/>页
共<s:property value="pageBean.currentPage"/>页<br/>
<s:if test="%{pageBean.currentPage==1}">
第一页 上一页

</s:if>
<s:else>
	<a href="pageAction?page=1">第一页</a>
	<a href="pageAction?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>


</s:else>
<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
<a href="pageAction?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
<a href="pageAction?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
</s:if>
<s:else>
下一页 最后一页
</s:else>

</body>
</html>