package com.example.boot.entity;

public class User {
	private String name;
	private int age;
	private String gender;
	private boolean isEmployed;

	public User() {
	}

	public User(String name, int age, String gender, boolean isEmployed) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isEmployed = isEmployed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	
}
