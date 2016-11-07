package org.owls.tfarm.utils.http;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestInspector {
	public static final String PARAM = "parameter";
	public static final String HEADER = "header";
	public static final String ATTR = "attribute";
	public static final String ALL = "all";
	
	public static void printHttpInfo(HttpServletRequest request) throws Exception {
		printHttpInfo(request, "params");
	}
	
	private static void printHeader(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String key = String.valueOf(headers.nextElement());
			String value = String.valueOf(request.getHeader(key));
			System.out.println("HEADER [key] : " + key + " [ value ] : " + value);
		}
	}
	
	
	private static void printParameters(HttpServletRequest request) {
		Map<String, String[]> paramMap = request.getParameterMap();
		Iterator<String> paramIter = paramMap.keySet().iterator();
		while(paramIter.hasNext()) {
			String key = String.valueOf(paramIter.next());
			String value = String.valueOf(paramMap.get(key)[0]);
			System.out.println("PARAMETER [key] : " + key + " [ value ] : " + value);
		}
	}
	
	private static void printAttributes(HttpServletRequest request) {
		Enumeration<String> attributes = request.getAttributeNames();
		while(attributes.hasMoreElements()) {
			String key = String.valueOf(attributes.nextElement());
			String value = String.valueOf(request.getAttribute(key));
			System.out.println("ATTRIBUTES [key] : " + key + " [ value ] : " + value);
		}
	}
	
	public static Map<String, String> flatRequest(HttpServletRequest request) {
		Map<String, String[]> paramMap = request.getParameterMap();
		Map<String, String> rtn = new HashMap<String, String>();
		Iterator<String> paramIter = paramMap.keySet().iterator();
		while(paramIter.hasNext()) {
			String key = String.valueOf(paramIter.next());
			String value = String.valueOf(paramMap.get(key)[0]);
			rtn.put(key, value);
		}
		return rtn;
	}
	
	public static void printHttpInfo(HttpServletRequest request, String type) throws Exception {
		switch(type) {
			case PARAM :
				printParameters(request);
				break;
			case HEADER :
				printHeader(request);
				break;
			case ATTR :
				printAttributes(request);
				break;
			case ALL :
				printHeader(request);
				printAttributes(request);
				printParameters(request);
				break;
			default:
				throw new Exception("Undefined Header type");	
		}
	}
}
