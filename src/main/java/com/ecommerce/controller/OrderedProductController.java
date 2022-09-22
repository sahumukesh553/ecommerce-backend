package com.ecommerce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.OrderedProduct;
import com.ecommerce.service.impl.OrderedProductService;
@RestController
@RequestMapping("/ordered-product")
@CrossOrigin("http://localhost:4200/")
public class OrderedProductController {
	@Autowired
	private OrderedProductService orderedProductService;

	@GetMapping("/")
	public Collection<OrderedProduct> getAllOrderedProducts(){
		return orderedProductService.getAll();
	}
	
	@PostMapping("/")
	public OrderedProduct saveOrderedProduct(@RequestBody OrderedProduct orderedProduct)
	{
		return orderedProductService.create(orderedProduct);
	}
}
