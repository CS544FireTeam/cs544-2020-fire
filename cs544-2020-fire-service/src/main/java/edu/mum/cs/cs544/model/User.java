package edu.mum.cs.cs544.model;

import javax.persistence.Entity;

@Entity
public class User {

	private Integer id;
	private String username;
	private String password;
	
	public User() {
		
	}
	
}
