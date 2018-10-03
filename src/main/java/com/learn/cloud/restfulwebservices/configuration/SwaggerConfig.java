package com.learn.cloud.restfulwebservices.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//get these from the API info class
	public static final Contact DEFAULT_CONTACT = new Contact("Abhijit Prusty", "http://abprusty.com", "ab@gmail.com");
	  public static final ApiInfo DEFAULT = new ApiInfo(
			  "Api Documentation", "Awesome API Description", "1.0", 
			  "urn:tos", DEFAULT_CONTACT, 
			  "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES_AND_COSNUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	
	//create docket for swaggger
	@Bean
	public Docket api() {
		//this would provide default API doc implementation.
		//return new Docket(DocumentationType.SWAGGER_2);
		/**
		 * IN order to improve the doc to have addtional information like
		 * for 
		 * 1. info section  - in /v2/api-docs we can add our custom information
		 * 2. For the API say /users - we can tell in can consume and produce - xml and json.
		 * 
		 * We can improve the definition of the User to give more details like, name has min of 2 char etc.
		 * that will be done at the user.java bean class. Please check there.
		 * 
		 * **/
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT)
				//this consume and produce would appear in swagger ui as well.
				.consumes(DEFAULT_PRODUCES_AND_COSNUMES).produces(DEFAULT_PRODUCES_AND_COSNUMES);
		
	}

}
