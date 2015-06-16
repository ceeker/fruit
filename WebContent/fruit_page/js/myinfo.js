define(function(require,exports,module){
		require('./hide.js').hide($('.info-alter-pass'));


		$('#info-alter-box').dialog({
		/*对话框标题*/
		title: '设置个人信息',
		/*在对话框添加按钮，值所对应的函数是点击按钮所运行的函数，this表示对话框写内容的div元素*/
		buttons: {
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
	$('#info-alter-box').keydown(function(event) {
		if(event.keyCode==13){
			event.preventDefault();
		}
	});
	//修改邮箱
	openDialog($('.info-alter-email'),'新邮箱地址：','email',function(){
		var val=$('#alter-input').val();
		if(!/^[\w\.\-]+@[\w\-]+(\.[a-zA-Z]{2,4}){1,2}$/.test(val)){
			$('#info-alter-error').html('请输入正确的邮箱地址！')
		}else{
			$('#info-alter-error').html('')
			$.ajax({
				url: 'updateMail',
				type: 'POST',
				dataType: 'html',
				data: {"userMail": val},
				beforeSend:function(){
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在保存设置....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success:function(rq){
					if (/^true$/.test(rq)) {
						$('#now-user-email').html(val);
						$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp;重置成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
							$('#info-alter-box').dialog('close').offScreen()
						}, 1000)
					}else if(/^had$/.test(rq)){
						$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;邮箱已存在！</span>').removeClass('registing regsuccess').addClass('regwrong');
							setTimeout(function() {
								$('.loading').dialog('close').offScreen();
								$('#info-alter-box').dialog('close').offScreen()
							}, 1000)
					}else{
						$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;设置失败！</span>').removeClass('registing regsuccess').addClass('regwrong');
							setTimeout(function() {
								$('.loading').dialog('close').offScreen();
								$('#info-alter-box').dialog('close').offScreen()
							}, 1000)
					}
				}
			})
			
		}
	})
	//设置电话
	openDialog($('.info-alter-tel'),'设置联系电话：','tel',function(){
		var val=$('#alter-input').val();
		if(!/^\d{11}$/.test(val)){
			$('#info-alter-error').html('请输入正确的手机号码！')
		}else{
			$('#info-alter-error').html('')
			$.ajax({
				url: 'updatePhone',
				type: 'POST',
				dataType: 'html',
				data: {"userPhone": val},
				beforeSend:function(){
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在保存设置....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success:function(rq){
					if (/^true$/.test(rq)) {
						$('#now-user-tel').html(val);
						$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp;重置成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
							$('#info-alter-box').dialog('close').offScreen()
						}, 1000)
					}else{
					$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;设置失败！</span>').removeClass('registing regsuccess').addClass('regwrong');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
							$('#info-alter-box').dialog('close').offScreen()
						}, 1000)
					}
				}
			})
			
		}
	})
	//设置地址
	openDialog($('.info-alter-address'),'设置联系地址','address',function(){
		var val=$('#alter-input').val();
		if(/^\s*$/.test(val)){
			$('#info-alter-error').html('地址设置不能为空！')
		}else{
			$('#info-alter-error').html('')
			$.ajax({
				url: 'updateAddr',
				type: 'POST',
				dataType: 'html',
				data: {"userAddr": val},
				beforeSend:function(){
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在保存设置....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success:function(rq){
					
					if (/^true$/.test(rq)) {
						$('#now-user-addr').html(val);
						$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp;重置成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
							$('#info-alter-box').dialog('close').offScreen()
						}, 1000)
					}else{
					$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;设置失败！</span>').removeClass('registing regsuccess').addClass('regwrong');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
							$('#info-alter-box').dialog('close').offScreen()
						}, 1000)
					}
				}
			})
			
		}
	})	
	function openDialog($el,label,name,fun){
		var $box=$('#info-alter-box')
		$el.click(function(event) {
			$box.get(0).reset();
			$box.find('label').html(label);
			$('#info-alter-error').html('')
			$box.find('input').attr({
				name:name
			})
			$box.dialog('option','buttons',{
				'保存设置':fun
				})
			$box.onScreen(98).dialog('open');
			
			})
	}





}) 