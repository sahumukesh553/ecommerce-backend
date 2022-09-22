package com.ecommerce.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Message;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.CommonServiceImpl;
@Service
public class ProductService extends CommonServiceImpl<Product>{
@Autowired
private ProductRepository productRepository;

@Autowired 
private CategoryService categoryService; 
	@Override
	public Collection<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found with id :"+id));
	}

	@Override
	public Product create(Product t) {
		
		if(t.getCategoryId()!=null)
		t.setCategory(this.categoryService.getById(t.getCategoryId()));
		return productRepository.save(t);
	}

	@Override
	public Product updateById(Product t, Long id) {
		// TODO Auto-generated method stub
		 Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found with id :"+id));
		if(t.getProductImage()!=null)
		 product.setProductImage(t.getProductImage());
		 if(t.getCategoryId()!=null)
		 {
			product.setCategory(this.categoryService.getById(t.getCategoryId())); 
		 }
		 if(t.getDescription()!=null)
			 product.setDescription(t.getDescription());
		 if(t.getDiscount()!=0)
			 product.setDiscount(t.getDiscount());
		
		return productRepository.save(product);
	}

	@Override
	public Message deleteById(Long id) {
		productRepository.deleteById(id);
		return new Message("product with id : "+id+" successfully deleted", HttpStatus.OK);
	}

}
