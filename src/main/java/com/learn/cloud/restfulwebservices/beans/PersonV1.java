package com.learn.cloud.restfulwebservices.beans;

public class PersonV1 {

	public PersonV1() {
		super();
		
	}

	/**
	 * @param name
	 */
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
