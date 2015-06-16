<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<title>fruit后台操作说明</title>
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
<li class="active"><a href="backstage.jsp?id=1"><i class="icon-flag"></i> 操作说明</a></li>
<li><a href="backstage.jsp?id=2"><i class="icon-ok"></i>登陆</a></li>
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


<div class="container" style="margin-top:45px;">
<h3>第一步</h3>
<p>请选<strong><em>择Firefox、Google、苹果</em></strong>等高版本浏览器效果更好。新用户请通过注册获取操作权限，获得用户名和密码。</p>
<h3>第二步</h3>
<p>单击菜单项中的<strong><em>"登陆"</em></strong>按钮，进入登陆页面，输入合法有效的用户名和密码，确认无误后单击<strong><em>"登陆"</em></strong>按钮，失败系统会给以提示信息。</p>
<h3>第三步</h3>
<p>进入fruit后台管理系统主页面，左栏为操作菜单，右栏为操作结果显示区，请谨慎操作，如有数据信息流失，后果自负。</p>
<h3>第四步</h3>
<p>离开系统时，请确认单击菜单项中的<strong><em>退出</em></strong>按钮，避免却他人的非法操作和密码安全。</p>
<h3>第五步</h3>
<p>祝你工作愉快，技术咨询地址：黑大信管基地。</p>
<div>版权：fruit公司 2014-2018</div>
</div>
</body>
</html>