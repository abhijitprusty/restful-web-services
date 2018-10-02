package com.learn.cloud.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learn.cloud.restfulwebservices.beans.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;
	static {
		users.add( new User(1, "Abhijit", new Date()));
		users.add( new User(2, "Priya", new Date()));
		users.add( new User(3, "AbhiPriya", new Date()));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User findById(int id){
		for (User user : users) {
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User saveUser(User user){
		if(user.getId() == null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
}
