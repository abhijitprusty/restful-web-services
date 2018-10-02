package com.learn.cloud.restfulwebservices.beans;

import java.net.URI;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.cloud.restfulwebservices.users.UserDaoService;
import com.learn.cloud.restfulwebservices.users.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users/all")
	public List<User> getAllUsers() {
		return userDaoService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id) {
		User user = userDaoService.findById(id);
		if(user == null){
			throw new UserNotFoundException("id ="+id);
		}
		return user;
	}


	@PostMapping("/users/create")
	public void create(@RequestBody User user) {
		userDaoService.saveUser(user);
	}

	// Enhancing the post method to return correct HTTP code and location in
	// header
	@PostMapping("/users")
	public ResponseEntity save(@RequestBody User user) {

		User savedUser = userDaoService.saveUser(user);
		// build the location using the ServletUriComponentsBuilder
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		//this will return "201 Resource Created " - Code
		return ResponseEntity.created(location).build();
	}
}
