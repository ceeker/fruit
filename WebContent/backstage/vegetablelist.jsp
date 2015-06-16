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
<title>fruit蔬菜管理中心</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
	<div class="main">
		<label class="label">蔬菜简表</label>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>蔬菜ID</th>
					<th>名称</th>
					<th>单价</th>
					<th>库存</th>
					<th>折扣</th>
					<th>删除</th>
					<th>修改</th>
					<th>查看评论</th>
					

				</tr>
			</thead>
			<tbody>
			<s:iterator value="listVegetables" id="lv">
				<tr>
					<td><s:property value="#lv.vegetableID"/></td>
					<td><s:property value="#lv.vegetableName"/></td>
					<td><s:property value="#lv.vegetablePrice"/></td>
					<td><s:property value="#lv.vegetableQuantity"/></td>
					<td><s:property value="#lv.vegetableDiscount"/></td>
					<td> <a href="adminDeleteVegetableById?vegetableId=<s:property value="#lv.vegetableID"/>"> <i class="icon-trash"></i></a></td>
					<td><a href="findVegetableById?vegetableId=<s:property value="#lv.vegetableID"/>"><i class="icon-edit"></i></a></td>
					<td><a href="adminCommentsByVegetableId?vegetableId=<s:property value="#lv.vegetableID"/>"><i class="icon-eye-open"></i></a></td>
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
