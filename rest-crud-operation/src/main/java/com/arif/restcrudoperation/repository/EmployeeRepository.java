package com.arif.restcrudoperation.repository;

import org.springframework.data.repository.CrudRepository;

import com.arif.restcrudoperation.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
