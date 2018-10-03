package com.learn.cloud.restfulwebservices.beans;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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

	/** For Content Negotiation
	* For GET - need to set in header as 
	* Accept = application/xml or application/json
	* */
	@GetMapping("/users/all")
	public List<User> getAllUsers() {
		return userDaoService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public Resource<User> findById(@PathVariable int id) {
		User user = userDaoService.findById(id);
		if(user == null)
			throw new UserNotFoundException("id ="+id);
		
		/**
		 * Implementing the HATEOAS feature of SB to link resources
		 * **/
		//create a resource of user
		Resource<User> resource = new Resource<User>(user);
		//build the links for the resource of user
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		//add the link to resource, with a name which would appear in the response i.e. "all-users"
		resource.add(linkTo.withRel("all-users"));
		
		//return resource instead of user now. Below is a sample response
//		{
//		    "id": 3,
//		    "name": "AbhiPriya",
//		    "birthDate": "2018-10-02T15:24:48.662+0000",
//		    "_links": {
//		        "all-users": {
//		            "href": "http://localhost:9190/users/all"
//		        }
//		    }
//		}
		
		return resource;
	}

	

	@PostMapping("/users/create")
	public void create(@RequestBody User user) {
		userDaoService.saveUser(user);
	}

	/**Enhancing the post method to return correct HTTP code and location in
	* header
	* Addint the java validation api (validation-api1.0.jar is used and provided by SB) 
	* add @valid tag to request body and contraints attributes to User object
	* 
	* We need to implement the default validation API to provide details to end user. Check in CustomEntity
	* Exception class
	* 
	* For Content Negotiation
	* For Post - need to set in header as 
	* Accept = application/xml or application/json
	* Content-Type = application/xml or application/json
	* 
	**/
	@PostMapping("/users")
	public ResponseEntity save(@Valid @RequestBody User user) {

		User savedUser = userDaoService.saveUser(user);
		// build the location using the ServletUriComponentsBuilder
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		//this will return "201 Resource Created " - Code
		return ResponseEntity.created(location).build();
	}
}
