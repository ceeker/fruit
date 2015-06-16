define(function(require,exports,module){
	exports.hide=function($oA,$oDiv){
		$oA.click(function(event) {
			var hash=$(this).data('hash');
			var pre_hash=window.location.hash.substring(1)||'myinfo';
			if(hash!=pre_hash){
				window.hashFlag=false;
				switch(hash){
					case "myinfo":require('./myinfoOut.js').init(pre_hash,hash);
					break;
					case "myorder":require('./myorderOut.js').init(pre_hash,hash);
					break;
					case "mycomment":require('./mycommentOut.js').init(pre_hash,hash);
					break;
					case "mypass":require('./mypassOut.js').init(pre_hash,hash);
					break;
				}
		}
			
		});
	}
})