package org.ict.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler{
	
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.error("커스텀 거부 핸들러 실행");
		log.error("/accessError페이지로 리다이렉트");
		
		res.sendRedirect("/accessError");
		
	}

}