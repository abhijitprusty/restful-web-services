/**
 * 
 */
package com.learn.cloud.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.cloud.restfulwebservices.beans.HelloWorldBean;

/**
 * @author AbhijitPrusty
 *
 */
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld(){
		return "Hello Abhijit";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean(" Hello Abhijit");
	}
	
	//path variable
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVar(@PathVariable String name){
		return new HelloWorldBean(String.format(" Hello Abhijit %s", name));
	}
}
