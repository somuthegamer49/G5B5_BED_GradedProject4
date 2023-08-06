package com.glearning.GradedAssignment4.service;

import java.util.List;

import com.glearning.GradedAssignment4.entity.User;

public interface UserService {
	User addUser(User user);

	List<User> viewUsers();
}
