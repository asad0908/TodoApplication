package com.seclore.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	@Autowired
	private JwtAuthenticationFilter jwtAuthFilter;

//	@Autowired
//    public void AuthenticationProvider(AuthenticationProvider authenticationProvider){
//        this.authenticationProvider=authenticationProvider;
//    }
	public SecurityConfig() {
		System.out.println("Security config class created!");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Security filter chain called");

		http
		.csrf()
			.disable()
		
//		.and()
		.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider)
//		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//		.and()
		.authorizeHttpRequests()
		.antMatchers("/api/user/**")
			.permitAll();
//		.anyRequest()
//			.authenticated()
//            .httpBasic();
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
