package com.kshrd.configuration.security.userdetail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kshrd.model.Role;
import com.kshrd.model.User;

public class CustomUserDetail implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<Role> roles;

	public CustomUserDetail(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authority = new ArrayList<>();
		for (Role role : roles) {
			authority.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
		}
		return authority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		
		String encode1 = p.encode("user");
		String encode2 = p.encode("admin");
		String encode3 = p.encode("dba");
		System.out.println(encode1);
		System.out.println(encode2);
		System.out.println(encode3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
