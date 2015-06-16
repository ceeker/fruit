<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>绿活果蔬-首页</title>
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
	<link rel="stylesheet" href="css/index.css">
	<script src="js/index.js"></script>
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
						<li class="nav-selected"><a href="index.jsp">首页</a></li>
						
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
		<div id="content">
			<div class="wrapper1">
				<!-- slider show -->
				<s:action name="findAllGalleryPics" id="findAllGalleryPics"></s:action>
				
				<div id="slider-show">
					<ul class="slider">
						<img class="zhanwei" src="img/zhanwei1.gif"/>
						<li style="display:block; "><a href="<s:property value="#findAllGalleryPics.listGalleryPics.get(0).galleryPicHref"/>"><img src="<s:property value="#findAllGalleryPics.listGalleryPics.get(0).galleryPicAddr"/>" alt="<s:property value="#findAllGalleryPics.listGalleryPics.get(0).galleryPicTitle"/>"></a></li>
						<s:iterator value="#findAllGalleryPics.listGalleryPics" id="listGalleryPics" begin="1" end="3">
						<li><a href="<s:property value="#listGalleryPics.galleryPicHref"/>"><img src="<s:property value="#listGalleryPics.galleryPicAddr"/>" alt="<s:property value="#listGalleryPics.galleryPicTitle"/>"></a></li>
						</s:iterator>
						<!-- <li><a href="#2"><img src="img/indexslider02.jpg" alt="ad2"></a></li>
						<li><a href="#3"><img src="img/indexslider03.jpg" alt="ad3"></a></li>
						<li><a href="#4"><img src="img/indexslider04.jpg" alt="ad4"></a></li> -->
					</ul>
					<ul class="control">
						
						<li class="control-selected">1</li>
						<li>2</li>
						<li>3</li>
						<li>4</li>
						
					</ul>
					<div class="to-left"><strong></strong></div>
					<div class="to-right"><strong></strong></div>
				</div>
				<!-- slider end-->
				<!-- ad banner start  -->
				
				<ul class="ad-banner">
				<%--  <s:action name="getAdById" id="getAdById1">
					<s:param name="adId" value="1"></s:param>
				</s:action> 
			<s:property value="#getAdById1.ad.advertisementPicAddr"/>
			<s:action name="getAdById" id="getAdById2">
					<s:param name="adId" value="2"></s:param>
				</s:action>
				<s:property value="#getAdById2.ad.advertisementPicAddr"/>
				<s:action name="getAdById" id="getAdById3">
					<s:param name="adId" value="3"></s:param>
				</s:action>
				<s:property value="#getAdById3.ad.advertisementPicAddr"/>	--%>	
					<li> 
					<s:action name="getAdById" id="getAdById1">
							<s:param name="advertisementId" value="1"></s:param>
					</s:action>
						<a href="<s:property value="#getAdById1.ad.advertisementHref"/>"><img src="<s:property value="#getAdById1.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById1.ad.advertisementTitle"/>"></a>
					</li>
					<li>
					<s:action name="getAdById" id="getAdById2">
					<s:param name="advertisementId" value="2"></s:param>
					</s:action>
						<a href="<s:property value="#getAdById2.ad.advertisementHref"/>"><img src="<s:property value="#getAdById2.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById2.ad.advertisementTitle"/>"></a>
					</li>
					<s:action name="getAdById" id="getAdById3">
					<s:param name="advertisementId" value="3"></s:param>
					</s:action>
					<li class="last-child">
						<a href="<s:property value="#getAdById3.ad.advertisementHref"/>"><img src="<s:property value="#getAdById3.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById3.ad.advertisementTitle"/>"></a>
					</li>
				</ul>
				<!-- ad banner end  -->
				<!-- sale start  -->
				<s:action name="findEightDiscountVeg" id="findEightDiscountVeg"></s:action>
				
				<div class="sale-product">
					<h3><span></span>特价专区</h3>
					<ul>
					<s:iterator value="#findEightDiscountVeg.listOfEgihtDiscount" id="listOfEightDiscount">
						<li>
							<a href="findVegetableByIdAction?vegetableId=<s:property value="#listOfEightDiscount.vegetableID"/>" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="<s:property value="#listOfEightDiscount.vegetablePicAddr.get(0)"/>" _ alt="<s:property value="#listOfEightDiscount.vegetableName"/>"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="findVegetableByIdAction?vegetableId=<s:property value="#listOfEightDiscount.vegetableID"/>" title="<s:property value="#listOfEightDiscount.vegetableName"/>"><s:property value="#listOfEightDiscount.vegetableName"/></a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong><s:property value="#listOfEightDiscount.vegetableDiscount"/></strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥<s:property value="#listOfEightDiscount.vegetablePrice"/></p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥<s:text name="global.format.number"> <s:param value="#listOfEightDiscount.vegetableDiscount*#listOfEightDiscount.vegetablePrice/10"></s:param></s:text></span>
										<span class="sale-product-hassaled">销量：<strong><s:property value="#listOfEightDiscount.vegetableSaleCount"/></strong>件</span>
									</p>
								</div>
							</div>
						</li>
					</s:iterator>
						<%-- <li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled02.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled03.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled04.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/sale01.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled02.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled03.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled04.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li> --%>
					</ul>
				</div>
				<!-- sale end  -->
				<!-- sale start  -->
				<s:action name="findEightRecommandVeg" id="findEightRecommandVeg"></s:action>
				<div class="sale-product">
					<h3><span></span>推荐专区</h3>
					<ul>
					<s:iterator value="#findEightRecommandVeg.listOfEgihtRecommand" id="listOfEightRecommand">
					
						<li>
							<a href="findVegetableByIdAction?vegetableId=<s:property value="#listOfEightRecommand.vegetableID"/>" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="<s:property value="#listOfEightRecommand.vegetablePicAddr.get(0)"/>" alt="<s:property value="#listOfEightRecommand.vegetableName"/>"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="findVegetableByIdAction?vegetableID=<s:property value="#listOfEightRecommand.vegetableId"/>" title="<s:property value="#listOfEightRecommand.vegetableName"/>"><s:property value="#listOfEightRecommand.vegetableName"/></a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong><s:property value="#listOfEightRecommand.vegetableDiscount"/></strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥<s:property value="#listOfEightRecommand.vegetablePrice"/></p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥<s:text name="global.format.number"> <s:param value="#listOfEightRecommand.vegetableDiscount*#listOfEightRecommand.vegetablePrice/10"></s:param></s:text></span>
										<span class="sale-product-hassaled">销量：<strong><s:property value="#listOfEightRecommand.vegetableSaleCount"/></strong></span>
									</p>
								</div>
							</div>
						</li>
						</s:iterator>
						<%-- <li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled02.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled03.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled04.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/sale01.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled02.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled03.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li>
						<li>
							<a href="#" class="sale-product-photo">
								<img class="delay" src="img/delay254.gif" _src="img/saled04.jpg" alt="商品名称"/>
								<em><img src="img/link-ico.png" alt="查看"/></em>
							</a>
							<a class="sale-product-name" href="#" title="商品名称">商品名称商品名称商品名称商品名称商品名称</a>
							<div class="sale-product-info">
								<span class="sale-product-discount"><strong>8</strong>折</span>
								<div class="sale-product-other">
									<p class="sale-product-before">￥1000</p>
									<p class="sale-product-now">
										<span class="sale-product-now-price">￥800</span>
										<span class="sale-product-hassaled">销量：<strong>168</strong>件</span>
									</p>
								</div>
							</div>
						</li> --%>
					</ul>
				</div>
				<!-- sale end  -->
				<div class="ad-footer">
				<s:action name="getAdById" id="getAdById4">
					<s:param name="advertisementId" value="4"></s:param>
					</s:action>
					<a href="<s:property value="#getAdById4.ad.advertisementHref"/>"><img src="<s:property value="#getAdById4.ad.advertisementPicAddr"/>" alt="<s:property value="#getAdById4.ad.advertisementTitle"/>"></a>
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
		<form action="userLogin" id="dialog-login" method="post">
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