package com.glearning.GradedAssignment4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.glearning.GradedAssignment4.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee where first_name=:input", nativeQuery = true)
	List<Employee> searchEmployeeByFirstname(@Param("input") String input);

}
