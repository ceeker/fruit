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
<title>用户留言管理</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>

<label class="label">留言信息列表</label>
<table class="table table-striped table-bordered table-condensed"> 
 <thead>
 <tr> <th>留言编号</th>     
       <th>留言标题</th> 
       <th>留言人</th> 
       <th>留言时间</th>
       <th>删除</th>
       <th>审核状态</th> 
       <th>详情</th> 
  </tr> 
 </thead>
  <tbody>   
  <s:iterator value="userMessageList" id="uml">
  <tr> 
       <td><s:property value="#uml.userMessageId"/></td>     
       <td><s:property value="#uml.userMessageTitle"/></td> 
       <td><s:property value="#uml.userMessageAuthor.userId"/></td> 
       <td><s:text name="global.datetime"><s:param value="#uml.userMessageDate"/></s:text></td> 
       <td><a href="deleteUserMessageById?userMessageId=<s:property value="#uml.userMessageId"/>"><i class="icon-trash"></i></a></td> 
       <td>
       <s:if test="#uml.isConfirm==0">未通过</s:if>
       <s:elseif test="#uml.isConfirm==1">
                              已通过
       </s:elseif>
       </td>
       <td><a href="findUserMessageById?userMessageId=<s:property value="#uml.userMessageId"/>"><i class="icon-edit"></i></a></td> 
  </tr>  
 </s:iterator> 
  </tbody>
</table>
<div class="pagination">  <ul>    <li><a href="#">前一页</a></li>    <li class="active">      <a href="#">1</a>    </li>    <li><a href="#">2</a></li>    <li><a href="#">3</a></li>    <li><a href="#">4</a></li>    <li><a href="#">后一页</a></li>  </ul></div


>
</body>
</html>
