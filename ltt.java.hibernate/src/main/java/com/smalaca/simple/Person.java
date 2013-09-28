package com.smalaca.simple;

public class Person {
	
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String introduce() {
		return "My name is " + name + ".";
	}
}
