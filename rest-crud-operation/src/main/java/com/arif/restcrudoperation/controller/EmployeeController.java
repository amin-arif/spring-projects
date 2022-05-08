package com.arif.restcrudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arif.restcrudoperation.Service.EmployeeService;
import com.arif.restcrudoperation.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	private List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{empId}")
	private Employee getEmployeeById(@PathVariable("empId") int empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@DeleteMapping("/delete/{empId}")
	private void deleteEmployeeById(@PathVariable("empId") int empId) {
		employeeService.deleteEmployeeById(empId);
	}

	@PostMapping("/create")
	private int saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployee(employee);
		
		return employee.getId();
	}
	
	@PutMapping("/update")
	private Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployee(employee);
		
		return employee;
	}
	
}














