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
<title>fruit用户管理</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
	<div class="main">
		<label class="label">用户列表</label>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>密码</th>
					<th>电话</th>
					<th>生日</th>
					<th>Email</th>
					<th>地址</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="listAllUsers" id="lau">
				<tr>
					<td><s:property value="#lau.userId"/></td>
					<td><s:property value="#lau.userName"/></td>
					<td><s:property value="#lau.userSex"/></td>
					<td><s:property value="#lau.userPassword"/></td>
					<td><s:property value="#lau.userPhone"/></td>
					<td><s:if test="#lau.userBirth==null">用户未填写</s:if>
					<s:elseif test="#lau.userBirth!=null"><s:text name="global.time"><s:param value="#lau.userBirth"></s:param></s:text></s:elseif></td>
					<td><s:property value="#lau.userMail"/></td>
					<td><s:property value="#lau.userAddr"/></td>
					<td> <a href="deleteUserById?userId=<s:property value="#lau.userId"/>"> <i class="icon-trash"></i></a></td>
				</tr>
			</s:iterator>
			</tbody>
		</table>

		<div class="pagination">
			<ul>
				<li><a href="#">前一页</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">后一页</a></li>
			</ul>
		</div>

	</div>
</body>
</html>
