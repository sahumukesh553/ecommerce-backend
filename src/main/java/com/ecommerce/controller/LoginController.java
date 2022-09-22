package com.ecommerce.controller;

import java.security.Principal;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Message;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4204/")
public class LoginController {
    @GetMapping("/")
	public Message login(HttpSession http, Principal principal)
	{Enumeration<String> attributeNames = http.getAttributeNames();
	System.out.println(principal);
	
	while(attributeNames.hasMoreElements())
	{String nextElement = attributeNames.nextElement();
	

		System.out.println( nextElement);
		System.out.println(http.getValue( nextElement));
	}
	
		return new Message("you are logged in successfully ",HttpStatus.OK);
	}
}
