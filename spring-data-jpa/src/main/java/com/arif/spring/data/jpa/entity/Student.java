package com.arif.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "student_email"))
public class Student {
	
	@Id
	@SequenceGenerator(name = "st_id", sequenceName = "student_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "st_id")
	private Long studentId;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "student_email", nullable = false)
	private String email;
	
}
