package com.seclore.main.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	public CustomAuthenticationProvider(){
		System.out.println("CustomAuthenticationProvider constructor called!");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("Insider CustomAuthenticationProvider.authenticate");
		System.out.println(authentication);
		
		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println("Authenication supports called");
		// TODO Auto-generated method stub
		return true;
	}

}
