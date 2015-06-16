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
<title>fruit公告管理中心</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
	<div class="main">
		<label class="label">管理员列表</label>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>管理员ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>出生日期</th>

				</tr>
			</thead>
			<tbody>
			<s:iterator value="listAdmins" id="la">
				<tr>
					<td><s:property value="#la.adminId"/></td>
					<td><s:property value="#la.adminName"/></td>
					<td><s:property value="#la.adminSex"/></td>
					<td>
					<s:if test="#la.adminBirth==null">未填写</s:if>
					<s:elseif test="#la.adminBirth!=null"><s:text name="global.time"><s:param value="#la.adminBirth"></s:param></s:text></s:elseif>
					</td>
				</tr>
			</s:iterator>	
			</tbody>
		</table>



	</div>
</body>
</html>
