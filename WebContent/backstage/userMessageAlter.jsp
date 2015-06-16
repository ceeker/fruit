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
<title>修改用户留言</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>
<script>
window.onload=function(){
red=document.getElementsByName("userMessage.isConfirm");
var val=red[0].dataset.value;
if(val==1){
	red[0].checked=true;
	
}else{
	red[1].checked=true;
}
	
}
</script>
</head>
<body>
	<div class="main">
		<table class="table table-bordered">
			<caption>
				<strong>修改用户留言</strong>
			</caption>
			<tr>
				<td>
				<form action="updateUserMessageById" method="post" class="form-horizontal">
						
				标题： <input type="text" name="userMessage.userMessageTitle" class="input-large uneditable-input"
							value="<s:property value="userMessage.userMessageTitle"/>" />
						 <br/><br/>
				内容：
						<textarea name="userMessage.userMessageContent" class="uneditable-textarea" rows="6" cols="26">
						<s:property value="userMessage.userMessageContent" />
						</textarea>
				<br/> <br/>
				   是否通过审核：
    已通过<input type="radio" name="userMessage.isConfirm"  data-value="<s:property value="userMessage.isConfirm"/>" value="1"/>
   未通过<input type="radio" name="userMessage.isConfirm"  value="0"/>         
			<br/>	
			<input type="submit" value="提交" class="btn-primary">&nbsp;&nbsp;
			 </form>
			 </td>
			</tr>
		</table>

	</div>


</body>
</html>