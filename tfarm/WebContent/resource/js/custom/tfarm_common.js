var FormattedMessage = {
	absent_required : {
		ko : ' 필수값이 누락되었습니다'
		, en : ' Required field absent'
	}
	, system_fail : {
		ko : '시스템 장애가 발생하여 요청을 처리하지 못했습니다'
		, en : 'Your request has failed due to system failure'
	}
}

//Ajax 통신
function ajax(url, data, callback, method){
	//data is {"id":"system", "password" : "1234"}
	var httpRequest;
	var afterAction = function(){
		if(!httpRequest) {
			console.error('can not find httpRequest variable');
			return;
		}
		
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var responseData = httpRequest.responseText;
				//추후에 제거 요망 서버 쿼테이션 이스케이프 
				responseData = JSON.parse(responseData);
				console.log('Result of API call >>>', responseData);
				var responseObject = JSON.parse(responseData);
				
				if(typeof callback == 'function') {
					console.log('text >>> ', responseObject);
					callback(responseObject);
				}
			} else {
				alert('There was a problem with the request.');
			}
	    }
	}
	
	//=========== LOGIC ============
	if (window.XMLHttpRequest) { // Mozilla, Safari, IE7+ ...
	    httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE 6 and older
	    httpRequest = new ActiveXObject('Microsoft.XMLHTTP');
	}
	
	if(!method) method = 'POST';
	data = (!!data) ? JSON.stringify(data) : '';
	
	httpRequest.onreadystatechange = afterAction;
	httpRequest.open(method.toUpperCase(), url, true);
	httpRequest.setRequestHeader("Content-type", "application/json; charset=utf-8");
	//httpRequest.setRequestHeader("Content-length", data.length);	// Why do I need this?
	//httpRequest.setRequestHeader("Connection", "close");			// Why do I need this?
	httpRequest.send(data);
}

//Checking
//function requiredFulfilled(InputElement) {
//	var value = InputElement.value;	
//	return !!value && value.trim().length > 0 ;
//}

// If fail return false and alert
function formValueAsObject (FormElement, requeiredValidation, useFieldsetFilter) {
	var robj = {};
	var targetDomStructure = FormElement;
	if(useFieldsetFilter) {
		// select, textarea,  (file-maybe), input
		targetDomStructure = FormElement;
	}
	
	var targetInputs = targetDomStructure.querySelectorAll('input');
	var targetSelects = targetDomStructure.querySelectorAll('select');
	var targetTextareas = targetDomStructure.querySelectorAll('textarea');
	
	for(var i = 0; i < targetInputs.length; i++) {
		var singleElem = targetInputs[i];
		var key = singleElem.name;
		var value = singleElem.value;
		if(requeiredValidation && (!value || value.trim().length < 1 )){
			var displayKey = key;
			if(singleElem.hasAttribute('display-name')){
				displayKey = singleElem.getAttribute('display-name');
			}
			alert(displayKey + FormattedMessage.absent_required.ko);
			return false;
		}
		robj[key] = value;
	}
	

	for(var i = 0; i < targetSelects.length; i++) {
		var singleElem = targetSelects[i];
		var key = singleElem.name;
		var value = singleElem.value;
		if(requeiredValidation && (!value || value.trim().length < 1 )){
			var displayKey = key;
			if(singleElem.hasAttribute('display-name')){
				displayKey = singleElem.getAttribute('display-name');
			}
			alert(displayKey + FormattedMessage.absent_required.ko);
			return false;
		}
		robj[key] = value;
	}
	

	for(var i = 0; i < targetTextareas.length; i++) {
		var singleElem = targetTextareas[i];
		var key = singleElem.name;
		var value = singleElem.value;
		if(requeiredValidation && (!value || value.trim().length < 1 )){
			var displayKey = key;
			if(singleElem.hasAttribute('display-name')){
				displayKey = singleElem.getAttribute('display-name');
			}
			alert(displayKey + FormattedMessage.absent_required.ko);
			return false;
		}
		robj[key] = value;
	}
	return robj;
}