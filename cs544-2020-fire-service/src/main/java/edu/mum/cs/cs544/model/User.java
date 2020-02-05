package edu.mum.cs.cs544.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id @GeneratedValue
	protected Integer id;
	
	@Column(unique = true, length = 200)
	@NotBlank
	protected String username;
	
	@Column(length = 255)
	@NotBlank 
	@JsonIgnore
	protected String password;
	
	@Column(length = 255)
	@NotBlank
	protected String firstName;

	@Column(length = 255)
	@NotBlank
	protected String lastName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected UserRole role;
	
	public User() {
		
	}

	public User(String username, String password, String firstName, String lastName, UserRole role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
	
}
