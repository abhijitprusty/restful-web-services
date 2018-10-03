package com.learn.cloud.restfulwebservices.beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = " All description about user")
public class User {

	private Integer id;
	
	@Size(min = 2, message = "Name should be minimum of 2 chars")
	//this will apear in the swagger docs - /v2/api-docs URI
	@ApiModelProperty(notes = " Name should be of 2 charecters minimum in request")
	private String name;
	
	@Past(message = "Present date not allowed")
	//this will apear in the swagger docs - /v2/api-docs URI
	@ApiModelProperty(notes = " Birth date should not be in past ")
	private Date birthDate;

	/**
	 * 
	 */
	protected User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
