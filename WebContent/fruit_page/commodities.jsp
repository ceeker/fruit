<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>  
   
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>具体产品名</title>
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
	<link rel="stylesheet" href="css/commodities.css">
	<script src="js/commodities.js"></script>
</head>
<%
	Object userId=request.getSession().getAttribute("userId");
	
	
%>
<s:if test="#session.userId==null">
<body>

</s:if>
<s:else>
<body data-user="<%=userId.toString() %>"></body>

</s:else>


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
	<s:action name="findVegetablesByCat" id="listOfCat">
		<s:param value="vegetable.vegetableCatagory" name="vegetableCatagory"></s:param>
	
	</s:action>
	<div id="content" class="wrapper1">
		<!-- 上部分 start -->
		<div class="product-info-top">
			<!-- 同类商品 start -->
			<div class="same-product-aside">
				<h3><span></span><em>&nbsp;&nbsp;&nbsp;&nbsp;同类商品&nbsp;&nbsp;&nbsp;&nbsp;</em></h3>
				<!-- 只有三个 -->
				<s:iterator value="#listOfCat.listOfCat" id="listOfCat">
				<a class="same-product-one">
					<div class="same-product-name">
						<s:property value="#listOfCat.vegetableName"/>
					</div>
					<div class="same-product-price">￥<s:text name="global.format.number"> <s:param value="#listOfCat.vegetablePrice*#listOfCat.vegetableDiscount/10"></s:param></s:text></div>
					<div class="same-product-discuont"><s:property value="#listOfCat.vegetableDiscount"/>折</div>
					<div class="same-product-hassaled">
						销量：<strong><s:property value="#listOfCat.vegetableSaleCount"/></strong>
					</div>
				</a>
				</s:iterator>
				<%-- <a class="same-product-one">
					<div class="same-product-name">
						<s:property value="#listOfCat.listOfCat.get(1).vegetableName"/>
					</div>
					<div class="same-product-price">￥<s:property value="#listOfCat.listOfCat.get(1).vegetablePrice"/></div>
					<div class="same-product-discuont"><s:property value="#listOfCat.listOfCat.get(1).vegetableDiscount"/>折</div>
					<div class="same-product-hassaled">
						销量：<strong><s:property value="#listOfCat.listOfCat.get(1).vegetableSaleCount"/></strong>
					</div>
				</a>	
				<a class="same-product-one">
					<div class="same-product-name">
						<s:property value="#listOfCat.listOfCat.get(2).vegetableName"/>
					</div>
					<div class="same-product-price">￥<s:property value="#listOfCat.listOfCat.get(2).vegetablePrice"/></div>
					<div class="same-product-discuont"><s:property value="#listOfCat.listOfCat.get(2).vegetableDiscount"/>折</div>
					<div class="same-product-hassaled">
						销量：<strong><s:property value="#listOfCat.listOfCat.get(2).vegetableSaleCount"/></strong>
					</div>
				</a> --%>
			</div>
			<!-- 同类商品 end -->
			<!-- 简介 start -->
			<div class="product-info">
				<!-- 照片 start -->
				<div class="product-info-photos">
					<div id="slider-show">
						<ul class="slider">
							<li style="display:block; "><img src="img/products01.jpg" alt="ad1"></li>
							<li><img src="img/products02.jpg" alt="ad2"></li>
							<li><img src="img/products03.jpg" alt="ad3"></li>
							<li><img src="img/products04.jpg" alt="ad4"></li>
							<div class="move-cross"><img  alt=""></div>
						</ul>
						<ul class="control">
							
							
							<li class="control-selected first-control"><img src="<s:property value="vegetable.vegetablePicAddr.get(2)"/>" alt=""></li>
							
							<s:iterator value="vegetable.vegetablePicAddr" begin="3" end="5" id="st" >
							<li><img src="<s:property value="st"/>" alt=""></li>
							
							
							</s:iterator>
							
							<%-- <li><img src="/fruit<s:property value="vegetable.vegetablePicAddr.get(3).toString()"/>" alt=""></li>
							<li><img src="/fruit<s:property value="vegetable.vegetablePicAddr.get(4).toString()"/>" alt=""></li>
							<li><img src="/fruit<s:property value="vegetable.vegetablePicAddr.get(5).toString()"/>" alt=""></li> --%>
						</ul>
						<div class="product-info-photos-big">
							<img  alt="big">
						</div>
					</div>
				</div>
				<!-- 照片 end -->
				<!-- 购买框 start -->
				<div class="product-info-price">
					<h2><s:property value="vegetable.vegetableName"/></h2>
					<div class="product-info-price-num">
						<p class="present-price">
							<span class="label">现价：</span>
							<strong>￥<s:text name="global.format.number"> <s:param value="vegetable.vegetablePrice*vegetable.vegetableDiscount/10"></s:param></s:text></strong>
							<span class="discount"><s:property value="vegetable.vegetableDiscount"/>折</span>
						</p>
						<p class="pre-price">
							<span class="label">原价：</span>
							<strong>￥<s:property value="vegetable.vegetablePrice"/></strong>
						</p>
					</div>
					<div class="product-counte">
						<div class="product-hassaled">
							<div class="product-counte-num"><s:property value="vegetable.vegetableSaleCount"/></div>
							<div class="product-label">销量</div>
						</div>
						<div class="product-comment">
							<div class="product-counte-num"><s:property value="vegetable.vegetableCommentCount"/></div>
							<div class="product-label">评价</div>
						</div>
						<div class="product-state">
							<div class="product-counte-num"><s:property value="vegetable.vegetableQuantity"/></div>
							<div class="product-label">库存</div>
						</div>
					</div>
					<form action="" name="product-buy" method="get" id="product-buy">
						
						<input type="hidden" value="<s:property value="vegetable.vegetableID"/>" id="vegetable-id">
						<div>
							<label for="product-buy-num">购买数量：</label><input id="product-buy-num" class="score" name="product-buy-num" min='1' value='1' />
						</div>
						<div class="product-add-cart-box">
							<input class="add-cart" name="product-add-cart" type="button" value="">
						</div>
					</form>
				</div>
				<!-- 购买框 end -->
			</div>
			<!-- 简介 end -->
			<div class="clear-both"></div>
		</div>
	<!-- 上部分 end -->
	<!-- 底部 start -->
		<s:action name="findVegetablesBySale" id="listOfSale" >
			
		</s:action>
			
		<div class="product-info-bottom">
				<div class="hot-product-aside">
					<h3>热销人气商品<a href="findSaleVegetables?order=default&sort=desc&from=0">more +</a></h3>
					<div class="hot-product-aside-wrapper">
						<s:iterator value="#listOfSale.listOfSale" id="listOfSale">
						<a class="hot-product-one">
							<img src="<s:property value="#listOfSale.vegetablePicAddr.get(2)"/>" alt="" title="<s:property value="#listOfSale.vegetableName"/>">
							<div class="hot-product-one-info">
								<em>￥<s:text name="global.format.number"> <s:param value="#listOfSale.vegetablePrice*#listOfSale.vegetableDiscount/10"></s:param></s:text></em>
								<strong>销量：<s:property value="#listOfSale.vegetableSaleCount"/></strong>
							</div>
						</a>
						<br/>
						</s:iterator>
						<%-- <a class="hot-product-one">
							<img src="/fruit<s:property value="#listOfSale.listOfSale.get(0).vegetablePicAddr"/>" alt="" title="<s:property value="#listOfSale.listOfSale.get(0).vegetableName"/>">
							<div class="hot-product-one-info">
								<em>￥<s:property value="#listOfSale.listOfSale.get(0).vegetablePrice"/></em>
								<strong>销量：<s:property value="#listOfSale.listOfSale.get(0).vegetableSaleCount"/></strong>
							</div>
						</a>
						<a class="hot-product-one">
							<img src="/fruit<s:property value="#listOfSale.listOfSale.get(1).vegetablePicAddr"/>" alt="" title="<s:property value="#listOfSale.listOfSale.get(1).vegetableName"/>">
							<div class="hot-product-one-info">
								<em>￥<s:property value="#listOfSale.listOfSale.get(1).vegetablePrice"/></em>
								<strong>销量：<s:property value="#listOfSale.listOfSale.get(1).vegetableSaleCount"/></strong>
							</div>
						</a>
						<a class="hot-product-one">
							<img src="/fruit<s:property value="#listOfSale.listOfSale.get(2).vegetablePicAddr"/>" alt="" title="<s:property value="#listOfSale.listOfSale.get(2).vegetableName"/>">
							<div class="hot-product-one-info">
								<em>￥<s:property value="#listOfSale.listOfSale.get(2).vegetablePrice"/></em>
								<strong>销量：<s:property value="#listOfSale.listOfSale.get(2).vegetableSaleCount"/></strong>
							</div>
						</a>
						<a class="hot-product-one">
							<img src="img/same3.jpg" alt="" title="产品名称">
							<div class="hot-product-one-info">
								<em>￥165</em>
								<strong>销量：45</strong>
							</div>
						</a>
						<a class="hot-product-one">
							<img src="img/same01.jpg" alt="" title="产品名称">
							<div class="hot-product-one-info">
								<em>￥165</em>
								<strong>销量：45</strong>
							</div>
						</a> --%>
					</div>
				</div>
	<!-- 详情和评论  start-->
				<div id="detail-and-comment">
					<ul>
						<li><a href="#product-detail">商品详情</a></li>
						<li><a href="#product-comment">买家评价</a></li>
					</ul>
				<!-- 详情 start -->
					<div id="product-detail">
						<img src="img/delay850.gif" _src="/fruit<s:property value="vegetable.vegetableInfoPicAddr.get(0).toString()"/>"/>
						<img src="img/delay850.gif" _src="/fruit<s:property value="vegetable.vegetableInfoPicAddr.get(1).toString()"/>"/>
						<img src="img/delay850.gif" _src="/fruit<s:property value="vegetable.vegetableInfoPicAddr.get(2).toString()"/>"/>
						<img src="img/delay850.gif" _src="/fruit<s:property value="vegetable.vegetableInfoPicAddr.get(3).toString()"/>"/>
						<img src="img/delay850.gif" _src="img/detail005.jpg"/>
						<img src="img/delay850.gif" _src="img/detail006.jpg"/>
						<img src="img/delay850.gif" _src="img/detail007.jpg"/>
						<img src="img/delay850.gif" _src="img/detail008.jpg"/>
						<img src="img/delay850.gif" _src="img/indexslider01.jpg"/>
						
					</div>
				<!-- 详情 end -->
				<!-- 评论 start-->
					<div id="product-comment">
						<!-- 没有查到相应商品 start -->
						 <div class="comment-is-empty">
							<img src="img/logo.png" alt="logo"><em>对不起，没有相关评价！</em>
						</div>
						<!-- 没有查到相应商品 end -->
						<div class="comment-not-empty">
							<h3>评价</h3>
							<div class="product-comment-wrapper">
								<ul>
								</ul>
								<ol class="pagination">
							 	</ol>
							</div>
						</div>
					</div>
				<!-- 评论 end-->
				</div>
	<!-- 详情和评论 end -->
		</div>
	<!-- 底部 end -->
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