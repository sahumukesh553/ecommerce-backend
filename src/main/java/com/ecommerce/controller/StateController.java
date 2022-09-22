package com.ecommerce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.State;
import com.ecommerce.service.impl.StateService;

@RestController
@RequestMapping("/states")
@CrossOrigin("http://localhost:4200/")
public class StateController {
	@Autowired
	private StateService stateService;
	
	@GetMapping("/")
	public Collection<State> getAllState(){
		return stateService.getAll();
	}
	
}
