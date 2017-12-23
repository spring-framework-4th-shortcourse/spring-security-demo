package com.kshrd.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		System.out.println("-> login success!");
		
		System.out.println(auth.getName());
		System.out.println(auth.getPrincipal());
		System.out.println(auth.getAuthorities());
		
		String redirectUrl = "/index";
		
		for(GrantedAuthority authority: auth.getAuthorities()){
			if(authority.getAuthority().contains("USER")){
				redirectUrl = "/user/dashboard";
			}
			else if(authority.getAuthority().contains("DBA")){
				redirectUrl = "/dba/dashboard";
			}
			else if(authority.getAuthority().contains("ADMIN")){
				redirectUrl = "/admin/dashboard";
			}
		}
		response.sendRedirect(redirectUrl);
	}

}
