package com.ecommerce.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.ToString;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Role extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
    @NotEmpty(message = "Role name can not be empty")
	private String roleName;
    
	@OneToMany(targetEntity = User.class,mappedBy = "role",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonBackReference("role_user")
	private Set<User> users;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", users=" + users + "]";
	}
	
	
	
	

}
