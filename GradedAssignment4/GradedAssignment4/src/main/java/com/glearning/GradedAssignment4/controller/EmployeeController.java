package com.glearning.GradedAssignment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.GradedAssignment4.entity.Employee;
import com.glearning.GradedAssignment4.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping
	public List<Employee> listEmployees() {
		return employeeservice.getAllEmployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeservice.createEmployee(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return employeeservice.updateEmployee(employee, id);
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeservice.getEmployee(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeservice.deleteEmployee(id);
	}

	@GetMapping("/search/{input}")
	public List<Employee> searchEmployee(@PathVariable String input) {
		return employeeservice.searchEmployee(input);
	}

	@GetMapping("/sort/order=\"{input}\"")
	public List<Employee> sortEmployee(@PathVariable String input) {
		return employeeservice.sortedEmployee(input);
	}
}
