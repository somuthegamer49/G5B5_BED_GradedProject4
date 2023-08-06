package com.glearning.GradedAssignment4.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.glearning.GradedAssignment4.entity.Role;
import com.glearning.GradedAssignment4.entity.User;
import com.glearning.GradedAssignment4.repository.RoleRepository;
import com.glearning.GradedAssignment4.repository.UserRepository;
import com.glearning.GradedAssignment4.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private RoleRepository rolerepository;

	@Override
	public User addUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userrepository.save(user);
		int id = 0;
		for (int ids : rolerepository.findRoleId()) {
			if (user.getId() == ids) {
				id = ids;
			}
		}
		Optional<Role> tempRole = this.rolerepository.findById(id);
		if (tempRole.isPresent()) {
			user.addRole(tempRole.get());
		}
		return user;
	}

	@Override
	public List<User> viewUsers() {
		return userrepository.findAll();
	}
}
