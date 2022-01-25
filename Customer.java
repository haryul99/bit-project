package com.workshop.entity;

public class Customer {
	private String name;
	private int age;
	private String phone;
	public Customer(String name, int age, String phone) {
		this.name=name;
		this.age=age;
		this.phone=phone;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
}
