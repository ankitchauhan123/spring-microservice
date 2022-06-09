package com.ankit.tutorial.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.tutorial.model.request.UserDetailsRequest;
import com.ankit.tutorial.model.request.UserRequest;
import com.ankit.tutorial.model.response.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String,UserResponse> users= new HashMap<String,UserResponse>();

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit") int limit) {
		return "Get User called with page " + page + " and  limit = " + limit;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
		UserResponse user = null;
		
		if (users.containsKey(userId)) {
			user=users.get(userId); 
			return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
		}
		return new ResponseEntity<UserResponse>(new UserResponse(), HttpStatus.NO_CONTENT);

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
		UserResponse user = new UserResponse();
		String userId=UUID.randomUUID().toString();
		user.setEmailID(userRequest.getEmailID());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setUserID(userId);
		users.put(userId,user);
		return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
	}
	
	
	@PutMapping(path="/{userId}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String updateUser(@PathVariable String userId,@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
		if (users.containsKey(userId)) {
			
		}
		return "Update User";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User";
	}

}
