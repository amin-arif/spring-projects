package com.dev;

import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		
		// Get context from XML config file
		ApplicationContext context = new ClassPathXmlApplicationContext("com/dev/ApplicationContext.xml");
		
		Employee employee = (Employee) context.getBean("employee");
		employee.setName("John Dane");
		employee.setDesignation("Programmer");
		System.out.println(employee.getName() + ", " + employee.getDesignation());
		
		// Get context from Annotation based configuration
		ApplicationContext context2 = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee employee2 = (Employee) context2.getBean("employee");
		employee2.setName("Lob Harbest");
		employee2.setDesignation("Accountant");
		System.out.println(employee2.getName() + ", " + employee2.getDesignation());
		
		
		//---------------- Use Constructor Injection ----------------
		Student student = (Student) context.getBean("student");
		student.show();
		
		// Autowire use in configuration
		Teacher teacher = (Teacher) context.getBean("teacher");
		System.out.println(teacher);
		
	}

}
