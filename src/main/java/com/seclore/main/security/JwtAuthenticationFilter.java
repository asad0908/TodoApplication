package com.seclore.main.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.seclore.main.service.UserTodoMapping.UserTodoMappingServiceInterface;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserTodoMappingServiceInterface userTodoMappingService;
	
	public JwtAuthenticationFilter() {
		System.out.println("JWT Filter called!");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		System.out.println("Servlet path: " + servletPath);
		
		if(servletPath.contains(".css")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		if(servletPath.contains("api/user")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		if(servletPath.contains("/view")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String authHeader = request.getHeader("Authorization");
		if(authHeader==null) {
			response.sendError(401, "Token not found!");
			return;
		}
			
		String[] authElements = authHeader.split(" ");
		System.out.println("Auth headers: " + authHeader );
		if(authElements.length!=2 || authElements[0].equals("Bearer")==false) {
			response.sendError(401, "Token is in invalid format!");
			return;
		}
			
		
		try {
			int userId = jwtUtil.validateToken(authElements[1]);
			request.setAttribute("userId", userId);			
		}catch(Exception e) {
			response.sendError(401, "Invalid/Expired token\n"+e.getMessage());
			return;
		}

		String[] args = servletPath.split("/");
		System.out.println(args.length);
		if(args.length==4 && args[1].equals("api")) {
			//for specific id
			String todoId = args[3];
			Integer userId = (Integer) request.getAttribute("userId");
			boolean success = userTodoMappingService.checkUserTodoMapping(userId.toString() , todoId);
			System.out.println("Check called for: " + userId + " " + todoId + " " + success );
			if(success == false) {
				response.sendError(401, "Unauthorized operation token\n");
				return;
			}
			
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
