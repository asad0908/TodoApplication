package com.seclore.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * The SecurityConfig class is a configuration class responsible for setting up security configurations
 * for the application. It uses Spring Security annotations to configure web security.
 *
 * @Configuration Indicates that this class is a configuration class that provides bean definitions
 *               and application context configuration.
 * @EnableWebSecurity Enables Spring Security for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public SecurityConfig() {
		System.out.println("Security config class created!");
	}

	/**
     * Defines a security filter chain for handling HTTP security configurations.
     *
     * @param http The HttpSecurity object used to configure security settings.
     * @return A SecurityFilterChain instance that defines the security configuration for the application.
     * @throws Exception If there is an error while configuring security settings.
     */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Security filter chain called");

		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}

}

/*
 * extends OncePerRequestFilter {
 * 
 * @Autowired private ObjectMapper objectMapper;
 * 
 * @Autowired private UserTodoAuthenticationProvider authenticationProvider;
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException {
 * 
 * if(request.getServletPath().equals("/api/user/login") &&
 * HttpMethod.POST.matches(request.getMethod())) { User user =
 * objectMapper.readValue(request.getInputStream(), User.class); try {
 * SecurityContextHolder.getContext().setAuthentication(authenticationProvider.
 * authenticateUser()) } } }
 * 
 * 
 * }
 * 
 */
