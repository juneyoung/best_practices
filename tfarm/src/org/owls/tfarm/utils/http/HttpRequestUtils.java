package org.owls.tfarm.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtils {
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
	
	/**
	 * Read HttpServletRequest Payload
	 * >>> 테스트 못해봄 
	 * >>> http://stackoverflow.com/questions/14525982/getting-request-payload-from-post-request-in-java-servlet
	 * @return
	 * @throws IOException
	 */
	public static String getBody(HttpServletRequest request) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    BufferedReader br = null;
	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	        	br = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = br.read(charBuffer)) > 0) {
	            	sb.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	        	sb.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (br != null) {
	            try {
	            	br.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }
	    return sb.toString();
	}
};