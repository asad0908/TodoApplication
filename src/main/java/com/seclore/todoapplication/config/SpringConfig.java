package com.seclore.todoapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seclore.todoapplication.security.AuthorizationInterceptor;

@Configuration
//@ComponentScan("com.seclore.todoapplication")
public class SpringConfig implements WebMvcConfigurer{
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		System.out.println("View resolver called!");
		return viewResolver;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public AuthorizationInterceptor authorizationInterceptorInit() {
	    return new AuthorizationInterceptor();
	}

	public @Override void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(authorizationInterceptorInit());
	}
}