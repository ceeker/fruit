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
<label class="label">公告信息列表</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-mini" href="<%=basePath %>/backstage/messageAdd.jsp" target="view_show"><font color="#0066FF"><strong>发布公告</strong></font></a>
<table class="table table-striped table-bordered table-condensed"> 
 <thead>
 <tr> <th>公告编号</th>     
       <th>公告标题</th> 
       <th>发布人ID</th> 
       <th>发布时间</th>
       <th>删除</th> 
       <th>修改</th> 
  </tr> 
 </thead>
  <tbody>   
  <s:iterator value="messageList" id="ml">
  <tr> 
       <td><s:property value="#ml.messageId"/></td>     
       <td><s:property value="#ml.messageTitle"/></td> 
       <td><s:property value="#ml.messageAdmin.adminId"/></td> 
       <td><s:text name="global.datetime"><s:param value="#ml.messageDate"/></s:text></td> 
       <td><a href="deleteMessageById?messageId=<s:property value="#ml.messageId"/>"><i class="icon-trash"></i></a></td> 
       <td><a href="findMessageById?messageId=<s:property value="#ml.messageId"/>"><i class="icon-edit"></i></a></td> 
  </tr>  
 </s:iterator> 
  </tbody>
</table>
<div class="pagination">  <ul>    <li><a href="#">前一页</a></li>    <li class="active">      <a href="#">1</a>    </li>    <li><a href="#">2</a></li>    <li><a href="#">3</a></li>    <li><a href="#">4</a></li>    <li><a href="#">后一页</a></li>  </ul></div


></div>
</body>
</html>
