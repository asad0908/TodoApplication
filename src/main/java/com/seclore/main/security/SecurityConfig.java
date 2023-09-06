package com.seclore.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	public SecurityConfig() {
		System.out.println("Security config class created!");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//		 http
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and();

		
		 http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/user/**")
			.permitAll()
//			.anyRequest()
//			.authenticated()
			.and()
			.sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
////		
		return http.build();
	}
	
//	@Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/api/user/*", "/view", "/view/login", "/view/signup");
//    }
//	
//	@Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = new User("user", "pwd", new ArrayList<GrantedAuthority>());
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        return users;
//    }

}
