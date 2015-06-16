$(function(){
	var user=$(document.body).data('user');	
	//广告轮播
	var slider_index = 1;
	var slitimer = setInterval(slifun, 3000);
	/*手动*/
	$('.control li').hover(function() {
		$(this).addClass('control-hover');
	}, function() {
		$(this).removeClass('control-hover');
	}).click(function(){
		if (!$(this).hasClass('control-selected')){
		clearInterval(slitimer);
		var this_index = $('.control li').index(this);
		clickfun(this_index);
		slitimer = setInterval(slifun, 3000);
		}
	});
	//鼠标放上停止
	$('.slider').hover(function(){
		clearInterval(slitimer);
	},function(){
		slitimer = setInterval(slifun, 3000);
	});
	/*自动*/

	function slifun() {
		$('.control li').removeClass('control-selected').eq(slider_index).addClass('control-selected');
		Change(slider_index, preSliderIndex(slider_index))
		slider_index = nextSliderIndex(slider_index);
	}
	function clickfun(index) {
			$('.control li').removeClass('control-selected').eq(index).addClass('control-selected');
			Change(index, preSliderIndex(slider_index));
			slider_index = nextSliderIndex(index);
			//这块不需要重新加上interval在鼠标出slider的时候才加上
	}
	function Change(index, prv) {
		$('.slider li').eq(index).fadeIn(600);
		$('.slider li').eq(prv).fadeOut(600);
	}

	function nextSliderIndex(index) {
		return index + 1 >= $('.slider li').size() ? 0 : index + 1;
	};

	function preSliderIndex(index) {
		return index - 1 <= -1 ? $('.slider li').size() - 1 : index - 1;
	}

	//放大镜功能
	var $move_cross=$('.move-cross'),
	$cimg=$move_cross.find('img'),
	$slider=$('.slider'),
	$big=$('.product-info-photos-big'),
	c_w=$move_cross.outerWidth(),
	c_h=$move_cross.outerHeight(),
	s_l=$slider.offset().left,
	s_t=$slider.offset().top,
	s_w=$slider.outerWidth(),
	s_h=$slider.outerHeight();
	$slider.hover(function(e){
		var src=$slider.find('li img').eq(preSliderIndex(slider_index)).attr('src');
		$slider.find('li img').stop().animate({
			opacity:0.6
		},300);
		$cimg.attr('src',src);
		$big.stop().fadeIn(300).find('img').attr('src',src);
		$(this).on('mousemove', function(e) {
			e.preventDefault();
			var le=e.clientX+$(window).scrollLeft()-s_l-c_w/2,
			top=e.clientY+$(window).scrollTop()-s_t-c_h/2;
			if(le>s_w-c_w){
				le=s_w-c_w;
			}
			if(le<=0){
				le=0;
			}
			if(top>s_h-c_h){
				top=s_h-c_h;
			}
			if(top<=0){
				top=0;
			}
			$move_cross.css({
				left:le,
				top:top
			})
			$cimg.css({
			left:-le,
			top:-top
			});
			$big.find('img').css({
				left:-3*le,//同时都放大三倍
				top:-3*top//同时都放大三倍
			});
		});
		$move_cross.show();
	},function(){
		$slider.find('li img').stop().animate({
			opacity:1
		},300);
		$move_cross.hide().off('mousemove');
		$big.fadeOut(300);
	})
//微调控件
	$('.score').spinner();
	//加入购物车
	$('#product-buy .add-cart').click(function(event) {
		if(!user){

				$('#dialog-login').dialog('open').onScreen(99);
				event.preventDefault();
	
		}else{
			var $btn=$(this);
			var num= parseInt($('#product-buy-num').val());
			$.ajax({
				url: 'insertIntoCart',
				type: 'GET',
				data: {vegetableMount:num,vegetableID:$('#vegetable-id').val()},
				beforeSend:function(){
					
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在加入购物车....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success:function(response){
					if(/^true$/.test(response)){
						$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp;加入购物车成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
						var $num=$('.center-item .buy-car>a>strong');
						$num.html(parseInt($num.html())+1);
						if(parseInt($num.html())>0){
							var $drop=$('.buy-car-tip');
							$drop.html('您的购物车里有<strong>'+$num.html()+'</strong>件商品，<a href=\"findAllCart.action\">去看看</a>！');
						}
						setTimeout(function(){
							$('.loading').dialog('close');
							$(window).offScreen();

						},2000)
					}
				}
			})
			event.preventDefault();
		}
	});
	//选项卡
	$('#detail-and-comment').tabs();
	//图片延迟加载
	$('#product-detail img').delayImg();



//评论分页
	var ojson=null;
	$.ajax({
			url: 'getCommentsByVegetableId',
			type: 'GET',
			dataType: 'json',
			data:{vegetableId:/vegetableId=(\w+)/i.exec(window.location.search)[1]},
			success:function(req){
				ojson=req;
				
				if(ojson.length==0){
					$('.comment-is-empty').show();
					$('.comment-not-empty').hide();
				}else{
					$.paging(ojson,1,5,$('#product-comment .pagination'),$('.product-comment-wrapper ul'),'vegCommentChange',vegCommentCallback)
				}
			}
		});

	
	function vegCommentCallback(oeach){
		var str='',
		scrore=oeach.commentScore,
		star='';
		for(i=1;i<=5;i++){
			if(i<=scrore){
				star+='&#xe033;';
			}else{
				if(i-scrore<1){
					star+='&#xe032;';
				}else{
					star+='&#xe031;';
				}
			}
		}
		str+="<li><div class=\"product-comment-flag\"></div><div class=\"product-comment-box\"><div><h4>&#xe065;&nbsp;&nbsp;<em class=\"product-comment-name\">";
		str+=oeach.commentUser;
		str+="</em>&nbsp;&nbsp;&nbsp;[<em class=\"product-comment-time\">"+oeach.commentDate+"</em>]<div class=\"product-comment-stars\">";
		str+=star+"<em>"+scrore.toFixed(1)+"分</em></div></h4><p class=\"product-comment-content\">";
		str+=oeach.commentInfo+"</p></div></div></li>"
		return str;
	}
	window.vegCommentChange=function(num){
			
			$.paging(ojson,num,5,$('#product-comment .pagination'),$('.product-comment-wrapper ul'),'vegCommentChange',vegCommentCallback);
			$('body,html').animate({scrollTop:'600px'}, 400);
	}






















});