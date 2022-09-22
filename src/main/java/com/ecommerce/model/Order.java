package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity(name="order_information")
public class Order extends AbstractPersistable<Long>{
	
	private String customerName;
	
	private String customerNumber;
	
	@Column(name="order_status")
	private String status;
	@Column(name="order_date")
	private LocalDateTime date;
    private Long orderAmount;
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference(value = "order_user")
	private User user;
	@OneToMany(targetEntity = OrderedProduct.class,mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<OrderedProduct> products;
	@ManyToOne
	@JoinColumn(name="address_id")	
	private Address address;
	
	private transient Long addressId;
	
	private transient Long userId;
	


	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Long getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderedProduct> getProducts() {
		return products;
	}
	public void setProducts(Set<OrderedProduct> products) {
		this.products = products;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
}
