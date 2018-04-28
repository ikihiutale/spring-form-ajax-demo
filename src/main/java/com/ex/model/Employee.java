package com.ex.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Employee {
	
	@NotNull(message = "{employee.name.required}")
	@NotEmpty(message = "{employee.name.required}")
	String name;
    
	@NotNull(message = "{employee.email.required}")
	@NotEmpty(message = "{employee.email.required}")
	@Email(message = "{employee.email.invalid}")
	private String email;

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
}
