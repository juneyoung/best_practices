//Ajax 통신
function ajax(url, data, callback, method){
	
	var httpRequest;
	var afterAction = function(){
		if(!httpRequest) {
			console.error('can not find httpRequest variable');
			return;
		}
		
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var responseData = httpRequest.responseText;
				alert(JSON.stringify(responseData));
				console.log('Result of API call >>>', responseData);
				if(typeof callback == 'function') {
					callback(JSON.parse(responseData));
				}
			} else {
				alert('There was a problem with the request.');
			}
	    }
	}
	
	if (window.XMLHttpRequest) { // Mozilla, Safari, IE7+ ...
	    httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE 6 and older
	    httpRequest = new ActiveXObject('Microsoft.XMLHTTP');
	}
	
	if(!method) method = 'POST';
	httpRequest.onreadystatechange = afterAction;
	httpRequest.open(method.toUpperCase(), url, true);
	httpRequest.send(null);
}