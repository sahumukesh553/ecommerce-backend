package com.ecommerce.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Category;
import com.ecommerce.model.Message;
import com.ecommerce.service.impl.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin("http://localhost:4200/")
public class CategoryController {
	@Autowired
	private CategoryService  categoryService;
	
	@PostMapping("/")
	public Category saveCategory(@RequestBody Category category)
	{
		return categoryService.create(category);
	}
	
   @GetMapping("/")
	public Collection<Category> getAllCategories()
	{
		return categoryService.getAll();
	}
   
   @GetMapping("/count")
  	public Integer getAllCategoriesCount()
  	{
  		return categoryService.getAll().size();
  	}
   
   @GetMapping("/{id}")
   public Category getCategoryById(@PathVariable("id") Long id)
   {
	   return categoryService.getById(id);
   }
   
   @PutMapping("/{id}")
   public Category updateCategory(@PathVariable("id") Long id,@RequestBody Category category)
   {
	   return this.categoryService.updateById(category, id);
   }
   
   @DeleteMapping("/{id}")
   public Message deleteCategory(@PathVariable("id") Long id)
   {
	   return this.categoryService.deleteById(id);
   }
   
   
}
