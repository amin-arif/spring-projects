package com.dev;

public class Teacher {

	private Course course1;
	private Course course2;

	public Course getCourse1() {
		return course1;
	}

	public void setCourse1(Course course1) {
		this.course1 = course1;
	}

	public Course getCourse2() {
		return course2;
	}

	public void setCourse2(Course course2) {
		this.course2 = course2;
	}

	@Override
	public String toString() {
		return "Teacher ==> [course1=" + course1 + ", course2=" + course2 + "]";
	}

}
