package com.singh.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singh.model.User;
import com.singh.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public User getUser(@PathParam("id") Integer id) throws Exception {
		return userService.getUser(id);
	}
	
	@GetMapping
	public List<User> getAllUser(@RequestBody User user) throws Exception {
		return userService.getAllUsers();
	}

	@PostMapping
	public User createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}
	
	@PutMapping
	public void updateUser(@RequestBody User user) throws Exception {
		userService.updateUser(user);
	}
	
	@DeleteMapping
	public void deleteUser(@RequestBody User user) throws Exception {
		userService.deleteUser(user.getId());
	}

	@PostMapping(value="/checkUser")
	public Map<String, Boolean> isUserExist(@RequestBody String email) throws Exception {
		return Collections.singletonMap("isUserExist", userService.isUserExist(email));
	}

	@PostMapping(value = "/login")
	public Map<String, Boolean> login(@RequestBody User user) throws Exception {
		return Collections.singletonMap("success", userService.login(user));
	}
}
