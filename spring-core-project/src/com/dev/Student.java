package com.dev;

import java.util.Iterator;
import java.util.List;

public class Student {

	private int id;
	private String name;
	private Address address;
	private List<String> tutors;
	private List<Course> courses;

	public Student(int id, String name, Address address, List<String> tutors, List<Course> courses) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tutors = tutors;
		this.courses = courses;
	}


	public void show() {
		System.out.println(
				"\nStudent id: " + this.id 
				+ " and name: " + this.name
				+ "\nand address: " + this.address
				);
		
//		Iterator<String> it1 = tutors.iterator();
//		while (it1.hasNext()) {
//			System.out.println(it1.next());
//		}
		tutors.stream().forEach(v -> System.out.println(v));
		
		Iterator<Course> it2 = courses.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
//		courses.stream().forEach(v -> System.out.println(v.getId() + " " + v.getName()));
	}
}
