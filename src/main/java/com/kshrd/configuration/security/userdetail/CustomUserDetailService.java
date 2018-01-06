package com.kshrd.configuration.security.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kshrd.model.User;
import com.kshrd.repository.MybatisUserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	MybatisUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("User not found!");
		
		System.out.println(user);		
		return new CustomUserDetail(user);
	}

}
