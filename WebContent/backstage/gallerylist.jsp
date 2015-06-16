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
<title>滚动栏图片管理中心</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
<div class="main">
<label class="label">滚动栏图片信息列表</label>
<table class="table table-striped table-bordered table-condensed"> 
 <thead>
 <tr> <th>图片编号</th>     
       <th>图片标题</th> 
       <th>图片信息</th> 
       <th>图片链接</th> 
       <th>修改</th> 
  </tr> 
 </thead>
  <tbody>   
  <s:iterator value="listGalleryPics" id="lgp">
  <tr> 
       <td><s:property value="#lgp.galleryPicId"/></td>     
       <td><s:property value="#lgp.galleryPicTitle"/></td> 
       <td><s:property value="#lgp.galleryPicInfo"/></td> 
       <td><s:property value="#lgp.galleryPicHref"/></td> 
       <td><a href="findGalleryPicById?galleryPicId=<s:property value="#lgp.galleryPicId"/>"><i class="icon-edit"></i></a></td> 
  </tr>  
 </s:iterator> 
  </tbody>
</table>
<div class="pagination">  <ul>    <li><a href="#">前一页</a></li>    <li class="active">      <a href="#">1</a>    </li>    <li><a href="#">2</a></li>    <li><a href="#">3</a></li>    <li><a href="#">4</a></li>    <li><a href="#">后一页</a></li>  </ul></div


></div>
</body>
</html>
