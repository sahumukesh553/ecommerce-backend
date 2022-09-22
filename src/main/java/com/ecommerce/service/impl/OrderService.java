package com.ecommerce.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Message;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderedProduct;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.OrderedProductRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class OrderService extends CommonServiceImpl<Order> {
@Autowired
private OrderRepository orderRepository;

@Autowired
private UserService userService;
@Autowired
private AddressService addressService;
@Autowired
private OrderedProductRepository orderedProductRepository;

@Autowired
private ProductRepository productRepository;
	@Override
	public Collection<Order> getAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getById(Long id) {
		
		return orderRepository.findById(id).get();
	}

	@Override
	public Order create(Order order) {
		if(order.getAddressId()!=null)
			order.setAddress(addressService.getById(order.getAddressId()));
		if(order.getUserId()!=null)
		order.setUser(userService.getById(order.getUserId()));
		if(order.getStatus()==null)
			order.setStatus("Processed");
		if(order.getDate()==null)
		order.setDate(LocalDateTime.now());
		
		return orderRepository.save(order);
	}

	@Override
	public Order updateById(Order t, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Order makeOrder(Order newOrder)
	{ Order order=create(newOrder);
		List<OrderedProduct> products=new ArrayList<OrderedProduct>();
		for(OrderedProduct product:order.getProducts())
		{
			product.setOrder(order);
			product.setProductImage(this.productRepository.findByName(product.getName()).getProductImage());
			products.add(product);
		}
		this.orderedProductRepository.saveAll(products);
		return order;
	}

}
