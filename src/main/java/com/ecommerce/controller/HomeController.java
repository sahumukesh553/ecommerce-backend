package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String Welcome()
	{
		return "Welcome to springboot fashion store mukesh";
		
	}

}
