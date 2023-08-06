package com.glearning.GradedAssignment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.GradedAssignment4.entity.Role;
import com.glearning.GradedAssignment4.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleservice;

	@GetMapping
	public List<Role> viewRoles() {
		return roleservice.viewRoles();
	}

	@PostMapping
	@Transactional
	public Role addRole(@RequestBody Role role) {
		return roleservice.addRole(role);
	}
}
