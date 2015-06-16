<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>绿活果蔬-个人中心</title>
	<s:if test="#session.userId==null">
		<script>
			window.location.href="index.jsp";
		</script>
	</s:if>
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
	<link rel="stylesheet" href="css/personcenter.css">
	<script src="js/sea.js"></script>
	<script>
		$(function(){
			seajs.use('personcenter.js');
		})
	</script>
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
								<a href="#">个人中心<span>&nbsp;&nbsp;&nbsp;&nbsp;</span></a>
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
			<div class="p-center-nav">
				<h2>个人中心</h2>
				<ul>
					<li><a data-hash="myinfo" href="javascript:void(0)"><span>&#xe08a;</span>我的信息</a></li>
					<li><a data-hash="myorder" href="javascript:void(0)"><span>&#xe058;</span>我的订单</a></li>
					<li><a data-hash="mycomment" href="javascript:void(0)"><span>&#xe065;</span>我的评价</a></li>
					<li><a data-hash="mypass" href="javascript:void(0)"><span>&#xe06e;</span>修改密码</a></li>
				</ul>
			</div>
			<div class="p-center-item">
				<!-- myinfo start -->
				<div id="myinfo">
					<s:action name="findUserInfoById" id="findUserInfoById" >
						
					</s:action>
					<span class="jiantou"></span>
					<h2><span>&#xe08a;</span>我的信息</h2>
					<div class="item-content">
						<p class="info-saysomething">
							提示：亲爱的<em><s:property value="#findUserInfoById.user.userName"/></em>，请完善您的信息，最好填写真实信息哦！
						</p>
						<p>
							<em class="info-label">用户名:</em>
							<strong><s:property value="#findUserInfoById.user.userName"/></strong>
						</p>
						<p>
							<em class="info-label">密码:</em>
							<strong>●●●●●●●●●</strong>
							<a href="javascript:void(0)" data-hash="mypass" class="info-alter-pass">修改密码</a>
						</p>
						<p>
							<em class="info-label">email:</em>
							<strong id="now-user-email"><s:property value="#findUserInfoById.user.userMail"/></strong>
							<a href="javascript:void(0)" class="info-alter-email">修改邮箱地址</a>
						</p>
						<p>
							<em class="info-label">生日:</em>
							<strong><s:text name="global.birth"><s:param value="#findUserInfoById.user.userBirth"></s:param></s:text></strong>
						</p>
						<p>
							<em class="info-label">电话:</em>
							<strong id="now-user-tel"><s:property value="#findUserInfoById.user.userPhone"/></strong>
							<a href="javascript:void(0)" class="info-alter-tel">设置默认联系电话</a>
						</p>
						<p>
							<em class="info-label">地址:</em>
							<strong id="now-user-addr"><s:property value="#findUserInfoById.user.userAddr"/></strong>
							<a href="javascript:void(0)" class="info-alter-address">设置默认联系地址</a>
						</p>
					</div>
				</div>
				<!-- myinfo end -->
				<!-- myorder start -->
				<div id="myorder">
					<span class="jiantou"></span>
					<h2><span>&#xe058;</span>我的订单</h2>
					<!-- 没有查到相应商品 start -->
					 <div class="order-is-empty">
						<img src="img/logo.png" alt="logo"><em>对不起，您还没有订单！</em>
					</div>
					<!-- 没有查到相应商品 end -->
					<div class="item-content order-not-empty">
						<ul class="status">
							<strong>状态：</strong>
							<li class="selected"><a href="javascript:void(0)">全部</a></li>
							<li><a href="javascript:changeStatus(1)">未付款</a></li>
							<li><a href="javascript:changeStatus(2)">未确认</a></li>
							<li><a href="javascript:changeStatus(3)">未评价</a></li>
							<li><a href="javascript:changeStatus(4)">已完成</a></li>
						</ul>
						
						<table class="user-order" summary="用户订单">
							<thead>
							<tr>
								<th width="300">商品</th>
								<th width="70">数量</th>
								<th width="130">总价</th>
								<th width="100">状态</th>
								<th width="150">操作</th>
							</tr>
						</thead>
						<tbody id="order-tbody">
						</tbody>
						</table>
						<ol class="pagination">
						</ol>
					</div>
				</div>
				<!-- myorder end -->

				<div id="mycomment">
					<span class="jiantou"></span>
					<h2><span>&#xe065;</span>我的评价</h2>
					<!-- 没有查到相应商品 start -->
					 <div class="comment-is-empty">
						<img src="img/logo.png" alt="logo"><em>对不起，没有相关评价！</em>
					</div>
					<!-- 没有查到相应商品 end -->
					<div class="comment-not-empty">
						<div class="item-content">
							<ul class="comment-wrapper">
							</ul>
							<ol class="pagination">
							</ol>
						</div>
					</div>
				</div>

				<!-- mypass start -->
				<div id="mypass">
					<span class="jiantou"></span>
					<h2><span>&#xe06e;</span>修改密码</h2>
					<div class="item-content">
						<form id="alter-pass" action="" method="post">
							<input type="hidden" name="user.userId" value="<s:property value="#session.userId"/>"/>
							<ol class="alter-error"></ol>
							<div>
								<label for="alter-pre-pass">密&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;</label><input type="password" class="alter-pass-text" id="alter-pre-pass" name="prepass" title="请输入原始密码！"/>&nbsp;&nbsp;<span></span>
							</div>
							<div>
								<label for="alter-new-pass">新密码：&nbsp;&nbsp;</label><input type="password" class="alter-pass-text" id="alter-new-pass" name="user.userPassword" title="请输入新密码，字数不得少于6位！"/>&nbsp;&nbsp;<span></span>
							</div>
							<div>
								<label for="alter-pass-con">确&nbsp;&nbsp;&nbsp;认：&nbsp;&nbsp;</label><input type="password" class="alter-pass-text" id="alter-pass-con" name="pass-con" title="请确认您所填写的密码！"/>&nbsp;&nbsp;<span></span>
							</div>
							<div>
								<input id="alter-pass-submit" type="submit" value="确认修改"/>
							</div>
						</form>
					</div>
				</div>
				<!-- mypass end -->
			</div>
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
		<!-- 修改框 -->
		<form id="info-alter-box" method="post" action="">
			<label for="alter-input"></label>
			<input type="text" autocomplete="off" id="alter-input" name="">
			<p id="info-alter-error"></p>
		</form>
		<!-- 评论框 -->
			<form id="comment-box" method="post" action="">
				<div class="comment-product-info">
					<div class="comment-product-photo">
						<img src="img/products-co01.jpg" alt="某某商品">
					</div>
					<div class="comment-product-name">某某商品某某商品某某商品某某商品某某品
					</div>
				</div>
				<div class="comment-mark">
					<strong>总体评价:</strong>
					<ul>
						<li><span></span><span></span></li>
						<li><span></span><span></span></li>
						<li><span></span><span></span></li>
						<li><span></span><span></span></li>
						<li><span></span><span></span></li>
					</ul>
					<em class="comment-score">0.0分</em>
				</div>
				<input type="hidden" id="comment-vegID" name="bookId" value=""/>
				<input type="hidden" id="comment-score" name="comment.commentScore" value="0"/>

				<div class="comment-content-wrapper">
					<textarea name="comment.commentInfo" id="comment-content" placeholder="请输入你对此商品的评价！"></textarea>
				</div>
				<p class="comment-font-num">您最多可以输入<strong>400</strong>个字！</p>
				<p id="comment-box-error"></p>
			</form>


		<!-- 登陆框 -->
		<form action="#" id="dialog-login" method="post">
			<ol class="login-error">
				
			</ol>
			<div>
				<label for="dialog-login-user">账 号:&nbsp;&nbsp;</label><input name="dialog-login-user" type="text" id="dialog-login-user"/>
			</div>
			<div>
				<label for="dialog-login-pass">密 码:&nbsp;&nbsp;</label><input name="dialog-login-pass" id="dialog-login-pass" type="password"/>
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