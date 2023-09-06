package com.seclore.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	public SecurityConfig() {
		System.out.println("Security config class created!");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Security filter chain called");
//		
////		return http
////				.csrf().disable()
////	            .authorizeHttpRequests(authCustomizer -> authCustomizer
////	                .antMatchers(HttpMethod.POST, "/api/users/**").permitAll()
//////	                .requestMatchers("/api/logs/**").hasAuthority(AuthoritiesConstants.ADMIN)
////	                .antMatchers("/api/todo/**").authenticated()
////	            )
////	            .build();
//		
		http = http
				.csrf().disable()
////				.cors().and()
//				.csrf().disable()
////				.antMatcher("/api/user/**")
////				.
////				.authorizeRequests()
//				
////				.authorizeHttpRequests((auth) -> auth.anyRequest())
				.httpBasic(Customizer.withDefaults());
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
