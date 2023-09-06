package com.seclore.main.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Security filter chain called");

		http
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers("/api/user/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		    .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .httpBasic();
		return http.build();
	}



}
