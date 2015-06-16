$(function(){
	window.progress(null)
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
		var this_index = $('.control li').index(this);
		clickfun(this_index);
		}
	});
	//鼠标放上停止
	var $toltor=$('.to-left,.to-right');
	$toltor.hover(function(){
		$(this).addClass('to-hover')
	},function(){
		$(this).removeClass('to-hover')
	});
	$('#slider-show').hover(function(){
		clearInterval(slitimer);
		slitimer=9999;
	},function(){
		slitimer = setInterval(slifun, 3000);
	});

	$('.to-left').click(toLeft);
	$('.to-right').click(toRight);
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
	/*左滚动*/
	function toLeft() {
		if ($('.slider li').queue().length == 0) {//只有在运动队列里没有函数时才调用
			var prv=preSliderIndex(preSliderIndex(slider_index));
			clickfun(prv);		
		}
	}
	/*右滚动*/
	function toRight() {
		if ($('.slider li').queue().length == 0) {
			slifun()
		}
	}
//特价产品
	$('.sale-product-photo').hover(function(){
		$(this).find('em').css('top','0');
	},function(){
		$(this).find('em').css('top','100%');
	})

//延迟加载
	$('.delay').delayImg();








	
})