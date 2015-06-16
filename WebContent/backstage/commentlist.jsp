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
<title>评论管理中心</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

</head>


<body>
<div class="main">
<label class="label">评论信息列表</label>
<table class="table table-striped table-bordered table-condensed"> 
 <thead>
 <tr> 
       <th>评论编号</th>
      <th>评论的蔬菜</th>
      <th>评论信息</th>      
       <th>评论人</th> 
       <th>评论分数</th> 
       <th>评论时间</th>
       <th>修改（是否显示）</th> 
  </tr> 
 </thead>
  <tbody>   
  <s:iterator value="list" id="cml">
  <tr> 
       <td class="comment-id"><s:property value="#cml.commentId"/></td>
       <td><s:property value="#cml.commentVeg.vegetableID"/></td>     
       <td><s:property value="#cml.commentInfo"/></td> 
       <td><s:property value="#cml.commentUser.userId"/></td> 
       <td><s:property value="#cml.commentScore"/></td> 
       <td><s:text name="global.datetime"><s:param value="#cml.commentDate"/></s:text></td> 
       <td><s:if test="#cml.visible==0">不显示</s:if>
       <s:elseif test="#cml.visible==1">
       <input class="visible-btn" type="button" value="置为不可显示"/>
       </s:elseif>
       </td> 
  </tr>  
 </s:iterator> 
  </tbody>
</table>
<div class="pagination">  <ul>    <li><a href="#">前一页</a></li>    <li class="active">      <a href="#">1</a>    </li>    <li><a href="#">2</a></li>    <li><a href="#">3</a></li>    <li><a href="#">4</a></li>    <li><a href="#">后一页</a></li>  </ul></div


></div>
<script>
	$(document).on('click','.visible-btn',function(){
		if(window.confirm('您是否确认将该评论置为不可见？')){
			var $tr=$(this).parents('tr');
			var $td=$(this).parent('td');
			$.ajax({
				url: 'disVisiable',
				type: 'GET',
				dataType: 'html',
				data: {commentId:$tr.find('.comment-id').html()},
				success:function(rq){
					if(/^true$/.test(rq)){
						$td.html('不显示');
					}else{
						alert('操作失败！');
					}
				}
			});
		}
	});


</script>

</body>
</html>
