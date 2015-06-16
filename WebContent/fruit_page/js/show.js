define(function(require,exports,module){
	exports.show=function(){
		//查看哈希值是谁，谁出场
		var hash=window.location.hash.substring(1)||'myinfo';
		switch(hash){
			case "myinfo":showAnimate("myinfo")
			break;
			case "myorder":showAnimate("myorder")
			break;
			case "mycomment":showAnimate("mycomment")
			break;
			case "mypass":showAnimate("mypass");
			break;
		}
		function showAnimate(id){
			$('#'+id).show().animate({
					left:0,
					opacity:1					
				},
				500, function() {
					$('#'+id).css({
						position:'static',
					})
					window.hashFlag=true;
				});
		}
	}

})