function makeButtonEvent(target, action, callback){
	document.querySelector(target).addEventListenr(action, callback, false);
} 