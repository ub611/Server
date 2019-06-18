package com.example.petMate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class SignInInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
		HttpSession session = request.getSession();
//		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		if (session.getAttribute("u_idx") == null) {
			String url = request.getRequestURL().toString(); 
			String query = request.getQueryString();
			ModelAndView modelAndView = new ModelAndView("SignInForm");
			
			if (query != null) {
				modelAndView.addObject("signinForwardAction", url+"?"+query);
			}
			
			else {
				modelAndView.addObject("signinForwardAction", url);
			}
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else {
			return true;
		}
	}

}
