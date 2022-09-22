package com.ecommerce.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Message;
import com.ecommerce.model.OrderedProduct;
import com.ecommerce.repository.OrderedProductRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class OrderedProductService extends CommonServiceImpl<OrderedProduct>{
@Autowired
private OrderedProductRepository orderedProductRepository;

@Autowired
private OrderService orderService;
	@Override
	public Collection<OrderedProduct> getAll() {
		// TODO Auto-generated method stub
		return orderedProductRepository.findAll();
	}

	@Override
	public OrderedProduct getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderedProduct create(OrderedProduct t) {
		if(t.getOrderId()!=null)
			t.setOrder(this.orderService.getById(t.getOrderId()));
		return orderedProductRepository.save(t);
	}

	@Override
	public OrderedProduct updateById(OrderedProduct t, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
