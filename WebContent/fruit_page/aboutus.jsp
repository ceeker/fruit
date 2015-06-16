<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>绿活果蔬-关于我们</title>
	<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/aboutus.css">
	<script src="js/modernizr.js"></script>
	<script src="js/jquery-1.11.0.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/common.js"></script>
	<!-- 本页面加载文件 -->
	<link rel="stylesheet" href="css/personcenter.css">
	
</head>
<body>
<%
	Object userId=request.getSession().getAttribute("userId");
	
	
%>
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
						<li class="nav-selected"><a href="aboutus.jsp">关于我们</a></li>
					</ul>
				</div>
		</div>
		<!-- header end -->
		<!-- content start -->
		<div id="content" class="wrapper1">
       
		<div class="p-center-nav">
				<h2>关于我们</h2>
				<ul>
					<li><a  href="#intro"><span>&nbsp;</span>公司简介</a></li>
					<li><a href="#cultr"><span>&nbsp;</span>公司文化</a></li>
					<li><a href="#serv"><span>&nbsp;</span>服务宗旨</a></li>
					<li><a  href="#contr"><span>&nbsp;</span>联系地址</a></li>
				</ul>
			</div>
			<div class="p-center-item">
                <div id="myinfo" style="display: block;opacity: 1;filter:alpha(opacity=100);position: static;">
					
                    <span   class="jiantou"></span>
					<h2 name="intro" id="intro"><span>&#xe056;</span>公司简介</h2>	
              <div class="aboutus_content">
              
              新饶网站筹划股份无限公司成立于2007年，注册资金80湖南长沙一家专业的网站筹划公司。公司次要效劳于中小企业，提供网站筹划，网站设计制造建立，网络推行营销于一体的专业效劳。司以“专注网站，用心效劳”为中心价值，
希望经过我们的专业程和不懈努力，重塑中小企业网络抽象，为企业产品推行，文明建立传达提供效劳指点。
</div>
  <div class="aboutus_content">
三年来，新饶网站筹划不断秉承以用户需求为中心，在专注长沙本地市场开辟的同时，
为超越一百家中小企业提供网站筹划效劳，优质、用心的效劳博得了众多企业的信任和好评，在长沙地域逐步树立 
       </div>
                    
           
            <span  class="jiantou"></span>
					<h2 name="cultr" id="cultr"><span>&#xe086;</span>公司文化</h2>	
              <div class="aboutus_content">
              
              新饶网站筹划股份无限公司成立于2007年，注册资金80湖南长沙一家专业的网站筹划公司。公司次要效劳于中小企业，提供网站筹划，网站设计制造建立，网络推行营销于一体的专业效劳。司以“专注网站，用心效劳”为中心价值，
希望经过我们的专业程和不懈努力，重塑中小企业网络抽象，为企业产品推行，文明建立传达提供效劳指点。
</div>
  <div class="aboutus_content">
三年来，新饶网站筹划不断秉承以用户需求为中心，在专注长沙本地市场开辟的同时，
为超越一百家中小企业提供网站筹划效劳，优质、用心的效劳博得了众多企业的信任和好评，在长沙地域逐步树立 
       </div>
                
                
                
                
                 <span name="serv" class="jiantou"></span>
					<h2  name="serv" id="serv" ><span>&#xe078;</span>服务宗旨</h2>	
              <div class="aboutus_content">
              
              新饶网站筹划股份无限公司成立于2007年，注册资金80湖南长沙一家专业的网站筹划公司。公司次要效劳于中小企业，提供网站筹划，网站设计制造建立，网络推行营销于一体的专业效劳。司以“专注网站，用心效劳”为中心价值，
希望经过我们的专业程和不懈努力，重塑中小企业网络抽象，为企业产品推行，文明建立传达提供效劳指点。
</div>
  <div class="aboutus_content">
三年来，新饶网站筹划不断秉承以用户需求为中心，在专注长沙本地市场开辟的同时，
为超越一百家中小企业提供网站筹划效劳，优质、用心的效劳博得了众多企业的信任和好评，在长沙地域逐步树立 
       </div>
                    
                    
                    
                     <span  class="jiantou"></span>
					<h2 name="contr" id="contr"><span>&#xe081;</span>联系地址</h2>	
              <div class="aboutus_content">
              
              公司名称：fruit有限责任公司<br/>
              &nbsp;&nbsp;&nbsp;&nbsp;公司地址：安徽省**市**县**街**号<br/>
              &nbsp;&nbsp;&nbsp;&nbsp;联系电话：0000-00000000000
              </div>
 
                    
                    
                    
                                 
				</div>
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
</body>
</html>