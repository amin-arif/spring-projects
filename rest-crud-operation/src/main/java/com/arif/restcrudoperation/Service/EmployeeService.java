package com.arif.restcrudoperation.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arif.restcrudoperation.model.Employee;
import com.arif.restcrudoperation.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() 
	{
		List<Employee> employees = new ArrayList<>();		
		employeeRepository.findAll().forEach(singleEmp -> employees.add(singleEmp));
		
		return employees;
	}
	
	public Employee getEmployeeById(int id) 
	{		
		return employeeRepository.findById(id).get();
	}

	public void saveOrUpdateEmployee(Employee employee) 
	{		
		employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(int empId) 
	{
		employeeRepository.deleteById(empId);
	}
}





