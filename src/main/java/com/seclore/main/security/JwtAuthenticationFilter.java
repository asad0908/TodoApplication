package com.seclore.main.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	public JwtAuthenticationFilter() {
		System.out.println("JWT Filter called!");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String authHeader = request.getHeader("Authorization");
//		if(authHeader==null || authHeader.startsWith("Bearer ") == false) {
//			filterChain.doFilter(request, response);
//			return;
//		}
		
		System.out.println("Request");
		System.out.println(request);
		
		doFilter(request, response, filterChain);
		
	}

}
