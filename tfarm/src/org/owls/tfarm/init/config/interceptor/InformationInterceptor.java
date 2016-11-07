package org.owls.tfarm.init.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owls.tfarm.utils.http.HttpRequestInspector;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InformationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpRequestInspector.printHttpInfo(request, HttpRequestInspector.PARAM);
		
		//get ServletContext get SessionManagerBean, Validate user
		
		
		return super.preHandle(request, response, handler);
	}
};