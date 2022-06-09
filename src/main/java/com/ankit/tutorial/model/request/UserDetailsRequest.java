package com.ankit.tutorial.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequest {

	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, max = 16, message = "Firstname must be more than 2 characters")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	

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

	
}
