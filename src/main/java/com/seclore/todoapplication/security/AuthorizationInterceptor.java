package com.seclore.todoapplication.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.todoapplication.exception.CAuthenticationException;
import com.seclore.todoapplication.service.UserTodoMapping.UserTodoMappingServiceInterface;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

	/**
	 * The JWTUtil instance used for JWT token validation and extraction of user
	 * information.
	 */
	@Autowired
	private JWTUtil jwtUtil;// = new JWTUtil();

	/**
	 * The UserTodoMappingServiceInterface instance used for checking user-todo
	 * mappings for specific endpoints.
	 */
	@Autowired
	private UserTodoMappingServiceInterface userTodoMappingService;

	public AuthorizationInterceptor() {
		System.out.println("AuthorizationFilter constructor called ");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String servletPath = request.getServletPath();
		if (servletPath.startsWith("/api/todo")) {

			String authHeader = request.getHeader("Authorization");

			if (authHeader == null) {
				throw new CAuthenticationException("Token not found!");
			}

			String[] authElements = authHeader.split(" ");
			System.out.println("Auth headers: " + authHeader);
			if (authElements.length != 2 || authElements[0].equals("Bearer") == false) {
				throw new CAuthenticationException("Token is in invalid format!");
			}

			try {
				int userId = jwtUtil.validateTokenAndGetUserId(authElements[1]);
				request.setAttribute("userId", userId);
			} catch (Exception e) {
				throw new CAuthenticationException("Invalid/Expired token\n" + e.getMessage());
			}

			String[] args = servletPath.split("/");
			if (args.length == 4) {
				// for specific id
				String todoId = args[3];
				Integer userId = (Integer) request.getAttribute("userId");
				boolean success = userTodoMappingService.checkUserTodoMapping(userId.toString(), todoId);
				if (success == false) {
					throw new CAuthenticationException("Unauthorized operation token\n");
				}
			}
		}
		return true;
	}
}
