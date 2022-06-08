package com.arif.spring.data.jpa.repository;

import com.arif.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
