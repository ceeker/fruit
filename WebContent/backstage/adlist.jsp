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
<title>fruit广告管理中心</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
<div class="main">
<label class="label">广告信息列表</label>
<table class="table table-striped table-bordered table-condensed"> 
 <thead>
 <tr> <th>广告编号</th>     
       <th>广告标题</th> 
       <th>广告信息</th> 
       <th>广告链接</th> 
       <th>修改</th> 
  </tr> 
 </thead>
  <tbody>   
  <s:iterator value="adList" id="adl">
  <tr> 
       <td><s:property value="#adl.advertisementId"/></td>     
       <td><s:property value="#adl.advertisementTitle"/></td> 
       <td><s:property value="#adl.advertisementInfo"/></td> 
       <td><s:property value="#adl.advertisementHref"/></td> 
       <td><a href="admingetAdById?advertisementId=<s:property value="#adl.advertisementId"/>"><i class="icon-edit"></i></a></td> 
  </tr>  
 </s:iterator> 
  </tbody>
</table>
<div class="pagination">  <ul>    <li><a href="#">前一页</a></li>    <li class="active">      <a href="#">1</a>    </li>    <li><a href="#">2</a></li>    <li><a href="#">3</a></li>    <li><a href="#">4</a></li>    <li><a href="#">后一页</a></li>  </ul></div


></div>
</body>
</html>
