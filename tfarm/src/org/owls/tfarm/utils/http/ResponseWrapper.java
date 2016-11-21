package org.owls.tfarm.utils.http;

import java.util.Map;

//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseWrapper {
	//API 의 기본형식은 
	//result : 호출 결과  
	//message : 에러일 경우 ex.getMessage()
	
//	public static Map<String, Object> wrap (String data, boolean isSuccess, String message){
//		
//	}
	
//	public static Map<String, Object> wrap (JSON json, boolean isSuccess, String message){
//		ObjectMapper mapper = new ObjectMapper();
//		TypeReference<Map<String, Object>> type = new TypeReference<Map<String,Object>>() {};
//		Map<String, Object> map = mapper.readValue(json., type);
//	}

	public static Map<String, Object> wrap (Map<String, Object> data, boolean isSuccess, String message) {
		data.put("result", isSuccess ? "S" : "E");
		data.put("message", message);
		return data;
	}
}
