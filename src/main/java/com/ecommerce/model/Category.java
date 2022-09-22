package com.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Category extends AbstractPersistable<Long> {
	@NotEmpty(message = "Category name can not be empty")
	private String name;
	
	private String description;
	
	@OneToMany(targetEntity = Product.class,mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonBackReference(value = "category_product")
	private Set<Product> products;
	
	@OneToMany(targetEntity = OrderedProduct.class,mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonBackReference(value = "category_ordered_product")
	private Set<OrderedProduct> orderedProducts;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
