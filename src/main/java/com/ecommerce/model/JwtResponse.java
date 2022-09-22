package com.ecommerce.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String  userId;
	private final String isAdmin;

	public JwtResponse(String jwttoken,String userId,String isAdmin) {
		this.jwttoken = jwttoken;
		this.userId=userId;
		this.isAdmin=isAdmin;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getUserId() {
		return userId;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	
	

	
	
	

}
