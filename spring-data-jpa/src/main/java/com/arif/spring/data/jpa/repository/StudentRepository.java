package com.arif.spring.data.jpa.repository;

import com.arif.spring.data.jpa.entity.Student;

import java.util.List;

import org.hibernate.query.QueryParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByName(String name);
	
	List<Student> findByNameContaining(String name); // It matches character of name
	
	List<Student> findByGuardianNameNotNull();
	
	List<Student> findByGuardianName(String guardianName);

	// JPQL (The query is Entity based, not database)
	@Query("select s from Student s where s.email = ?1")
	List<Student> getStudentsByEmail(String email);

	// SQL Native (The query is database based)
	@Query(value = "select s.guardian_name from student s where s.student_name = ?1 and s.student_email = ?2", nativeQuery = true)
	String getGuardianNameByStudentNameAndEmail(String name, String email);

	@Query(value = "select s.guardian_name from student s where s.student_name = :studentName and s.student_email = :studentEmail", nativeQuery = true)
	String getGuardianNameByStudentNameAndEmailQueryNameParams(@Param("studentName") String name, @Param("studentEmail") String email);

	@Modifying
	@Transactional
	@Query(
			value = "update student set student_name = :name where student_email = :email",
			nativeQuery = true
	)
	void updateNameByEmail(@Param("name") String name, @Param("email") String email);

}