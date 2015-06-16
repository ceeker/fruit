define(function(require,exports,module){
	var $commentForm=$('#comment-box');
	$commentForm.dialog({
		/*对话框标题*/
		title: '用户评论',
		/*在对话框添加按钮，值所对应的函数是点击按钮所运行的函数，this表示对话框写内容的div元素*/
		buttons: {
			'提交评论': function() {
				var $error=$('#comment-box-error');
				$error.html("");
				if($('#comment-score').val()==0){
					$error.html("请选择评价分数！");
				}
				if($('#comment-content').val()==""){
					$error.html(function(ind,html){
						return html+"评价内容不能为空！";
					});
				}
				if($error.html()==""){
					$.ajax({
						url: 'insertComment',
						type: 'GET',
						dataType: 'html',
						data:$commentForm.serialize(),
						beforeSend:function(){
							$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在提价评价....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
						},
						success:function(rq){
							if(/^true$/.test(rq)){
								$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp评价成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
								setTimeout(function() {
									$('.loading').dialog('close').offScreen();
									window.location.reload(true);
								}, 1000)
							}else{
								$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;评价失败！</span>').removeClass('registing regsuccess').addClass('regwrong');
								setTimeout(function() {
									$('.loading').dialog('close').offScreen();
								}, 1000)
							}
						}
					})
				}		
			}

		},
		width: 600,
		/*打开和关闭的动画效果*/
		show: false,
		hide: false,
		/*调用.dialog是否显示对话框，如果用于初始化对话框，可以现不现实，然后用.dialog('open')打开对话框*/
		autoOpen:false,
		/*可不可以退调整对话框大小*/
		resizable: false,
		/*改变关闭按钮提示*/
		closeText: '关闭',
		closeOnEscape: false, //按下esc 无效
		/*是否有遮罩*/
		modal: false
	});
	//评价五角星
	var $span=$('.comment-mark li>span');
	var score=0;
	$span.mouseover(scoreHover);
	$span.mousedown(function() {
		$('#comment-score').val(score);
		$span.off('mouseover',scoreHover)
	});
	$('.comment-mark ul').mouseleave(function() {
		var _score=parseFloat($('#comment-score').val());
		for (var i = 0; i <$span.size(); i++) {
			if(i<_score*2){
				$span.eq(i).css('backgroundImage','url(img/star.gif)')
			}else{
				$span.eq(i).css('backgroundImage','none')
			}
		}
		$('.comment-score').html(_score.toFixed(1)+'分')
		$span.mouseover(scoreHover);
	});
	function scoreHover() {
		var _score=0;
		var flag=true;
		for (var i = 0; i < $span.size(); i++) {
			if(flag){
				$span.eq(i).css('backgroundImage','url(img/star.gif)')
				_score+=0.5;
			}else{
				$span.eq(i).css('backgroundImage','none')
			}
			if($span.get(i)==this){
				flag=false;
			}
		}
		score=_score;
		$('.comment-score').html(_score.toFixed(1)+'分')
	}
	//打开对话框时，设置对话框
	exports.openComment=function(vegId,src,name){
		$commentForm.get(0).reset();
		$.each($span,function(ind,val){
			$(val).css('backgroundImage','none')
		});
		$('.comment-product-photo img').attr('src',src);
		$('.comment-product-name').html(name);
		$('.comment-score').html("0.0"+'分');
		$('#comment-vegID').val(vegId);
		$('#comment-score').val(0);
		$commentForm.onScreen(98).dialog('open');
	}
	//评论内容输入
	var $comment_content=$('#comment-content');
	var $comment_tip=$('.comment-font-num');
	var empty=true;
	$comment_content.focus(function(){
		if(empty){
			$comment_tip.css('color','#666');
			$comment_tip.html('您还可以输入<strong>400</strong>个字！')
			empty=false;
		}
	});
	$comment_content.blur(function(){
		if($comment_content.val()==""){
			$comment_tip.css('color','#f60');
			$comment_tip.html('您最多可以输入<strong>400</strong>个字！')
			empty=true;
		}
	})
	$comment_content.on('input',function(){
		var $strong=$('.comment-font-num strong');
		var val=$comment_content.val();
		var length=val.length; 
		if(length<=400){
			$strong.html(400-length)
		}else{
			$strong.html(0);
			$comment_content.val(val.substring(0,400))
		}
	});










})