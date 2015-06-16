define(function(require,exports,module){
	var ojsonAll=null;
	var ojson=[];
	
	$.ajax({
		url: 'findBook',
		type: 'get',
		dataType: 'json',
		success:function(rq){
			ojsonAll=rq;
			$.each(ojsonAll, function(index, val) {
				 ojson.push(val);
			});
			if(ojson.length==0){
				$('.order-is-empty').show();
				$('.order-not-empty').hide();
			}else{
			$.paging(ojson,1,5,$('#myorder .pagination'),$('#order-tbody'),'centerOrderChange',centerOrderCallback);
			}
		}
	});
	function centerOrderCallback(oeach){
		var str='',
			price=parseFloat(oeach.bookVegetablePrice).toFixed(2),
			confirm='',
			operate='',
			btnPay="<div class=\"user-order-operate-pay\"><a href=\"#\">&#xe014; 付款</a></div>",
			btnComment="<div class=\"user-order-operate-comment\"><a class=\"comment-button\" href=\"javascript:void(0)\">&#xe065; 评价</a></div>",
			btnDelete="<div class=\"user-order-operate-delete\"><a href=\"javascript:void(0)\">&#xe019; 删除</a></div>";
			switch(parseInt(oeach.isConfirm)){
				case 0:confirm="未付款";operate=btnPay+btnDelete;
				break;
				case 1:confirm="未确认";operate=btnDelete;
				break;
				case 2:confirm="未评价";operate=btnComment+btnDelete;
				break;
				case 3:confirm="已完成";operate=btnDelete;
				break;
			}
			str+="<tr data-vegetableid=\""+oeach.bookId+"\"><td class=\"user-order-name\"><a href=\""+oeach.bookVegetableHref+"\" class=\"photo\"><img src=\""+oeach.bookVegetablePic+"\" alt=\"某某商品\"></a>";
			str+="<a href=\""+oeach.bookVegetableHref+"\" class=\"name\">"+oeach.bookVegetable+"</a></td><td class=\"user-order-num\"><strong>"+oeach.bookQuantity+"</strong>件</td><td class=\"user-order-price\">￥<strong>"+price+"</strong></td><td class=\"user-order-status\"><em>"+confirm+"</em></td>";
			str+="<td class=\"user-order-operate\">"+operate+"</td></tr>";
		return str;
	}
	window.centerOrderChange=function(num){
			
			$.paging(ojson,num,5,$('#myorder .pagination'),$('#order-tbody'),'centerOrderChange',centerOrderCallback);
			$('body,html').animate({scrollTop:'0px'}, 400);
	}

	//注册状态改变函数
	window.changeStatus=function(num){
		//初始化
		var $a=$('.status>li>a'),
		$li=$('.status>li');
		$li.removeClass('selected');
		$li.eq(num).addClass('selected');
		$a.attr('href',function(index,attr){
			return 'javascript:changeStatus('+index+')';
		});
		$a.eq(num).attr('href', 'javascript:void(0)');
		//操作ojson
		if(num==0){
			$.each(ojsonAll, function(index, val) {
				 ojson.push(val);
			});
		}else{
			ojson.length=0;//删除所有元素
			$.each(ojsonAll, function(index, obj) {
				console.log(obj.isConfirm==num-1)
				if(obj.isConfirm==num-1){
					ojson.push(obj);
				}
			});
		}
		$.paging(ojson,1,5,$('#myorder .pagination'),$('#order-tbody'),'centerOrderChange',centerOrderCallback);
		
	}
















})