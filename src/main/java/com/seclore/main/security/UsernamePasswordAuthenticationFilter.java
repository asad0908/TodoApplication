package com.seclore.main.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seclore.main.domain.User;
import com.seclore.main.domain.UserTodoMapping;
import com.seclore.main.service.UserTodoMapping.UserTodoMappingService;

public class UsernamePasswordAuthenticationFilter{} 


/*
 extends OncePerRequestFilter {
 
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private UserTodoAuthenticationProvider authenticationProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if(request.getServletPath().equals("/api/user/login") 
				&& HttpMethod.POST.matches(request.getMethod())) {
			User user = objectMapper.readValue(request.getInputStream(), User.class);
			try {
				SecurityContextHolder.getContext().setAuthentication(authenticationProvider.authenticateUser())
			}
		}
	}


}

 */