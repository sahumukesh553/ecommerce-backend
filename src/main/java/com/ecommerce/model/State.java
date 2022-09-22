package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
public class State extends AbstractPersistable<Long> implements Serializable { 
	
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
