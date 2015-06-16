<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<title>管理员修改密码</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/web.css">
<link rel="stylesheet" href="./css/jquery-ui-1.10.4.custom.css">
<script src="./js/jquery-1.11.0.js"></script>
<script src="./js/jquery-ui-1.10.4.custom.js"></script>
<script src="./js/bootstrap.js"></script>

</head>

<body>
<div>
<form class="form" method="post" action="updateAdminInfoAction"> 
 <fieldset><legend>修改密码</legend>
 <table align="center">
 <thead><tr><td>原始密码：</td><td><input type="password" class="input-xlarge" value="${admin.adminPassword}"></td></tr>
 </thead>
 <tr><td>新密码：</td><td><input type="password" name="adminPassword" class="input-xlarge"></td></tr>
 <tr><td >确认密码：</td><td><input type="password" name="reAdminpassword" class="input-xlarge"></td></tr>
 <tr>
     <td colspan="2"><br/> &nbsp;
        &nbsp;
         &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  <input type="submit" class="btn btn-primary" value="提交">
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
         <input type="reset" class="btn" value="取&nbsp;&nbsp;消"></td></tr>
 
 </table>
    </fieldset>
  
    </form>
      
</div>
</body>
</html>
