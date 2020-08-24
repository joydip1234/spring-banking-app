package jbr.springmvc.model;

import java.util.Arrays;
import java.util.List;

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Integer role;
	private String address;
	private List<String> roles;

	public final List<String> getRoles() {
		return roles;
	}

	public final void setRoles(String roles) {
		System.out.println("Roles are : " + roles);
		List<String> rolesList = Arrays.asList(roles.split("\\s*,\\s*"));
		this.roles = rolesList;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public final Integer getRole() {
		return role;
	}

	public final void setRole(Integer role) {
		this.role = role;
	}

}
