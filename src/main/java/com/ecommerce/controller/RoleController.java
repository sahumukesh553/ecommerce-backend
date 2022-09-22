package com.ecommerce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ecommerce.model.Role;
import com.ecommerce.service.impl.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin("http://localhost:4200/")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/")
	public Role addRole(@RequestBody Role role) {
		
		return roleService.create(role);
	}
	@GetMapping("/")
	public Collection<Role> getAllRole(){
		return roleService.getAll();
	}

}
