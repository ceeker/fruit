<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en-US">
	<head>
    	<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<!-- saved from url=(0013)about:internet -->
    	<title>绿活网-通知</title>
    	<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
		<link rel="stylesheet" href="css/reset.css">
		<style>
			body{
				height: 100%;
				background: #fff;
			}
			 .flash-box{
			 	width: 700px;
			 	height: 150px;
			 	background: #73fad2;
			 	background: -moz-linear-gradient(top,#73fad2,#d5f8fc);
				background: -webkit-gradient(linear,top,from(#73fad2),to(#d5f8fc));
				background: -webkit-linear-gradient(top,#73fad2,#d5f8fc);
				background: -o-linear-gradient(top,#73fad2,#d5f8fc);
			 	border-radius:20px;
			 	box-shadow: 0 5px 15px rgba(0,0,0,0.2);
			 	position: absolute;
			 	left: 25%;
			 	left:calc(50% - 350px);
			 	top:20%;
			 }
			  .flash-box p{
			  	text-align: center;
			  	font: 25px/30px 'Microsoft Yahei';
			  	padding-top: 50px;
			  	color: #f7c35e;
			  }
			  #username{
			  	color: #5bbe30;
			  }
			  .flash-box p.second{
				font: 14px/30px 'Microsoft Yahei';
				padding-top: 20px;
				color: #999;
			  }
		</style>

	</head>
	<body> 
		<div class="flash-box">
		<s:if test="%{flag=='ok'}">
		<p>恭喜 <strong id="username"><s:property value="user.userId"/></strong>，注册成功！</p>
		<p class="second"><em id="time">5</em>秒后，将跳转至绿活网首页。</p>
		</s:if>
		<s:else>
		<p>对不起，<strong><s:property value="flag"/></strong></p>
		<p class="second"><em id="time">5</em>秒后，将跳转至注册页面。</p>
		</s:else>
			
			
		</div>
	</body>
		<script>
			var em=document.getElementById('time');
			var num=parseInt(em.innerHTML);
			var interval=setInterval(function(){
				num--;
				if(num<0){
					clearInterval(interval);
					if(document.getElementById('username')){
						window.location.href='./index.jsp';
					}else{
						window.location.href='./register.jsp';
					}
					
				}else{
					em.innerHTML=num;
				}
				
			},1000)
		</script>
</html>   