package com.arif.spring.data.jpa.repository;

import com.arif.spring.data.jpa.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByName(String name);
	
	List<Student> findByNameContaining(String name); // It matches character of name
	
	List<Student> findByGuardianNameNotNull();
	
	List<Student> findByGuardianName(String guardianName);
	
	
}