$(function(){
	//广告轮播
	var user=$(document.body).data('user');
	var slider_index = 1;
	var slitimer = setInterval(slifun, 4000);
	/*手动*/
	$('.control li').hover(function() {
		$(this).addClass('control-hover');
	}, function() {
		$(this).removeClass('control-hover');
	}).click(function(event) {
		if (!$(this).hasClass('control-selected')){
			clearInterval(slitimer);
			var this_index = $('.control li').index(this);
			$('.control li').removeClass('control-selected');
			$(this).addClass('control-selected');
			Change(this_index, preSliderIndex(slider_index));
			slider_index = nextSliderIndex(this_index);
			slitimer = setInterval(slifun, 4000);
		}
	});
	/*自动*/
	function slifun() {
		$('.control li').removeClass('control-selected').eq(slider_index).addClass('control-selected');
		Change(slider_index, preSliderIndex(slider_index))
		slider_index = nextSliderIndex(slider_index);
	}

	function Change(index, prv) {
		$('.slider li').eq(index).css('top','-100%').animate({top:'0%'},250);
		$('.slider li').eq(prv).animate({top:'100%'},250);
	}

	function nextSliderIndex(index) {
		return index + 1 >= $('.slider li').size() ? 0 : index + 1;
	};

	function preSliderIndex(index) {
		return index - 1 <= -1 ? $('.slider li').size() - 1 : index - 1;
	}
	/*瀑布流*/
	window.progress(waterflow)
	function waterflow(){
		var $pin=$('.pin'),
		min=3,
		lieshu=4,
		left=0,
		top=0,
		key=0;
		window.pin_width=$pin.outerWidth();
		window.pin_arr=new Array(lieshu);
		$.each($pin, function(index, val) {
			 if(index<lieshu){
			 	$(val).css('position','none');//必须设置这个，不然当resize的时候会乱
			 	pin_arr[index]=$(val).outerHeight();
			 }else{
			 	key=minPin(pin_arr);
			 	top=pin_arr[key];
			 	left=pin_width*key;
			 	pin_arr[key]+=$(val).outerHeight();
			 	$(val).css({
			 		position: 'absolute',
			 		top:top+'px',
			 		left:left+'px'
			 	})
			 }
		});
		$('.products-list-box').height(Math.max.apply(Math,pin_arr));
	}
	function minPin(arr){//取最矮列的下标
			var min=Math.min.apply(Math,arr),key=0;
			$.each(arr, function(index, val) {
				 if(val==min){
				 	key=index;
				 }
			});
			return key;
		}
	//添加到瀑布流
	function addFlow(obj){
		
		var str='';
		str+="<div class=\"pin\"><div class=\"box\"><a href=\""+obj.src+"\" class=\"product-info-photo\"><img src=\""+obj.vegetablePicAddr+"\" /></a>";
		str+="<div class=\"product-info\"><div class=\"zhedang\"><div class=\"zhedang-left\"></div><div class=\"zhedang-center\"></div><div class=\"zhedang-right\"></div></div><div class=\"product-info-price\">￥"+obj.vegetableNowPrice+"</div>";
		str+="<a href=\""+obj.src+"\" class=\"product-info-name\">"+obj.vegetableName+"</a><div class=\"product-info-hassaled\">销量：<strong>"+obj.vegetableSaleCount+"份</strong></div>";
		str+="<form action=\"\" class=\"product-info-buy\" name=\"product-info-buy\"><input type=\"hidden\" class=\"vegetable-id\" value=\""+obj.vegetableID+"\"><input type=\"text\" name=\"product-info-num\" class=\"product-info-num\" min=\"1\" max=\"100\" /><button name=\"product-info-submit\" class=\"product-info-submit\">加入购物车</button></form></div></div></div>";
		var $pin=$('.products-list-box').append(str).find('.pin:last');
		
		//定位
		var key=minPin(pin_arr);
		var top=pin_arr[key];
		var left=pin_width*key;
		pin_arr[key]+=$pin.outerHeight();
		$pin.css({
			position: 'absolute',
			top:top+'px',
			left:left+'px'
		});
		//加上couter
		$pin.find('.product-info-num').counter();
		//加上button
		$pin.find('.product-info-submit').button({
			icons: {
				primary: ' ui-icon-cart ' 
			}
		}).click(cartSubmit);;
	}
	//下拉加载
	if(!document.getElementById('veg-is-empty')){
		$(window).scroll(function(event) {
			var s_t=document.documentElement.scrollTop||document.body.scrollTop,
				c_h=typeof window.innerHeight=='number'?window.innerHeight:document.documentElement.clientHeight,
				list_bottom=$('.products-list-box').offset().top+$('.products-list-box').innerHeight(),
				$loading=$('.inner_pic_loading');
				if(s_t+c_h>list_bottom&&$loading.css('display')!='block'&&$('body').data('discountlast')!=true&&$('body').data('discountlast')!="true"){
					$loading.fadeIn(1000);
					setTimeout(function(){
						$.ajax({
							url: 'findDiscountVegetablesFlow',
							type: 'GET',
							dataType: 'json',
							data: {},
							success:function(req){
								var json=req.data,
									flag=0,
									len=req.data.length;
								if(/^true$/.test(req.discountisLast)){
									$('body').data('discountlast','true');
								}
								$.each(json, function(index, val) {
									
									var img=new Image();
									//图片加载成功
									$(img).load(function() {
										flag++
										if(flag==len){
											$.each(json, function(index, val) {
												addFlow(val)
											})
											$('.products-list-box').height(Math.max.apply(Math,pin_arr));
											$loading.hide();
										}
									//图片加载失败
									}).error(function() {
										flag++
										if(flag==len){
											$.each(json, function(index, val) {
												addFlow(val)
											})
											$('.products-list-box').height(Math.max.apply(Math,pin_arr));
											$loading.hide();
										}
									});
									img.src=val.vegetablePicAddr;
								});
							}
						});

					},1000);
					
				}
		});
	}


	//计数器
	$('.product-info-num').counter();

	//加入购物车
	//加入购物车
	$('.product-info-submit').button({
		icons: {
			primary: ' ui-icon-cart ' 
		}
	}).click(cartSubmit);
	
function cartSubmit(event) {
		
		if(!user){

				$('#dialog-login').dialog('open').onScreen(99);
				event.preventDefault();
	
		}else{
			var $btn=$(this);
			var num= parseInt($btn.parent().find('.product-info-num').val());
			$.ajax({
				url: 'insertIntoCart',
				type: 'GET',
				data: {vegetableMount:num,vegetableID:$btn.parent().find('.vegetable-id').val()},
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
	
		
	}

});