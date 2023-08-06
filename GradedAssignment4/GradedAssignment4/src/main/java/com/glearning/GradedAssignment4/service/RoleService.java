package com.glearning.GradedAssignment4.service;

import java.util.List;

import com.glearning.GradedAssignment4.entity.Role;

public interface RoleService {
	Role addRole(Role role);

	List<Role> viewRoles();
}
