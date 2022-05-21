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
                        .name("ted")
                                .email("ted@email.com")
                                        .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianInfo() {
        Guardian guardian = Guardian.builder()
                        .name("David")
                                .email("david@gmail.com")
                                        .phone("01612309090")
                                                .build();

        Student student = Student.builder()
                .name("ted")
                .email("ted@email.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List = " + studentList);
    }

}