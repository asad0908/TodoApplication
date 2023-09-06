package com.seclore.main.security;

import java.io.IOException;
import java.net.http.HttpHeaders;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.Header;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private UserTodoAuthenticationProvider authenticationProvider;
	
	public JwtAuthenticationFilter() {
		System.out.println("JWT Filter called!");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		if(authHeader==null) {
			response.sendError(0, "Token not found!");
			return;
		}
			
		String[] authElements = authHeader.split(" ");
		if(authElements.length!=2 || authElements[0].equals("Bearer")==false) {
			response.sendError(0, "Token is in invalid format!");
			return;
		}
			
		
		try {
			int userId = authenticationProvider.validateToken(authElements[1]);
			request.setAttribute("userId", userId);			
		}catch(Exception e) {
			response.sendError(0, "Invalid/Expired token\n"+e.getMessage());
			return;
		}

				
			
		
		System.out.println("Request");
		System.out.println(request);
		
		filterChain.doFilter(request, response);
		
	}

}
