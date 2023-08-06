package com.glearning.GradedAssignment4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glearning.GradedAssignment4.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "select id from roles", nativeQuery = true)
	List<Integer> findRoleId();

}
