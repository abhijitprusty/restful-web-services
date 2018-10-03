package com.learn.cloud.restfulwebservices.beans;

public class PersonV2 {

	private String firstName;
	private String lastName;
	
	public PersonV2() {
		super();
		
	}
	
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public PersonV2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


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
