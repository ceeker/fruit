$(function(){
	window.progress(null);
	//评论内容输入
	var $comment_content=$('#comment-content');
	var $comment_tip=$('.comment-font-num');
	var empty=true;
	$comment_content.focus(function(){
		if(empty){
			$comment_tip.css('color','#91b944');
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
	})
	//评论框悬浮
	var $message=$('#messaging');
	$(window).scroll(messageScroll);
	$window.resize(messageScroll);
	function messageScroll(event) {
			var $content=$('#content');
			var left=$content.offset().left+$content.outerWidth()-354;
				if($(this).scrollTop()>=140){
					$message.css({
						'position':'fixed',
						'left':left,
						'top':'70px'
					})
				}else{
					$message.css({
						'position':'static'
					})
				}

		}








})

