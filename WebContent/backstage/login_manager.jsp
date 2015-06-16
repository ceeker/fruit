<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<title>fruit后台登陆</title>
</head>

<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/web.css">
<link rel="stylesheet" href="./css/jquery-ui-1.10.4.custom.css">
<script src="./js/jquery-1.11.0.js"></script>
<script src="./js/jquery-ui-1.10.4.custom.js"></script>
<script src="./js/bootstrap.js"></script>
<script >
function custom_close(){
if 
(confirm("您确定要关闭本页吗？")){
window.opener=null;
window.open('','_self');
window.close();
}
else{}
}
</script>
</head>

<body>
<div class="navbar navbar-fixed-top">
<div class="navbar-inner">
<div class="container">
<a class="brand" href="javascript:void(0);"><img src="img/logo.png">fruit管理系统</a>
<div class="nav-collapse">
<ul class="nav">
<li ><a href="backstage.jsp"><i class="icon-black icon-home"></i>首页</a></li>
<li><a href="backstage.jsp?id=1"><i class="icon-flag"></i> 操作说明</a></li>
<li class="active"><a href="backstage.jsp?id=2"><i class="icon-ok"></i>登陆</a></li>
<li><a href="#" onClick="custom_close()"><i class="icon-off"></i>退出</a></li>
<li><a href="javascript:alert('由于权限问题，你不能完成该操作');"><i class="icon-cog"></i>皮肤</a></li>
</ul>

<form class="navbar-search pull-left" action="">
            <input type="text" class="search-query span2" placeholder="Search">
          </form>
          <ul class="nav pull-right">
            <li><a href="fruit_page/index.jsp"  target="_blank">绿活购物</a></li>
            <li class="divider-vertical"></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">友情链接<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="http://www.taobao.com/">淘宝购物</a></li>
                <li><a href="http://www.baidu.com/">百度搜索</a></li>
                <li><a href="http://www.sina.com.cn/">新浪首页</a></li>
                <li class="divider"></li>
                <li><a href="http://www.chineseteacher.ru/shasha/index.html">莎莎语言培训</a></li>
                <li><a href="http://nihaoma.herokuapp.com/">blog系统</a></li>
              </ul>
            </li>
          </ul>
</div>

</div>
</div>
</div>


<div class="container" style="margin-top:80px;">
<p align="center" style="font-size:14px;color:grey;font-weight:700;">欢迎你登陆后台管理系统。祝你工作愉快！</p>
<br/>
<div align="center" style="margin:0 auto;width:500px">
<form role="form"  method="post" action="adminLoginAction">
  <div class="form-group">
    <label>用户名：
    <input type="text" class="form-control" name="admin.adminId" id="adminName" placeholder="username"></label><br/>
  </div>
  <div class="form-group">
    <label>密&nbsp;&nbsp;码：
    <input type="password" class="form-control" name="admin.adminPassword" id="passowrd" placeholder="Password"></label>
  </div>
  
  <button type="submit" class="btn btn-lg btn-primary">登陆</button>&nbsp;&nbsp;<button type="reset" class="btn btn-default">重置</button>
</form>
</div>


</div>
</body>
</html>