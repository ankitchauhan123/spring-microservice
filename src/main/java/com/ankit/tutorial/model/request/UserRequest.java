package com.ankit.tutorial.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {

	@NotNull(message = "First Name cannot be null")
	@Size(min = 2, max = 16, message = "Firstname must be more than 2 characters")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	@NotNull(message = "Email ID cannot be null")
	@Email
	private String emailID;

	@NotNull(message = "password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be  greater than 8 characters and less than 16 characters")
	private String password;

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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
