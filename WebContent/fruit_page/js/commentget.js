define(function(require,exports,module){
	var ojson=null;
	$.ajax({
		url: 'getCommentsByUserId',
		type: 'get',
		dataType: 'json',
		success:function(rq){
			
			ojson=rq;
			if(ojson.length==0){
				$('.comment-is-empty').show();
				$('.comment-not-empty').hide();
			}else{
			$.paging(ojson,1,5,$('#mycomment .pagination'),$('#mycomment .comment-wrapper'),'centerCommentChange',centerCommentCallback)
			}
		}
	});
	function centerCommentCallback(oeach){
		var str='',
		scrore=parseFloat(oeach.commentScore),
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
		str+="<li class=\"comment-item\"><div class=\"comment-header\"><div class=\"comment-item-product-name\"><span></span><strong>";
		str+=oeach.commentVeg;
		str+="</strong></div><p class=\"comment-item-stars\"><strong>"+star+"</strong><em>";
		str+=scrore.toFixed(1);
		str+="分</em></p></div><p class=\"comment-item-content\">";
		str+=oeach.commentInfo;
		str+="</p><p class=\"comment-item-time\">"+oeach.commentDate+"</p></li>";
		return str;
	}
	window.centerCommentChange=function(num){
			$.paging(ojson,num,5,$('#mycomment .pagination'),$('#mycomment .comment-wrapper'),'centerCommentChange',centerCommentCallback);
			$('body,html').animate({scrollTop:'0px'}, 400);
	}



})