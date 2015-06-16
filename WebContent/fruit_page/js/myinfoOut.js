define(function(require,exports,module){
	exports.init=function(pre_hash,hash){
		var $pre=$('#'+pre_hash);
		$pre.css('position','absolute')
		.animate({
			left:'1000px',
			opacity:0					
		},
		500, function() {
			$pre.hide();
			window.location.hash=hash;
			require('./show.js').show();
		});
	}
})