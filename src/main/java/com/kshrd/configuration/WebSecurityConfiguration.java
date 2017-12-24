package com.kshrd.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	
			.withUser("user").password("pwd").roles("USER").and()
			.withUser("dba").password("pwd").roles("DBA").and()
			.withUser("admin").password("pwd").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		
		//enable form login
		http.formLogin()
			//custom login page
			.loginPage("/login")
			//custom success handler
			.successHandler(successHandler);
		
		//logout
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/index");
		
		//authorize url
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/dba/**").hasAnyRole("ADMIN", "DBA")
			.antMatchers("/user/**").hasAnyRole("ADMIN", "DBA", "USER");
		
		http.exceptionHandling()	
			.authenticationEntryPoint(authenticationEntryPoint);
		
		
	}
	
	
}
