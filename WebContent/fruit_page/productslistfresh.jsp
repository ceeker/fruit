<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>绿活果蔬-产品列表</title>
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
	<link rel="stylesheet" href="css/productslist.css">
	<script src="js/productslistfresh.js"></script>
</head>
<%
	Object userId=request.getSession().getAttribute("userId");
	
	
%>
<s:if test="#session.userId==null">

<body data-last="<s:property value="#session.isLast"/>"   data-freshlast="<s:property value="#session.freshisLast"/>" data-keyword="<s:property value="keyWord"/>" data-hotLast="<s:property value="#session.hotisLast"/>" >
</s:if>
<s:else>
<body data-keyword="<s:property value="keyWord"/>" data-freshlast="<s:property value="#session.freshisLast"/>" data-user="<%=userId.toString()%>" >
</s:else>




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
						
						<li class="nav-selected"><a href="findFreshVegetables?order=default&sort=desc&from=0">新鲜水果</a></li>
						<li><a href="findDiscountVegetables?order=default&sort=desc&from=0">优惠专区</a></li>
						<li><a href="userMessagePage?hql=from UserMessage as um order by um.userMessageDate desc">用户留言</a></li>
						<li><a href="adminMessagePage">绿活公告</a></li>
						<li><a href="aboutus.jsp">关于我们</a></li>
						
						
					</ul>
				</div>
		</div>
		<!-- header end -->
		<!-- content start -->
		<!-- 分类 start -->
		<div id="content" class="wrapper1">
			<ul id="products-class">
				<li class="products-class-box first">
					<a href="#" class="products-class-img"><img src="img/bigclass1.jpg" alt=""></a>
					<div class="products-class-hot">
						<em>热门</em> |&nbsp;
						<s:action name="findHotKeysRefParam" id="findHotKeyWordsRefParam">
							<s:param name="param" value="'水果'"></s:param>
						</s:action>
							
							<s:iterator value="#findHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
						
					</div>
					<div class="products-class-all">
						<em>全部</em> |&nbsp;
						<s:action name="findAllHotKeysRefParam" id="findAllHotKeyWordsRefParam">
							<s:param name="param" value="'水果'"></s:param>
						</s:action>
							
							<s:iterator value="#findAllHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
						
					</div>
				</li>
				<li class="products-class-box">
					<a href="#" class="products-class-img"><img src="img/bigclass2.jpg" alt=""></a>
					<div class="products-class-hot">
						<em>热门</em> |&nbsp;
						<s:action name="findHotKeysRefParam" id="findHotKeyWordsRefParam">
							<s:param name="param" value="'水果'"></s:param>
						</s:action>
							
							<s:iterator value="#findHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
						
					</div>
					<div class="products-class-all">
						<em>全部</em> |&nbsp;
						<s:action name="findAllHotKeysRefParam" id="findAllHotKeyWordsRefParam">
							<s:param name="param" value="'水果'"></s:param>
						</s:action>
							
							<s:iterator value="#findAllHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
						
					</div>
				</li>
				<li class="products-class-box">
					<a href="#" class="products-class-img"><img src="img/bigclass3.jpg" alt=""></a>
					<div class="products-class-hot">
						<em>热门</em> |&nbsp;
						<s:action name="findHotKeysRefParam" id="findHotKeyWordsRefParam">
							<s:param name="param" value="'蔬菜'"></s:param>
						</s:action>
							
							<s:iterator value="#findHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
						
					</div>
					<div class="products-class-all">
						<em>全部</em> |&nbsp;
						<s:action name="findAllHotKeysRefParam" id="findAllHotKeyWordsRefParam">
							<s:param name="param" value="'蔬菜'"></s:param>
						</s:action>
							
							<s:iterator value="#findAllHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
					
					</div>
				</li>
				<li class="products-class-box">
					<a href="#" class="products-class-img"><img src="img/bigclass4.jpg" alt=""></a>
					<div class="products-class-hot">
						<em>热门</em> |&nbsp;
						<s:action name="findHotKeysRefParam" id="findHotKeyWordsRefParam">
							<s:param name="param" value="'蔬菜'"></s:param>
						</s:action>
							
							<s:iterator value="#findHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
						
					</div>
					<div class="products-class-all">
						<em>全部</em> |&nbsp;
						<s:action name="findAllHotKeysRefParam" id="findAllHotKeyWordsRefParam">
							<s:param name="param" value="'蔬菜'"></s:param>
						</s:action>
							
							<s:iterator value="#findAllHotKeyWordsRefParam.listKeyWords" id="keyWords">
							
							<a href="findVegetableByKeyWord?keyWord=<s:property value="#keyWords"/>&order=default&sort=desc&from=0"><s:property value="#keyWords"/>&nbsp;</a>
							</s:iterator>
					
					</div>
				</li>
					<s:action name="getAdById" id="getAdById5">
					<s:param name="adId" value="5"></s:param>
					</s:action>
				<div class="products-class-ad"><img src="<s:property value="#getAdById5.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById5.ad.advertisementTitle"/>"></div>
			</ul>
			<!-- 分类 end -->
			<!-- 滑动广告 start -->
			<div class="slider-ad">
				<ul class="slider">
					<li style="top:0% ">
					<s:action name="getAdById" id="getAdById6">
					<s:param name="adId" value="6"></s:param>
					</s:action>
					<a href="<s:property value="#getAdById6.ad.advertisementHref"/>"><img src="<s:property value="#getAdById6.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById6.ad.advertisementTitle"/>"></a>
					
					</li>
					<li>
					<s:action name="getAdById" id="getAdById7">
					<s:param name="adId" value="7"></s:param>
					</s:action>
					<a href="<s:property value="#getAdById7.ad.advertisementHref"/>"><img src="<s:property value="#getAdById7.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById7.ad.advertisementTitle"/>"></a>
					
					</li>
					<li>
					<s:action name="getAdById" id="getAdById8">
					<s:param name="adId" value="8"></s:param>
					</s:action>
					<a href="<s:property value="#getAdById8.ad.advertisementHref"/>"><img src="<s:property value="#getAdById8.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById8.ad.advertisementTitle"/>"></a>
					
					</li>
				</ul>
				<ul class="control">
					<li class="control-selected"></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<!-- 滑动广告 end -->
			<div class="products-list-wrapper">
				<!-- 产品列表 start -->
				<div class="products-list">
				
				<s:if test='isEmpty=="yes"'>
				<div id="veg-is-empty">
						<img src="img/logo.png" alt="logo"><em>对不起，没有搜索到你想要的结果！</em>
					</div>
				</s:if>
				<s:else>
					<!-- 排序 start -->
					<div class="products-sort">
						<strong>排序方式：</strong>
						
						<s:if test='order=="default"'>
							
								<a class="first selected hot">全部</a>
								<a class="hassaled " href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetableSaleCount&sort=desc&from=0" >销量<span>&nbsp;&nbsp;</span></a>
								<a class="price-up" href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetablePrice&sort=asc&from=0">价格<span>&nbsp;&nbsp;</span></a>
								<a class="last price-down"  href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetablePrice&sort=desc&from=0">价格<span>&nbsp;&nbsp;</span></a>
								
								 
						</s:if>
							
							<s:elseif test='order=="vegetableSaleCount"'>
								
							<a class="first  hot" href="findFreshVegetables?order=default&sort=desc&from=0">全部</a>
							<a class="hassaled selected" >销量<span>&nbsp;&nbsp;</span></a>	
							<a class="price-up" href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetablePrice&sort=asc&from=0">价格<span>&nbsp;&nbsp;</span></a>
							<a class="last price-down"  href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetablePrice&sort=desc&from=0">价格<span>&nbsp;&nbsp;</span></a>
								
								
							</s:elseif>
							<s:elseif test='order=="vegetablePrice" && sort=="asc"'>
							
								
								<a class="first  hot" href="findFreshVegetables?order=default&sort=desc&from=0">全部</a>
								<a class="hassaled " href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetableSaleCount&sort=desc&from=0" >销量<span>&nbsp;&nbsp;</span></a>
								<a class="price-up selected" >价格<span>&nbsp;&nbsp;</span></a>
								<a class="last price-down"  href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetablePrice&sort=desc&from=0">价格<span>&nbsp;&nbsp;</span></a>
								
								
								
							
								
							
							</s:elseif>
							<s:else>
									
									<a class="first  hot" href="findFreshVegetables?order=default&sort=desc&from=0">全部</a>
									<a class="hassaled " href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetableSaleCount&sort=desc&from=0" >销量<span>&nbsp;&nbsp;</span></a>	
									<a class="price-up" href="findFreshVegetables?keyWord=<s:property value="keyWord"/>&order=vegetablePrice&sort=asc&from=0">价格<span>&nbsp;&nbsp;</span></a>
									
									<a class="last selected  price-down">价格<span>&nbsp;&nbsp;</span></a>
									
									
								</s:else>
							
						
						
						
						
					</div>
					<!-- 排序 end -->
					<div class="products-list-box">
						<s:iterator value="listVegetables" id="v">
						<div class="pin">
							<div class="box">
							
								
							
								<a href="findVegetableByIdAction?vegetableId=<s:property value="#v.vegetableID"/>" class="product-info-photo">
									<img src="<s:property value="#v.vegetablePicAddr.get(1)"/>" />
								</a>
								<div class="product-info">
									<div class="zhedang">
										<div class="zhedang-left"></div>
										<div class="zhedang-center"></div>
										<div class="zhedang-right"></div>
									</div>
									<div class="product-info-price">￥<s:text name="global.format.number"> <s:param value="#v.vegetablePrice*#v.vegetableDiscount/10"></s:param></s:text></div>
									<a href="#" class="product-info-name"><s:property value="#v.vegetableName"/></a>
									<div class="product-info-hassaled">
										销量：<strong><s:property value="#v.vegetableSaleCount"/>份</strong>	
									</div>
									<form action="" class="product-info-buy" name="product-info-buy">
										<input type="hidden" value="<s:property value="#v.vegetableID"/>" class="vegetable-id">
										<input type="text" name="product-info-num" class="product-info-num" min="1" max="100" />
										<button name="product-info-submit" class="product-info-submit">加入购物车</button>
									</form>
								</div>
							</div>
						</div>
						</s:iterator>
					</div>
				<!-- 加载 -->
					<div class="inner_pic_loading"><img src="img/innerpicloading.gif" alt="加载中"></div>
				</s:else>
					
					
					
					
						
					
					
					
				</div>
				<!-- 产品列表 end -->
				<!-- 热门商品 start -->
				<s:action name="findVegetablesBySale" id="listOfSale" >
			
				</s:action>
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
							<img src="img/same01.jpg" alt="" title="产品名称">
							<div class="hot-product-one-info">
								<em>￥165</em>
								<strong>销量：45</strong>
							</div>
						</a>
						<a class="hot-product-one">
							<img src="img/same4.jpg" alt="" title="产品名称">
							<div class="hot-product-one-info">
								<em>￥165</em>
								<strong>销量：45</strong>
							</div>
						</a>
						<a class="hot-product-one">
							<img src="img/same2.gif" alt="" title="产品名称">
							<div class="hot-product-one-info">
								<em>￥165</em>
								<strong>销量：45</strong>
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
				<!-- 热门商品 end -->
				<div class="clear-both"></div>
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
	</div>
	<!-- all-content end -->
	
</body>
</html>