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
<title>fruit管理中心</title>

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

	<div class="container" style="margin-top:50px;">

		<div id="control_bar">
			<br />
			<!--下拉菜单-->
			<!-- 折叠菜单 -->
			<div id="accordion">
				<h3>管理员信息管理模块</h3>
				<div>
					<ul>
						<li><a href="findAllAdminsAction" target="view_show">
								管理员列表</a></li>
						<li><a href="<%=basePath%>backstage/alterpassword.jsp"
							target="view_show">修改密码</a></li>
					</ul>
				</div>
				<h3>广告管理大厅</h3>
				<div>
					<ul>
						<li><a href="getAllAd" target="view_show">查看所有广告</a></li>
					</ul>
				</div>

				<h3>蔬菜管理大厅</h3>
				<div>
					<ul>
						<li><a href="adminVegetableProvider" target="view_show">所有蔬菜</a></li>
						<li><a href="<%=basePath%>backstage/vegetableAdd.jsp" target="view_show">添加蔬菜</a></li>
					</ul>
				</div>
				<h3>用户管理中心</h3>
				<div>
					<ul>
						<li><a href="findAllUsers" target="view_show">查询所有顾客</a></li>
					</ul>
				</div>

				<h3>订单信息库</h3>
				<div>
					<ul>
						<li><a href="findUnDealBook" target="view_show">待处理订单</a></li>
						<li><a href="findAllBooks" target="view_show">已处理订单</a></li>
						
					</ul>
				</div>
				<h3>信息交互</h3>
				<div>
					<ul>
						<li><a href="queryAllMessage" target="view_show">公告中心</a></li>
						<li><a href="findAllUserMessage" target="view_show">留言中心</a></li>

					</ul>
				</div>
				<h3>网站设置</h3>
				<div>
					<ul>
						<li><a href="adminAllGalleryPics" target="view_show">滚动栏设置</a></li>
					</ul>
				</div>
			</div>

		</div>


		<div id="view_block">
			<div class="alert-block" style="border-bottom: 1px #CCCCCC solid">
				<i class="icon-th-list"></i><strong>提示栏</strong>&nbsp;&nbsp;&nbsp;待处理订单<span
					class="badge badge-warning">4</span>&nbsp;&nbsp;顾客总数<span
					class="badge badge-success">2</span>&nbsp;&nbsp;访问量<span
					class="badge badge-info">8</span>&nbsp;&nbsp;&nbsp;&nbsp;<span
					class="label label-important">more>></span>
			</div>
			
			<iframe name="view_show" src="<%=basePath%>backstage/img/notfound.png"/> </iframe>





		</div>

	</div>
	<!-- all-content end -->
	<script>
		$('#accordion').accordion();
	</script>
</body>
</html>
