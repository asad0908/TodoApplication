package com.seclore.todoapplication.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seclore.todoapplication.exception.CAuthenticationException;
import com.seclore.todoapplication.model.ErrorDTO;
import com.seclore.todoapplication.service.UserTodoMapping.UserTodoMappingServiceInterface;

/**
 * The JwtAuthenticationFilter class is a Spring component that extends OncePerRequestFilter
 * and is responsible for authenticating incoming requests based on JWT (JSON Web Token) tokens.
 * It performs token validation and user authorization checks for specific endpoints.
 *
 * @Component Indicates that this class is a Spring component and should be automatically discovered and registered.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	/**
     * The JWTUtil instance used for JWT token validation and extraction of user information.
     */
	@Autowired
	private JWTUtil jwtUtil;
	
	/**
     * The UserTodoMappingServiceInterface instance used for checking user-todo mappings for specific endpoints.
     */
	@Autowired
	private UserTodoMappingServiceInterface userTodoMappingService;
	
	@Autowired
	private ObjectMapper objectMapper;

	public JwtAuthenticationFilter() {
		System.out.println("JWT Filter called!");
	}

	/**
     * Perform the JWT token authentication and user authorization checks for incoming requests.
     * Skips authentication & authorization for views, .css, .js files, and user signup/login APIs
     *
     * @param request     The incoming HTTP request.
     * @param response    The HTTP response to be generated.
     * @param filterChain The filter chain for processing the request.
     * @throws ServletException         If there is a servlet-related error.
     * @throws IOException              If there is an I/O-related error.
     * @throws CAuthenticationException If authentication fails.
     */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException, CAuthenticationException{

		String servletPath = request.getServletPath();
		System.out.println("Servlet path: " + servletPath);

		if (servletPath.contains(".css") 
				|| servletPath.contains(".js") 
				|| servletPath.contains("api/user") 
				|| servletPath.contains("/view")) {
			
			filterChain.doFilter(request, response);
			return;
		}

		String authHeader = request.getHeader("Authorization");
		
		if (authHeader == null) {
			//throw new CAuthenticationException("Token not found!");
			sendAuthorizationError(response, "Token not found!");
//			response.sendError(401, );
			return;
		}

		String[] authElements = authHeader.split(" ");
		System.out.println("Auth headers: " + authHeader);
		if (authElements.length != 2 || authElements[0].equals("Bearer") == false) {
			//throw new CAuthenticationException("Token is in invalid format!");
//			response.sendError(401, "Token is in invalid format!");
			sendAuthorizationError(response, "Token is in invalid format!");
			return;
		}

		try {
			int userId = jwtUtil.validateTokenAndGetUserId(authElements[1]);
			request.setAttribute("userId", userId);
		} catch (Exception e) {
			//throw new CAuthenticationException("Invalid/Expired token\n" + e.getMessage());
//			response.
			sendAuthorizationError(response, "Invalid/Expired token\n" + e.getMessage());
//			response.sendError(401, "Invalid/Expired token\n" + e.getMessage());
			return;
		}

		String[] args = servletPath.split("/");
		if (args.length == 4 && args[1].equals("api")) {
			// for specific id
			String todoId = args[3];
			Integer userId = (Integer) request.getAttribute("userId");
			boolean success = userTodoMappingService.checkUserTodoMapping(userId.toString(), todoId);
			if (success == false) {
				sendAuthorizationError(response, "Unauthorized operation token\n");
				// throw new CAuthenticationException("Unauthorized operation token\n");
//				response.sendError(401, "Unauthorized operation token\n");
				return;
			}

		}

		filterChain.doFilter(request, response);

	}
	
	
	private void sendAuthorizationError(HttpServletResponse response, String message) {
		String json;
		try {
			json = objectMapper.writeValueAsString(new ErrorDTO(HttpStatus.UNAUTHORIZED, message));
			response.getWriter().write(json);
			response.setContentType("application/json");
		} catch (IOException e) {
			System.out.println("Error in creating JSON");
			e.printStackTrace();
		}
	}

}
