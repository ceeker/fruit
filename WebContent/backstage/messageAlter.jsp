<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>修改公告</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="main">
		<table class="table table-bordered">
			<caption>
				<strong>修改公告信息</strong>
			</caption>
			<tr>
				<td>
				<form action="updateMessageById" method="post" class="form-horizontal">
						
				标题： <input type="text" name="message.messageTitle" class="input-large"
							value="<s:property value="message.messageTitle"/>" />
						 <br/><br/>
				内容：
						<textarea name="message.messageContent" class="textarea" rows="6">
						<s:property value="message.messageContent" />
						</textarea>
				<br/><br/>
				<input type="submit" value="提交" class="btn-primary">&nbsp;&nbsp;
				<input type="reset" value="重置" class="btn-primary">
			 </form>
			 </td>
			</tr>
		</table>

	</div>


</body>
</html>