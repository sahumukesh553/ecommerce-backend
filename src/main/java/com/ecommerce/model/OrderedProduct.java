package com.ecommerce.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.ToString;
@Entity
@ToString
public class OrderedProduct extends AbstractPersistable<Long>{
	@NotEmpty(message="ordered product name can not be empty")
	private String name;
	@NotEmpty(message="ordered product brand can not be empty")
	private String brand;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonBackReference("product_order")
	private Order order;
	
	@Lob
	private byte[] productImage;
	//@NotEmpty(message="ordered product quantity can not be empty")
	private Integer quantity;
	@NotNull(message = "ordered Product price can not be null")
	private Long price;
	
	private Long total;
	
	private String description;
	
	private transient Long categoryId;
	
	private transient Long orderId;

	

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	

	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
