define(function(require,exports,module){
	//进度条
	//进出场动画
	window.progress(function(){
		setTimeout(function(){
			require('./show.js').show();
		},400)
		
	})
	
	var $oA=$('.p-center-nav a');
	var $oDiv=$('.p-center-item>div');
	require('./hide.js').hide($oA,$oDiv);
	//当我们手动输入地址时按回车后，或者点击历史
	//前进后退按钮时想要显示到对应哈希页，我们就需要刷新,
	//用到onhashchange事件可以完成
	//但是我们点击菜单时我们走的是动画切换不需要刷新，我们就需要一个全局标示符
	window.hashFlag=true;
	$(window).on('hashchange',function(){
		if(window.hashFlag){
			this.location.reload();
		}
	})
	//个人信息接口
	require('./myinfo.js');
	//修改密码
	require('./alterpass.js').init();
	//获取评价
	require('./orderget.js');
	//获取评论框接口
	var comment_box=require('./commentbox.js');
	//打开评论框
	$(document).on('click','.comment-button',function(){
		var $tr=$(this).parents('tr');
		var vegId=$tr.data('vegetableid');
		var src=$tr.find('.user-order-name img').attr('src');
		var name=$tr.find('.user-order-name .name').html();
		comment_box.openComment(vegId,src,name);
	})
	//获取评论
	require('./commentget.js');

})