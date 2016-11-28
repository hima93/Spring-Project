package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.egen.app.entity.User;
import io.egen.app.service.UserService;

@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private UserService service;
	
	
	//User Registration
		@RequestMapping(method = RequestMethod.POST,value="register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String create(@RequestBody User usr){
			return service.create(usr);
		}

		//Admin Registration
		@RequestMapping(method = RequestMethod.POST,value="register/Admin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String create_Admin(@RequestBody User usr){
			return service.create_Admin(usr);
		}
		
		//Login user & Admin returns login successful or not
			@RequestMapping(method = RequestMethod.POST,value="login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
			public String login(@RequestBody User usr){
				return service.login(usr);
			}
			//Update user information
			@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public User update(@PathVariable("id") String usrId, @RequestBody User usr) {
			return service.update(usrId, usr);
		}
		
//Returns all users 
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}
	
	
//Find one user 
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String usrId) {
		return service.findOne(usrId);
	}


//Delete user
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String usrId) {
		service.remove(usrId);
	}
}