<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示所有用户留言</title>
</head>
<body>
	<s:property value="flag" />
	<table>
		<tr>
			<td>用户留言内容</td>
			<td>作者</td>
			<td>发布时间</td>
		</tr>

		<s:iterator value="allUserMessages" id="um">
			<tr>
				<%-- <s:property value="#um.userMessageId"/> --%>
				<td><s:property value="#um.userMessageContent" /></td>
				<td><s:property value="#um.userMessageAuthor.userId" /></td>
				<td><s:property value="#um.userMessageDate" /></td>
			<tr>
		</s:iterator>
	</table>
</body>
</html>