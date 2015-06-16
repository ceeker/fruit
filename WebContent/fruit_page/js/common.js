//ajax初始化
$.ajaxSetup({
	error:function(xhr, status, info){
		alert(xhr.status + ' : ' +xhr.statusText);
	}
});
/*插件*/
$.fn.extend({
	tipDrop:function(){
		$(this).each(function(index, el) {
			$(el).hover(function(){
				$(this).find('.drop').stop().slideDown(200);
			},function(){
				$(this).find('.drop').stop().slideUp(200);
			})
		});
		return this;
	},
	onScreen:function(zindex){
		if($('#screen1').css('display')=='block'){
			$('#screen2').show().css('z-index',zindex);
		}else{
			$('#screen1').show().css('z-index',zindex);
			}
		$(document.documentElement).css('overflowY','hidden')
		return this;
	},
	offScreen:function(){
		if($('#screen2').css('display')=='block'){
			$('#screen2').hide();
		}else{
			$('#screen1').hide();
		}
		$(document.documentElement).css('overflowY','auto')	
		return this;
	},
	delayImg:function(){
		var $this=$(this);
		var temp=$this.get();
		$(window).scroll(function(event) {
			setTimeout(function(){
				for(var i=0,el=null;i<temp.length;i++){
					el=temp[i];	
					if($(window).scrollTop()+$(window).innerHeight()>$(el).offset().top){
						var img=new Image();
						$(img).load((function(ele) {//因为这里的el一直在改变，所以得用闭包
							return function(){$(ele).css({
									opacity:0,
									filter:'alpha(opacity=0)'
								})
								.attr('src',ele.getAttribute('_src'))
								.animate({opacity:1}, 500);
							}
						})(el));
						$(img).attr('src',el.getAttribute('_src'));
						temp.splice(i,1);
						i--;
					}
				}
			},500)
		});
		return this;

	},
	counter:function(){
		$(this).each(function(index, el) {
			var $num=$(el);
			if($num.val()==""){
				$num.val(function(){//因为要取得当前元素所以要用到回调函数
				return $(this).attr('min');
				})
			}
			$num.mousedown(function(event) {//阻止默认行为选中行为
				event.preventDefault()
			})
			.wrap('<div class="count-num-box"><div class="count-num-wrapper"></div></div>')
			.parents('.count-num-box')
			.prepend('<div class="count-num-decrease">-</div>')
			.append('<div class="count-num-increase">+</div>')
			
			$num.parent().prev().click(function(event) {
				var min=$num.attr('min')?parseInt($num.attr('min')):Infinity;
				if($num.val()>min){
					$num.val(function(index,val){
						return --val;
					})
				}	
			}).mousedown(function(event) {//阻止默认行为选中行为
				event.preventDefault()
			});
			$num.parent().next().click(function(event) {
				var max=$num.attr('max')?parseInt($num.attr('max')):-Infinity;
				if($num.val()<max){
					$num.val(function(index,val){
						return ++val;
					})
				}
			}).mousedown(function(event) {//阻止默认行为选中行为
				event.preventDefault()
			});
		});
		return this;
	}
});
$.extend({
	paging:function(ojson,now_page,each_num,pag_wrapper,con_wrapper,func,callback){//ojson是要进行分页的json数据，now_page是要加载的页,each_num是每页显示多少个，pag_wrapper是装分页元素的坑，con_wrapper是装内容的坑，func是点击分页链接的全局函数,callback是当前处理的json对象,要返回一个拼接好的字符串
		var total=ojson.length,
		total_page=Math.ceil(total/each_num),
		pag_arr=[],
		pag_str='',
		content_str="";
		if(total_page<5){
			printNum(1,total_page)
		}else{
			if(now_page<3){
				printNum(1,5)
			}else if(now_page>total_page-3){
				printNum(total_page-5,total_page)
			}else{
				printNum(now_page-2,now_page+2)
			}
		}
		if(now_page>1){
			pag_arr.unshift("<li><a href=\"javascript:"+func+"("+1+")\" rel=\"first\">首 页</a></li><li><a href=\"javascript:"+func+"("+(now_page-1)+")\" rel=\"prev\" title=\"上一页\">上一页</a>")
		}
		if(now_page<total_page){
			pag_arr.push("<li><a href=\"javascript:"+func+"("+(now_page+1)+")\" rel=\"next\" title=\"下一页\">下一页</a></li><li><a href=\"javascript:"+func+"("+total_page+")\" rel=\"last\">尾 页</a></li>")
		}
		if((now_page)*each_num<total){
			for(var i=(now_page-1)*each_num;i<(now_page)*each_num;i++){
				content_str+=callback(ojson[i]);
			}
		}else{
			for(var i=(now_page-1)*each_num;i<total;i++){
				content_str+=callback(ojson[i]);
			}
		}
		$(con_wrapper).html(content_str)
		pag_str=pag_arr.join("");
		$(pag_wrapper).html(pag_str)
		function printNum(start,end){
			for(var i=start;i<=end;i++){
					if(i==now_page){
						pag_arr.push("<li><a class=\"selected\" href=\"javascript:"+func+"("+i+")\">"+i+"</a></li>");
					}else{
						pag_arr.push("<li><a href=\"javascript:"+func+"("+i+")\">"+i+"</a></li>");
					}
			}
		}
	}
});

/*插件插件结束*/

$(function(){
	//加载进度条
	window.progress=function (callback){
		var $img=$('img');
		var progress_num=document.getElementById('progress-num');
		var $progress_now=$('.progress-now');
		var progress=0;
		var div_width=482;
		var img_length=$img.get().length;
		var new_img=[];
		for(var i=0;i<img_length;i++){
			new_img.push(new Image());
		}
		for(var i=0;i<new_img.length;i++){
			//加载成功
			new_img[i].onload=function(){
				progress++;
				progress_num.innerHTML=Math.ceil((progress/img_length)*100)+'% Loaded';
				$progress_now.width((progress/img_length)*div_width);
				if(progress==img_length){
					$('#progress-num').css({
							webkitAnimationPlayState:'paused',
							mozAnimationPlayState:'paused',
					})
					$('#progress').fadeOut('800', function() {
						$('#all-content').fadeIn(800);
						if(typeof callback=="function"){
							callback();
						}
						
					});
				}
			}
			//加载失败
			new_img[i].onerror=function(){
				progress++;
				progress_num.innerHTML=Math.ceil((progress/img_length)*100)+'% Loaded';
				$progress_now.width((progress/img_length)*div_width);
				if(progress==img_length){
					$('#progress-num').css({
							webkitAnimationPlayState:'paused',
							mozAnimationPlayState:'paused',
					})
					$('#progress').fadeOut('800', function() {
						$('#all-content').fadeIn(800);	
						if(typeof callback=="function"){
							callback();
						}
						
					});
				}
			}

			new_img[i].src=$img.eq(i).attr('src');
		}
	}
	$('.buy-car,.my-center').tipDrop();
	var $backTop=$('#back-to-top');//返回顶部元素
	$backTop.click(function(event) {
		$('body,html').animate({scrollTop:'0px'}, 400);
	});
	/*导航悬浮 和其他有关滚动事件*/
	$(window).scroll(function(event) {
		var $nav=$('#header .nav');
		if($(this).scrollTop()>0){
			$backTop.css({
				'display':'block'
			})
		}else{
			$backTop.css({
				'display':'none'
			})	
		}
		 if($(this).scrollTop()>=140){
			$nav.css({
				'position':'fixed',
				'left':0,
				'top':0,
				'backgroundColor':'rgba(244,236,220,0.8)'
			})
		}else{
			$nav.css({
				'position':'absolute',
				'left':0,
				'top':'140px',
				'background':'#F4ECDC'
			})
		}
	});
//对话框
/*登录*/
	$('#dialog-login').dialog({
		/*对话框标题*/
		title: '用户登录',
		/*在对话框添加按钮，值所对应的函数是点击按钮所运行的函数，this表示对话框写内容的div元素*/
		buttons: {
			'登录': function() {
				$(this).submit();
			},
			'取消': function() {
				$(this).dialog('close').offScreen();
			}

		},
		width: 500,
		minWidth: 300,
		/*打开和关闭的动画效果*/
		show: false,
		hide: false,
		/*调用.dialog是否显示对话框，如果用于初始化对话框，可以现不现实，然后用.dialog('open')打开对话框*/
		autoOpen: false,
		/*可不可以退调整对话框大小*/
		resizable: false,
		/*改变关闭按钮提示*/
		closeText: '关闭',
		closeOnEscape: false, //按下esc 无效
		/*是否有遮罩*/
		modal: false
	});
	$('.member-login').click(function(event) {
		$('#dialog-login').dialog('open').onScreen(99);
	});
	//因为后续会有动态生成的dialog，所以我们要用事件委托,这里的this已经是选择的元素了
	$(document).on('click','.ui-dialog-titlebar-close',function(event) {
		$(window).offScreen();
	});
	/*loading*/
	$('.loading').dialog({
		show: false,
		hide: false,
		modal:false,
		autoOpen: false,
		closeOnEscape: false, //按下esc 无效
		resizable: false,
		draggable: false,
		height: 110,
		width: 280
	}).dialog('widget').css('z-index',102)
	$('#dialog-login').validate({ //验证表单
		//使用其他方式代替默认提交
		submitHandler: function(form1) { //这里的参数代表#test表单			
			//验证成功后执行，且阻止了默认提交
			//一般用于ajax提交
			$(form1).ajaxSubmit({
				url: 'userLogin',
				type: 'POST',
				beforeSubmit: function(formData, jqForm, options) { //formData表单内容数组，jqForm得到form 的jquery 对象，option是当前设置的属性
					//alert(options.url);//demo.php
					jqForm.dialog('widget').find('button').eq(1).button('disable')
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在登录....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success: function(responseText, statusText) {
					if (/^true$/.test(responseText)) {
						$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp;恭喜您登录成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
						$('#dialog-login').dialog('widget').find('button').eq(1).button('enable');
						$('#dialog-login').resetForm();
						setTimeout(function() {
							window.location.reload(true);
						}, 2000)
					} else {
						if(/^nouser$/.test(responseText)){
							$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;登录失败，不存在此用户名！</span>').removeClass('registing regsuccess').addClass('regwrong');
						}else if(/^passwrong$/.test(responseText)){
							$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;登录失败，密码错误！</span>').removeClass('registing regsuccess').addClass('regwrong');
						}else{
							$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;返回值为'+responseText+'</span>').removeClass('registing regsuccess').addClass('regwrong');
						}
						$('#dialog-login').dialog('widget').find('button').eq(1).button('enable');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
						}, 2000)
					}
				},
				error : function (event, errorText, errorType) { //错误时调用
					alert(errorText + errorType);
				}
			});
		},
		//指定label放的位置
		errorLabelContainer: 'ol.login-error',
		//在label上包裹一层元素
		wrapper: 'li',
		rules: {
			'dialog-login-user': {
				required: true
			},
			'dialog-login-pass': {
				required: true
			}
		},
		messages: {
			'dialog-login-user': {
				required: '账号不能为空！'
			},
			'dialog-login-pass': {
				required: '密码不能为空！'
			}
		}
	});




















});
