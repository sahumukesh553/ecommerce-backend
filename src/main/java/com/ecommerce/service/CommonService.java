package com.ecommerce.service;

import java.util.Collection;

import com.ecommerce.model.Message;

public interface CommonService<T> {
	
	Collection<T> getAll();
	T getById(Long id);
	T create(T t);
	T updateById(T t,Long id);
	Message deleteById(Long id);

}
