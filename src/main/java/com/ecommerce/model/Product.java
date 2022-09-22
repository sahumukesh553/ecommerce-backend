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

import lombok.ToString;
@Entity
@ToString
public class Product extends AbstractPersistable<Long>{
	@NotEmpty(message="product name can not be empty")
	private String name;
	@NotEmpty(message="product brand can not be empty")
	private String brand;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	private transient Long categoryId;
	@Lob
	private byte[] productImage;
	@NotNull(message="product quantity can not be empty")
	private Integer quantity;
	//@NotEmpty(message = "Product price can not be null")
	private Long price;

	private Integer discount;
	
	private String description;

	private transient long dicountedPrice;
	private  transient long percentageDiscount;

	public long getDicountedPrice() {
		dicountedPrice=price-discount;
		return dicountedPrice;
	}

	public long getPercentageDiscount() {
		percentageDiscount = 100 * (price - getDicountedPrice()) / price;
		return percentageDiscount ;
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
