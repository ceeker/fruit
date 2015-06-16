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
<title>已处理订单</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
<div class="main">
<label class="label">已处理订单</label>
<table class="table table-striped table-bordered table-condensed"> 
 <thead>
 <tr> <th>订单编号</th>
      <th>订单类别</th>     
       <th>订单客户</th> 
       <th>订单数量</th> 
       <th>订货日期</th>
       <th>送货电话</th>
       <th>送货地址</th>
      
  </tr> 
 </thead>
  <tbody>   
  <s:iterator value="listBooks" id="bl">
  <tr> 
       <td class="bookList-bookId"><s:property value="#bl.bookId"/></td>     
       <td><s:property value="#bl.bookVegetable.vegetableName"/></td> 
       <td><s:property value="#bl.bookUser.userId"/></td>
        <td><s:property value="#bl.bookQuantity"/></td>
       <td><s:text name="global.datetime"><s:param value="#bl.bookDate"/></s:text></td>
       <td><s:property value="#bl.bookPhone"/></td>
       <td><s:property value="#bl.bookAddr"/></td>
      
  </tr>  
 </s:iterator> 
  </tbody>
</table>
<div class="pagination">  <ul>   <li><a href="#">前一页</a></li>    <li class="active">      <a href="#">1</a>    </li>    <li><a href="#">2</a></li>    <li><a href="#">3</a></li>    <li><a href="#">4</a></li>    <li><a href="#">后一页</a></li>  </ul></div


></div>

</body>
</html>
