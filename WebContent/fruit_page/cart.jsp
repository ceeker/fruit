<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>绿活果蔬-购物车</title>
	<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" href="css/base.css">
	<script src="js/modernizr.js"></script>
	<script src="js/jquery-1.11.0.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/common.js"></script>
	<!-- 本页面加载文件 -->
	<link rel="stylesheet" href="css/cart.css">
	<script src="js/cart.js"></script>
</head>
<body>
<%
	Object userId=request.getSession().getAttribute("userId");
	
	
%>
		<!-- progress start -->
	<div id="progress">
		<div id="progress-num">0% Loaded</div>
		<div class="progress-bar">
			<div class="progress-now"></div>
		</div>
	</div>
	<!-- progress end -->
	<!-- all-content start -->
	<div id="all-content">
		<!-- header start -->
		<div id="header">
			<div class="wrapper1">
				<h1 class="logo" title="绿活果蔬-首页"><a href="index.jsp"><img src="img/logo.png" alt="绿活果蔬-首页"></a></h1>
				<div class="user-things">
					<div class="wrapper2">
						<div class="member">
						<s:if test="#session.userId!=null">
						Hi,<%=userId.toString() %>&nbsp;|&nbsp;<a href="userLogout.action">[注销]</a>
						</s:if>
						<s:else>
						<a href="javascript:void(0)" class="member-login">[登录]</a>&nbsp;|&nbsp;<a href="register.jsp" class="member-register">[注册]</a>
						</s:else>&nbsp;|&nbsp;<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;000-000-0000</span>
						</div>
						<div class="center-item">
							<div class="buy-car">
								<a href="#"><strong><s:action name="userCountCart" id="userCountCart"></s:action><s:property value="#userCountCart.countCart"/></strong>&nbsp;购物车<span>&nbsp;&nbsp;&nbsp;&nbsp;</span></a>
								
								<div class="drop buy-car-tip">
									<s:if test="%{#userCountCart.countCart>0}">您的购物车里有<strong><s:property value="#userCountCart.countCart"/></strong>件商品，<a href="findAllCart.action">去看看</a>！</s:if>
									<s:else>购物车中还没有商品，赶紧选购吧！</s:else>
								</div>
							</div>
							<div class="my-center">
								<a href="personcenter.jsp">个人中心<span>&nbsp;&nbsp;&nbsp;&nbsp;</span></a>
								<div class="drop my-center-tip">
								 <s:if test="#session.userId!=null">
									<ul class="my-center-signed">
										<li><a href="personcenter.jsp#myinfo" title="个人信息"><span>&#xe08a;</span>个人信息</a></li>
										<li><a href="personcenter.jsp#myorder" title="我的订单"><span>&#xe058;</span>我的订单</a></li>
										<li><a href="personcenter.jsp#mycomment" title="我的评价"><span>&#xe065;</span>我的评价</a></li>
										<li><a href="personcenter.jsp#mypass" title="修改密码"><span>&#xe06e;</span>修改密码</a></li>
									</ul>
									</s:if>
								 <s:else>
									你好，请<strong class="member-login">登录</strong>！
								
								</s:else> 
								
								</div>
							</div>
						</div>
					</div>
					<form name="search" action="findVegetableByKeyWord?order=default&sort=desc&from=0" method="get">
						<div class="search">
							<input type="text" name="keyWord" class="search-content" placeholder="蔬菜，水果....">
							<input name="search-submi" class="search-submit" type="submit" value="搜索">
						</div>	
						<div class="search-tip">
							<span>热点搜索:</span>
							<s:action name="findHotKeyWords" id="findHotKeyWords"></s:action>
							
							<s:iterator value="#findHotKeyWords.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
							<!-- <a href="#">火龙果</a>
							<a href="#">荔枝</a>
							<a href="#">杨桃</a>
							<a href="#">娃娃菜</a>
							<a href="#">西柚</a> -->
						</div>
					</form>
				</div>
			</div>
			<div class="clear-both"></div>
			<div class="nav">
					<ul class="wrapper1">
						<li><a href="index.jsp">首页</a></li>
						
						<li><a href="findFreshVegetables?order=default&sort=desc&from=0">新鲜水果</a></li>
						<li><a href="findDiscountVegetables?order=default&sort=desc&from=0">优惠专区</a></li>
						<li><a href="userMessagePage?hql=from UserMessage as um order by um.userMessageDate desc">用户留言</a></li>
						<li><a href="adminMessagePage">绿活公告</a></li>
						<li><a href="aboutus.jsp">关于我们</a></li>
					</ul>
				</div>
		</div>
		<!-- header end -->
		<!-- content start -->
		<div id="content" class="wrapper1">
			<h2>
				<img src="img/cartlogo.png" alt="我的购物车" class="logo"><span class="time-now"></span>
			</h2>
	<!-- 空购物车的情况 start -->
			<div class="empty-cart" style="display:none">
				<div class="empty-cart-box">
					<div class="empty-cart-logo"><img src="img/emptycart.png" alt="空的购物车"></div>
					<div class="empty-cart-go">
						<p><strong>您的购物车还是空的，赶快去挑选商品吧！</strong></p>
						<p>点击<a href="">继续购物</a>!</p>
					</div>
				</div>
			</div>
	<!-- 空购物车的情况 end -->
			<!-- 购物车有商品情况 start -->
			<div class="not-empty">
				<form action="" id="mycart" name="mycart" method="get">
					<table class="cart-list" summary="购物车清单">
						<thead>
							<tr>
								<th width="100"><input class="checked-all" name="all" type="checkbox"/>&nbsp;全选</th>
								<th width="350">商品</th>
								<th width="120">原价/折扣</th>
								<th width="120">现价</th>
								<th width="120">数量</th>
								<th width="120">小计</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<s:if test="flag=='ok'">
						<s:iterator value="listCart" id="cart">
							
						<s:property value="#cart.cartVegetable.vegetableId"/>
							<tr>
								<input type="hidden" name="cartId" value="<s:property value="#cart.cartId"/>">
								<td class="cart-list-check">
									<input name="checks" type="checkbox"/>
								</td>
								<td class="cart-list-product">
									<a href="产品地址" class="photo"><img src="<s:property value="#cart.cartVegetable.vegetablePicAddr.get(2)"/>" alt="<s:property value="#cart.cartVegetable.vegetableName"/>"></a>
									<a href="产品地址" class="name"><s:property value="#cart.cartVegetable.vegetableName"/></a>
								</td>
								<td class="cart-list-prv">
									<p class="prv">￥<s:property value="#cart.cartVegetable.vegetablePrice"/></p>
									<p class="discount"><s:property value="#cart.cartVegetable.vegetableDiscount"/>折</p>
								</td>
								<td class="cart-list-now">
									<strong>￥<s:text name="global.format.number"> <s:param value="#cart.cartVegetable.vegetableDiscount*#cart.cartVegetable.vegetablePrice/10"></s:param></s:text></strong>
								</td>
								<td class="cart-list-num">
									<input name="cartListNum" type="text" value="<s:property value="#cart.vegetableMount"/>" min="1" max="100" />
								</td>
								<td class="cart-list-total">
									<strong></strong>
								</td>
								<td class="cart-list-operate">
									<input type="button" value="删 除">
								</td>
							</tr>
							</s:iterator>
							</s:if>
							<s:else>
							</s:else>
						</tbody>
					</table>
					<div class="cart-submit">
						<input id="cart-submit" type="button">
						<p class="cart-submit-total">共有 <em>2</em> 件商品，共计：<strong></strong></p>
					</div>
				</form>
			</div>
			<!-- 购物车有商品情况 end -->
		</div>
		<!-- content end -->
		<!-- footer start -->
		<div id="footer">
			<p>
				绿活果蔬&nbsp;|&nbsp; <a href="#">关于我们</a> &nbsp;|&nbsp; <a href="#">合作伙伴</a> &nbsp;|&nbsp; <a href="#">团队介绍</a> &nbsp;|&nbsp; <a href="#">友情链接</a> &nbsp;|&nbsp; Copyright @lvhuowang.com.All Rights Reserved &nbsp; 京ICP证 080047号 &nbsp;|&nbsp; 黑公网安备9999999999号
			</p>
		</div>
		<!-- footer end -->
		<div id="back-to-top" title="返回顶部">返回顶部</div>
		<!-- dialog start -->
		<!-- 登陆框 -->
		<form action="#" id="dialog-login" method="post">
			<ol class="login-error">
				
			</ol>
			<div>
				<label for="dialog-login-user">账 号:&nbsp;&nbsp;</label><input name="user.userId" type="text" id="dialog-login-user"/>
			</div>
			<div>
				<label for="dialog-login-pass">密 码:&nbsp;&nbsp;</label><input name="user.userPassword" id="dialog-login-pass" type="password"/>
			</div>
			<div class="dialog-login-operation">
				<a href="register.jsp" title="注册">注册</a> | <a href="getpass.jsp" target="_blank" title="找回密码">忘记密码</a>
			</div>
		</form>
		<div class="loading"></div>
		<!-- dialog end -->
		<div class="screen" id="screen1"></div>
		<div class="screen" id="screen2"></div>
	</div>
	<!-- all-content end -->
	
</body>
</html>