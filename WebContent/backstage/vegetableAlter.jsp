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
<title>修改蔬菜</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/web.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css">
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/bootstrap.js"></script>

<script>
window.onload=function(){
red=document.getElementsByName("vegetable.isRecommend");
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
        <strong>修改蔬菜基本信息</strong>
        </caption>
        <tr>
            <td><form action="updateVegetableById" method="post" class="form-horizontal">
                    名称：
      <input type="text" name="vegetable.vegetableName" class="input-small" value="<s:property value="vegetable.vegetableName"/>"/>
                 &nbsp;&nbsp;    价格：
     <input type="text" name="vegetable.vegetablePrice" class="input-mini" value="<s:property value="vegetable.vegetablePrice"/>"/>
                  &nbsp;&nbsp;    单位：
     <input type="text" name="vegetable.vegetableUnit" class="input-mini" value="<s:property value="vegetable.vegetableUnit"/>"/>
                &nbsp;&nbsp;    类别：      
     <input type="text" name="vegetable.vegetableCatagory" class="input-small" value="<s:property value="vegetable.vegetableCatagory"/>"/>      
      <br/>   
           是否推荐：
  
     是<input type="radio" name="vegetable.isRecommend"  data-value="<s:property value="vegetable.isRecommend"/>" value="1"/>
   否<input type="radio" name="vegetable.isRecommend"  value="0"/>         
   &nbsp;&nbsp; 
   销量：
    <input type="text" name="vegetable.vegetableSaleCount" class="input-mini" value="<s:property value="vegetable.vegetableSaleCount"/>"/>
  &nbsp;&nbsp;    
                    库存：
    <input type="text" name="vegetable.vegetableQuantity" class="input-mini" value="<s:property value="vegetable.vegetableQuantity"/>"/>
  &nbsp;&nbsp;    
              折扣：
    <input type="text" name="vegetable.vegetableDiscount" class="input-mini" value="<s:property value="vegetable.vegetableDiscount"/>" />
                    <br/>
                    <br/>
                    关键字：
   <input type="text" name="vegetable.vegetableKeyWords" class="input-medium" value="<s:property value="vegetable.vegetableKeyWords"/>" /> (以英文逗号隔开) &nbsp;&nbsp;          
       介绍信息：
  <textarea name="vegetable.vegetableInfo" class="textarea"><s:property value="vegetable.vegetableInfo"/></textarea>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
                  
                    <input type="submit" value="提交"  class="btn-primary">
                </form></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <caption>
        <strong>附加图片页</strong>
        </caption>
        <tr>
            <td width="12%">推荐区图片</td>
            <td width="56%">
            	<form action="insertOrUpdateVegetablePic1" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic1"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
            </td>
            <td width="32%">长*宽：250px*250px</td>
        </tr>
        <tr>
            <td>产品列图片</td>
            <td><form action="insertOrUpdateVegetablePic2" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic2"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form></td>
            <td>长*宽：不限px*250px</td>
        </tr>
        <tr>
            <td>购物车缩略图</td>
            <td><form action="insertOrUpdateVegetablePic3" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic3"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form></td>
            <td>长*宽：80px*80px</td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><form action="insertOrUpdateVegetablePic4" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic4"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
                <form action="insertOrUpdateVegetablePic5" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic5"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
                <form action="insertOrUpdateVegetablePic6" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic6"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
                <form action="insertOrUpdateVegetablePic7" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic7"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
               <form action="insertOrUpdateVegetablePic8" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic8"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
               <form action="insertOrUpdateVegetablePic9" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic9"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
               <form action="insertOrUpdateVegetablePic10" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic10"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
               <form action="insertOrUpdateVegetablePic11" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic11"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form></td>
            <td></td>
        </tr>
        <tr>
            <td>商品详细图</td>
            <td><form action="insertOrUpdateVegetablePic12" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic12"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
               <form action="insertOrUpdateVegetablePic13" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic13"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
                <form action="insertOrUpdateVegetablePic14" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic14"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form>
               <form action="insertOrUpdateVegetablePic15" method="post" enctype="multipart/form-data"> 
                    <input type="file" name="vegetablePic15"/>
                    <input type="submit" value="提交" class="btn-mini btn-primary">
                </form></td>
            <td>可以少于4张，当保证一次添加图片</td>
        </tr>
    </table>
</div>
</div>
</body>
</html>
