package com.ecommerce.model;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="user_details")
public class User extends AbstractPersistable<Long> {
	@NotEmpty(message="User Name Can Not Be Empty")
	private String name;
	
	@NotEmpty(message=" User Email Can Not Be Empty")
	@Column(name = "user_email",nullable = false,unique = true)
	private String email;
	
	@NotEmpty(message="User password Can Not Be Empty")
	private String password;
	
	@NotEmpty(message="User number Can Not Be Empty")
	@Column(name="mobile_number",nullable = false,unique = true,length = 10)
	private String number;
	
	@Lob
	private byte[] profileImage;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "reset_password_token")
    private String resetPasswordToken;
	 
	

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@OneToMany(targetEntity = Address.class,mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Address> addresses;
	
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(targetEntity = Order.class,mappedBy = "user",fetch =FetchType.LAZY,cascade = CascadeType.ALL )
	private Set<Order> orders;
	
	private transient Long roleId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	

	

}
