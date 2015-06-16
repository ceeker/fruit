define(function(require,exports,module){

	exports.init=function(){

		/*提示工具*/
		$('.alter-pass-text').tooltip({
			position: {
				my: 'left bottom',
				at: 'right+5 bottom'
			},
			tooltipClass: 'register-tooltip',
			show: false,
			hide: false
		});
		$('#alter-pass')
		.validate({ //验证表单
			//使用其他方式代替默认提交
			submitHandler: function(form1) { //这里的参数代表#test表单			
			//验证成功后执行，且阻止了默认提交
			//一般用于ajax提交
			$(form1).ajaxSubmit({
				url: 'userUpdatePassword',
				type: 'POST',
				beforeSubmit: function(formData, jqForm, options) { //formData表单内容数组，jqForm得到form 的jquery 对象，option是当前设置的属性
					$('.loading').html('<img src="img/loading.gif" alt="loading"><span>&nbsp;&nbsp;正在修改....</span>').dialog('widget').children(':eq(0)').hide().end().end().removeClass('regsuccess regwrong').addClass('registing').onScreen(101).dialog('open');
				},
				success: function(responseText, statusText) {
					if (/^true$/.test(responseText)) {
						$('.loading').html('<img src="img/success.gif" alt="成功"><span>&nbsp;&nbsp;修改成功....</span>').removeClass('registing regwrong').addClass('regsuccess');
						$('#alter-pass').get(0).reset();
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
						}, 1000)
					} else if(/^passwrong$/){
						$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;原始密码错误！</span>').removeClass('registing regsuccess').addClass('regwrong');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
						}, 1000)
					}else{
						$('.loading').html('<img src="img/error.png" alt="失败"><span>&nbsp;&nbsp;修改失败！</span>').removeClass('registing regsuccess').addClass('regwrong');
						setTimeout(function() {
							$('.loading').dialog('close').offScreen();
						}, 1000)
					}
				},
				error : function (event, errorText, errorType) { //错误时调用
					alert(errorText + errorType);
				}
			});
		},
			//指定label放的位置
			errorLabelContainer: 'ol.alter-error',
			//在label上包裹一层元素
			wrapper: 'li',
			//高亮显示有错误的元素
			highlight: function(element, errorClass) { //element是出错误的元素
				$(element).next('span').removeClass('input-success');
			},
			unhighlight: function(element, errorClass) { //element是出错误的元素
				$(element).next('span').addClass('input-success');
			},
			rules: {
				prepass: {
					required: true,
					minlength: 6,
				/*	remote : {
						url : 'user.php',
						type:'post',
						data:{
							user:function(){return $('#register-user').val()}
						}
					}*/
				},
				newpass: {
					required: true,
					minlength: 6
				},
				'pass-con': {
					required: true,
					equalTo:"#alter-new-pass"
				}
			},
			messages: {
				prepass: {
					required: '原始密码不能为空！',
					minlength: '账号不能小于{0}位！',
					/*remote:'此用户名存在，请重新注册！'*/
				},
				newpass: {
					required: '新密码不能为空！',
					minlength: '密码不能小于{0}位！'
				},
				'pass-con': {
					required: '确认密码不能为空！',
					equalTo:'两次填写密码不一致，请重新填写！'
				}
			}
		});
	}



})