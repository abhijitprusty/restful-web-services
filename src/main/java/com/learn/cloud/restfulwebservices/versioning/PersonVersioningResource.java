package com.learn.cloud.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.cloud.restfulwebservices.beans.PersonV1;
import com.learn.cloud.restfulwebservices.beans.PersonV2;

@RestController
public class PersonVersioningResource {

	//using the basic versioning concept
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Abhijit Prusty");
	}

	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2("Abhijit" , "Prusty");
	}
	
	/** using the param version concept - also called Reqeust Paramter Versioning
	 * 
	 * @return
	 * /person/param?version=1
	 */
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 personParamV1() {
		return new PersonV1("Abhijit Prusty");
	}
	// - person/param?version=2
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 personParamV2() {
		return new PersonV2("Abhijit" , "Prusty");
	}
	
	/** using the concept of  - header versioning **/
	
	//need to set the VERSION_API = 1 or 2 in the header
	// headers value cane any 
	@GetMapping(value = "/person/header", headers = "VERSION_API=1")
	public PersonV1 personHeaderV1() {
		return new PersonV1("Abhijit Prusty");
	}

	@GetMapping(value = "/person/header", headers = "VERSION_API=2")
	public PersonV2 personHeaderV2() {
		return new PersonV2("Abhijit" , "Prusty");
	}
	
	/** using - MIME TYPE or Accept Header Versioning **/
	//using Accept = application/vnd.company.app-v1+json
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 personProducesV1() {
		return new PersonV1("Abhijit Prusty");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 personProducesV2() {
		return new PersonV2("Abhijit" , "Prusty");
	}
	
}
