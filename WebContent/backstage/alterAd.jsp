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
<title>修改广告</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="main">
		<table align="center">
			<caption>
				<strong>修改广告信息</strong>
			</caption>
			<tr>
				<td>
				<form action="insertAd" method="post" class="form-horizontal" enctype="multipart/form-data">
				 <input type="hidden" name="advertisementId" class="input-medium"
							value="<s:property value="ad.advertisementId"/>" />
						 <br/>	 <br/>	
				广告标题： <input type="text" name="ad.advertisementTitle" class="input-large"
							value="<s:property value="ad.advertisementTitle"/>" />
						 <br/> <br/>
				广告信息：
						<textarea name="ad.advertisementInfo" class="textarea" rows="6">
						<s:property value="ad.advertisementInfo" />
						</textarea>
				<br/> <br/>
				广告图片： <input type="file" name="adFile" class="input-medium"/>
						 <br/> <br/>
				广告链接： <input type="text" name="ad.advertisementHref" class="input-medium"
							value="<s:property value="ad.advertisementHref"/>" />
						 <br/> <br/>
				<input type="submit" value="提交" class="btn-primary">&nbsp;&nbsp;
				<input type="reset" value="重置" class="btn-primary">
			 </form>
			 </td>
			</tr>
		</table>

	</div>


</body>
</html>