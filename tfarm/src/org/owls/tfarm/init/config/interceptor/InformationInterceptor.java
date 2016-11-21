package org.owls.tfarm.init.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owls.tfarm.utils.http.HttpRequestUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InformationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 진입");
		HttpRequestUtils.printHttpInfo(request, HttpRequestUtils.PARAM);
		return super.preHandle(request, response, handler);
	}
};