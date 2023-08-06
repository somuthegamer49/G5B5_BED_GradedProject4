package com.glearning.GradedAssignment4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.GradedAssignment4.entity.Role;
import com.glearning.GradedAssignment4.repository.RoleRepository;
import com.glearning.GradedAssignment4.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository rolerepository;

	public List<Role> viewRoles() {
		return rolerepository.findAll();
	}

	@Override
	public Role addRole(Role role) {
		return rolerepository.save(role);
	}
}
