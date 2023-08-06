package com.glearning.GradedAssignment4.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.glearning.GradedAssignment4.entity.Employee;
import com.glearning.GradedAssignment4.repository.EmployeeRepository;
import com.glearning.GradedAssignment4.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Optional<Employee> employee1 = employeeRepository.findById(id);
		if (employee1.isPresent()) {
			Employee tempEmployee = employee1.get();
			tempEmployee.setFirstName(employee.getFirstName());
			tempEmployee.setLastName(employee.getLastName());
			tempEmployee.setEmail(employee.getEmail());
			employeeRepository.save(tempEmployee);
			return tempEmployee;
		}
		throw new IllegalArgumentException("Invalid Id passed");
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> employee1 = employeeRepository.findById(id);
		if (employee1.isPresent()) {
			Employee tempEmployee = employee1.get();
			return tempEmployee;
		}
		throw new IllegalArgumentException("Invalid Id passed");
	}

	@Override
	public List<Employee> searchEmployee(String input) {
		return employeeRepository.searchEmployeeByFirstname(input);
	}

	@Override
	public List<Employee> sortedEmployee(String input) {
		if (input.equals("ASC".toLowerCase())) {
			return employeeRepository.findAll(Sort.by("firstName"));
		} else if (input.equals("DESC".toLowerCase())) {
			return employeeRepository.findAll(Sort.by("firstName").descending());
		} else {
			throw new IllegalArgumentException("Invalid string passed");
		}
	}
}
