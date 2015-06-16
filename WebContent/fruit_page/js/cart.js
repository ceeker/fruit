$(function(){
	window.progress(null)
		//计数组件
	$('.cart-list-num input').counter();
	//计算总和
	function singleTotal(nowprice_selector){
		$(nowprice_selector).each(function(index, el) {
			var total=parseFloat($(el).html().substring(1))*parseFloat($(el).parents('tr').find('.cart-list-num input').val())
			$(el).parents('tr').find('.cart-list-total>strong').html('￥'+total.toFixed(2))
		});
	}
	singleTotal('.cart-list-now>strong');
	//数量按钮触发计数
	$('.count-num-decrease,.count-num-increase').click(function(event) {
		singleTotal($(this).parents('tr').find('.cart-list-now>strong'));
		total();
	});
	//全选
	var $checkbox=$('.cart-list-check :checkbox'),
		$checked_all=$('.checked-all');
	$checkbox.change(function(event) {
		if (!$(this).get(0).checked) {
			$checked_all.get(0).checked=false;
		}
		total();
	});
	$checked_all.change(function(event) {
		if($(this).get(0).checked){
			$checkbox.each(function(index, el) {
				el.checked=true;
			});
		}else{
			$checkbox.each(function(index, el) {
				el.checked=false;
			});
		}
		total();
	});
	//运算总价格
	function total(){
		var total=0;
		var num=0;
		$('.cart-list-total>strong').each(function(index,el) {
			if($(el).parents('tr').find('.cart-list-check :checkbox').get(0).checked){
			total+=parseFloat(el.innerHTML.substring(1));
			num+=1;
			}
		});
		if(total>0){
			$('.cart-submit-total>strong').html('￥'+total.toFixed(2));
			$('#cart-submit').removeClass('disabled');
		}else{
			$('.cart-submit-total>strong').html('￥'+total.toFixed(2));
			$('#cart-submit').addClass('disabled');
		}
		$('.cart-submit-total>em').html(num);
		return total;
	}
	total()
	//删除button
	$('.cart-list-operate input').button().click(function(event) {
		var _this=this;
		if(confirm('你确定要从购物车中删除此商品？')){
			$.ajax({
				url: 'deleteCart',
				type: 'post',
				dataType: 'html',
				data: {cartId:$(this).parents('tr').find('input[name=cartId]').val()},
				beforeSend:function(){
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在删除....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success:function(rq){
					if(/^true$/.test(rq)){
						$('.loading').dialog('close').offScreen();
						//从页面中删除商品
						var $num=$('.center-item .buy-car>a>strong');
						$num.html(parseInt($num.html())-1);
						$('drop buy-car-tip strong').html($num.html());
						var $tr=$(_this).off('click').parents('tr').remove();
						total();

					}else{
						$('.loading').dialog('close').offScreen();
						alert('删除商品失败！')
					}
				}	
			})
		}else{}
		
	});

	//把选择好的产品封装成Json
	function toJson(){
		var all_cart=[],
			cart_id="",
			num=0,
			$tr=null,
			$checked=$('.cart-list-check :checked');
			for(var i=0,len=$checked.size();i<len;i++){
				$tr=$checked.eq(i).parents('tr');
				cart_id=$tr.find('input[name=cartId]').val();
				num=$tr.find('.cart-list-num input[name=cartListNum]').val();
				all_cart.push({
					"cartID":cart_id,
					"count":num
				})
			}
			return JSON.stringify(all_cart);
	}
	//提交购物车
	$('#cart-submit').click(function(event) {
		if(total()>0){
			$.ajax({
				url: 'book',
				type: 'POST',
				dataType: 'html',
				data: {json:toJson()},
				beforeSend:function(){
					$('#cart-submit').get(0).disabled=true;
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在提交....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success:function(rq){
					$('.loading').dialog('close').offScreen();
					if(/^true$/.test(rq)){
						window.location.href='./configmenu.jsp';
					}else{
						alert('下单失败！')
					}

				}
			})
		}
	});
	



































})