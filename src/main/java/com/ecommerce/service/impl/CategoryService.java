package com.ecommerce.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Category;
import com.ecommerce.model.Message;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class CategoryService extends CommonServiceImpl<Category> {
@Autowired
private CategoryRepository categoryRepository;
	@Override
	public Collection<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category create(Category t) {
		// TODO Auto-generated method stub
		return categoryRepository.save(t);
	}

	@Override
	public Category updateById(Category t, Long id) {
		
		Category category=getById(id);
		category.setName(t.getName());
		category.setDescription(t.getDescription());
		return  categoryRepository.save(category);
	}

	@Override
	public Message deleteById(Long id) {
		// TODO Auto-generated method stub
		 categoryRepository.deleteById(id);
		 return new Message("category deleted successfully",HttpStatus.OK);
	}

}
