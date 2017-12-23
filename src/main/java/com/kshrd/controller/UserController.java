package com.kshrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping(value = {"/", "/index"})
	public String homePage(){
		return "index";
	}
	
	@GetMapping("/user/dashboard")
	public String userPage(){
		return "user/dashboard";
	}
	
	@GetMapping("/dba/dashboard")
	public String dbaPage(){
		return "dba/dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminPage(){
		return "admin/dashboard";
	}
	
}
