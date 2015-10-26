package com.funoverflowwebservices.services.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.funoverflowwebservices.common.core.interceptor.AbstractInterceptor;

public class AccessGrantInterceptor extends AbstractInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
          // This can be implemented during auth
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {		
		// This can be implemented during auth
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {		
		//final String oAuthIdentifier="a6a5a5s5";//place holder for oauth. need to implement during authentication
		return true;
	}

}
