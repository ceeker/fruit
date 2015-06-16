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
<title>修改滚动栏图片</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="main">
		<table class="table table-bordered">
			<caption>
				<strong>修改滚动栏图片</strong>
			</caption>
			<tr>
				<td>
				<form action="updateGalleryPicById" method="post" class="form-horizontal">
				 <input type="hidden" name="galleryPic.galleryPicId" class="input-medium"
							value="<s:property value="galleryPic.galleryPicId"/>" />
						 <br/>		
				滚动栏标题： <input type="text" name="galleryPic.galleryPicTitle" class="input-large"
							value="<s:property value="galleryPic.galleryPicTitle"/>" />
						 <br/><br/>
				滚动栏信息：
						<textarea name="galleryPic.galleryPicInfo" class="textarea" rows="6">
						<s:property value="galleryPic.galleryPicInfo" />
						</textarea>
				<br/><br/>
				
				滚动栏链接： <input type="text" name="galleryPic.galleryPicHref" class="input-large"
							value="<s:property value="galleryPic.galleryPicHref"/>" />
						 <br/><br/>
				<input type="submit" value="提交" class="btn-primary">&nbsp;&nbsp;
				<input type="reset" value="重置" class="btn-primary">
			 </form>
			 <br/>
			 <br/>
			 <form action="updateGalleryPic" method="post" class="form-horizontal" enctype="multipart/form-data">
			      滚动栏图片： <input type="file" name="galleryPicFile" class="input-medium"/>
			   
			   <br/>
			   <input type="submit" value="提交" class="btn-primary">
			 </form>
			 </td>
			</tr>
		</table>

	</div>


</body>
</html>