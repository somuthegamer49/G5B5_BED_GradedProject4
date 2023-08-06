package com.glearning.GradedAssignment4.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.GradedAssignment4.entity.Role;
import com.glearning.GradedAssignment4.entity.User;
import com.glearning.GradedAssignment4.repository.RoleRepository;
import com.glearning.GradedAssignment4.repository.UserRepository;

@Configuration
public class BootStrapSuperAdmin {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		// Addding users and roles
		User somdutt = new User("somdutt", this.passwordEncoder.encode("welcome"));

		Role superAdminRole = new Role("ROLE_SUPER_ADMIN");

		somdutt.addRole(superAdminRole);

		this.userRepository.save(somdutt);

	}

}
