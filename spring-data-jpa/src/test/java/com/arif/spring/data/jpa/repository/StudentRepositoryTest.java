package com.arif.spring.data.jpa.repository;

import com.arif.spring.data.jpa.entity.Guardian;
import com.arif.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                        .name("Luke")
                                .email("luke@email.com")
                                        .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianInfo() {
        Guardian guardian = Guardian.builder()
                        .name("Duke")
                                .email("duke@gmail.com")
                                        .phone("01712309066")
                                                .build();

        Student student = Student.builder()
                .name("Debian")
                .email("deb@email.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List = " + studentList);
    }
    
    @Test
    public void showStudnetInfo() {
    	
    	System.out.println("Student info by Id: " + studentRepository.findById(9L));
    	
    	System.out.println("Student info by Name: " + studentRepository.findByName("arif"));
    	
    	System.out.println("Student info by Name (Alias): " + studentRepository.findByNameContaining("ed"));
    	
    	System.out.println("Student info by Email (Not Null): " + studentRepository.findByGuardianNameNotNull());
    	
    	System.out.println("Student info by Guardian Name: " + studentRepository.findByGuardianName("Rambo"));
    }

    @Test
    public void getStudentByEmailJPQL() {
        List<Student> students = studentRepository.getStudentsByEmail("luke@email.com");

        System.out.println("students = " + students);
    }

    @Test
    public void getGuardianInfoByStudentInfoNativeSQL() {
        System.out.println("Guardian name: " + studentRepository.getGuardianNameByStudentNameAndEmail("fed", "fed@email.com"));
        System.out.println("Guardian name (Query named params): " + studentRepository.getGuardianNameByStudentNameAndEmailQueryNameParams("fed", "fed@email.com"));
    }

    @Test
    public void updateNameByEmail() {
        studentRepository.updateNameByEmail("Deb Iaan", "deb@email.com");
    }
}






