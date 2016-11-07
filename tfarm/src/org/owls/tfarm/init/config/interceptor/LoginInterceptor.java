// 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 미사용 
package org.owls.tfarm.init.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// http://hellogk.tistory.com/90 참조
// 대략 될 듯 하지만 Interceptor 등록 안되어 있음 >> 생각해보니 filter 를 사용하는 게 맞을 것 같아서 
// org.owls.tfarm.init.config.filter.UserFilter 로 변경함 
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object model) throws Exception {
		//check login session 
		System.out.println("Entered into LoginInterceptor");
		Object isLogin = request.getSession().getAttribute("login");
		boolean login = (isLogin ==  null) ? false : (boolean) isLogin;
		System.out.println("Current User login flag :: " + login);
		if(login){
			return true;
		} else {
			response.sendRedirect("redirect:/");
		}
		System.out.println("LoginInterceptor action done");
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object model, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object model, ModelAndView arg3)
			throws Exception {
	}
};