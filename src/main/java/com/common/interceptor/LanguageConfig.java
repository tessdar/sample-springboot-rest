package com.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.common.util.MessageTrans;

@Component
public class LanguageConfig extends HandlerInterceptorAdapter {

	@Autowired
	private MessageTrans messageTrans;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getHeader("Language") == null) {
			messageTrans.setLang("ko");
		} else {
			messageTrans.setLang(request.getHeader("Language"));
		}

		return true;
	}

}
