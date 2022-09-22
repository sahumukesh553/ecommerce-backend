package com.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
@GetMapping("/validate/")
public  String validateEmail(@RequestParam("email") String email)
{
	boolean matches = email.matches("^[a-b 0-9]+(@)[a-b]+.[a-b]+$");
	return matches?"valid email":"invalid email";
}


}
