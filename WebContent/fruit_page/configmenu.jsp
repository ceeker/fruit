<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.math.BigDecimal"  %>
    <%@ page import="com.fruit.domain.*"  %>
    
        <%@ taglib prefix="s" uri="/struts-tags" %>  
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- saved from url=(0013)about:internet -->
	<title>绿活果蔬-确认下单</title>
	<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/configmenu.css">
	<script src="js/modernizr.js"></script>
	<script src="js/jquery-1.11.0.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/common.js"></script>
	<!-- 本页面加载文件 -->

	</head>
	<body>
	<%
	Object userId=request.getSession().getAttribute("userId");
	
	
%>
	
	<%
	Object o=request.getSession().getAttribute("listBooks");
		List listBooks=(List<Book>)o;	
	double totalPrice=0;
	double vPrice=0;
	 for(int i=0;i<listBooks.size();i++)
			
		{
			Book b=(Book)listBooks.get(i);	
			BigDecimal   bd   =   new   BigDecimal(b.getBookVegetable().getVegetablePrice()*b.getBookVegetable().getVegetableDiscount()/10*b.getBookQuantity());
			
			vPrice=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		totalPrice=totalPrice+vPrice;
		}
		
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
        <div id="content" class="wrapper1">
           <div id="menu_bar">
               <div id="menuheader"> <img src="img/logo.png" height="80px" width="80px">
                <div class="menutitle">绿活果蔬</div>
                <div id="menubg"></div>
               </div>
               <div id="menu_count">
                <table width="900px" border="1px" align="center">
                                <tr id="menu_counth">
                                <td>名称</td>
                                <td>小计</td>
                                <td>总金额</td>
                            </tr>
                            <s:iterator value="#session.listBooks" id="book" status="st">
                            <tr>
                            	 
                            	<td><s:property value="#book.bookVegetable.vegetableName"/></td>
                                <td><s:property value="#book.bookQuantity"/></td>
                                <td><s:text name="global.format.number"><s:param value="#book.bookVegetable.vegetablePrice*bookVegetable.vegetableDiscount/10*#book.bookQuantity"></s:param></s:text></td>
                            	
                            	
                            	
                            	
                              
                            </tr>
                           </s:iterator> 
                                <tr>
                                
                                <td colspan="3">亲，你的订单总计为：<%=totalPrice %></td>
                            </tr>
                            
                             <tr>
                                <td colspan="3">
                                <div class="menuaddress">
                                <s:action name="findUserInfoById" id="findUserInfoById">
                                	
                                </s:action>
                                
                                <form action="" method="post">
                                送货地址：
                        <input class="inputstyle" type="text" placeholder="你的地址信息" value="<s:property value="#findUserInfoById.user.userAddr"/>">联系电话：
                        <input class="inputstyle" type="text" placeholder="联系电话" value="<s:property value="#findUserInfoById.user.userPhone"/>">
                        </div>
                               </form> 
                                </td>
                            </tr>
                            <tr>
                                
                                <td colspan="3"></td>
                            </tr>
                            <tr>
                                <td colspan="2">支付方式：&nbsp;&nbsp;<span><input type="radio" name="payway" checked="checked"/></span>货到付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><input type="radio"  name="payway"/>  在线支付</span></td>
                                <td align="center"><input id="ordersubmit" type="submit" value=" 提交订单"/></td>
                            </tr>
                            </table>
               
              
               </div>
           
           </div>
        </div>
        <!-- content end --> 
        <!-- footer start -->
        <div id="footer">
        <p> 绿活果蔬&nbsp;|&nbsp; <a href="#">关于我们</a> &nbsp;|&nbsp; <a href="#">合作伙伴</a> &nbsp;|&nbsp; <a href="#">团队介绍</a> &nbsp;|&nbsp; <a href="#">友情链接</a> &nbsp;|&nbsp; Copyright @lvhuowang.com.All Rights Reserved &nbsp; 京ICP证 080047号 &nbsp;|&nbsp; 黑公网安备9999999999号 </p>
    </div>
        <!-- footer end -->
        <div id="back-to-top" title="返回顶部">返回顶部</div>
        <!-- dialog start --> 
        <!-- 登陆框 -->
        <form action="#" id="dialog-login" method="post">
        <ol class="login-error">
            </ol>
        <div>
                <label for="dialog-login-user">账 号:&nbsp;&nbsp;</label>
                <input name="dialog-login-user" type="text" id="dialog-login-user"/>
            </div>
        <div>
                <label for="dialog-login-pass">密 码:&nbsp;&nbsp;</label>
                <input name="dialog-login-pass" id="dialog-login-pass" type="password"/>
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