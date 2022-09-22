package com.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.ToString;
@Entity
public class Address extends AbstractPersistable<Long> {
	@NotNull(message="city can not be empty")
	private String city;
	@NotNull(message="state can not be empty")
	private String state;
	@NotNull(message="country can not be empty")
	private String country;
	@NotNull(message="pincode can not be empty")
	private String pincode;
	
	private String landMark;
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference("address_user")
	private User user;
	
	private transient Long userId;
	
	@OneToMany(targetEntity = Order.class,mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonBackReference(value = "address_order")
	private Set<Order> orders;
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

}
