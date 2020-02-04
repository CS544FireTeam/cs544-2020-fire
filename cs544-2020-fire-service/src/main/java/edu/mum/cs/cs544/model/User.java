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
	protected String password;
	
	@Column(length = 255)
	@NotBlank
	protected String firstName;

	@Column(length = 255)
	@NotBlank
	protected String lastname;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected UserRole role;
	
	public User() {
		
	}

	public User(String username, String password, String firstName, String lastname, UserRole role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastname = lastname;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
	
}
