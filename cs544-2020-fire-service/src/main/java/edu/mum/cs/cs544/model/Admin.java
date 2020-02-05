package edu.mum.cs.cs544.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User{
	
	public Admin() {
		super();
	}

	public Admin(String username, String password, String fname, String lname) {
		this.username = username;
		this.password = password;
		this.firstName = fname;
		this.lastName = lname;
		this.role = UserRole.ADMIN;
	}

}
