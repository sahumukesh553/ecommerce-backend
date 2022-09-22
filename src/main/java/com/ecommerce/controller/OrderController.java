package com.ecommerce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.service.impl.OrderService;
@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:4200/")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public Collection<Order> getAllOrders(){
		return orderService.getAll();
	}
	
	@PostMapping("/")
	public Order saveOrder(@RequestBody Order order)
	{
		
		return orderService.makeOrder(order);
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id)
	{System.out.println(this.orderService.getById(id).getProducts());
		return this.orderService.getById(id);
	}
}
