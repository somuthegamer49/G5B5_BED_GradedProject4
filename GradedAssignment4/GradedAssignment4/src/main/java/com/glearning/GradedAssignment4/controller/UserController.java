package com.glearning.GradedAssignment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.GradedAssignment4.entity.User;
import com.glearning.GradedAssignment4.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping
	@Transactional
	public User addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}

	@GetMapping
	public List<User> viewUsers() {
		return userservice.viewUsers();
	}
}
