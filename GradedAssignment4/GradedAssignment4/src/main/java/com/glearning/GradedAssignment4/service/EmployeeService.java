package com.glearning.GradedAssignment4.service;

import java.util.List;

import com.glearning.GradedAssignment4.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee createEmployee(Employee employee);

	void deleteEmployee(int id);

	Employee updateEmployee(Employee employee, int id);

	Employee getEmployee(int id);

	List<Employee> searchEmployee(String input);

	List<Employee> sortedEmployee(String ord);

}
