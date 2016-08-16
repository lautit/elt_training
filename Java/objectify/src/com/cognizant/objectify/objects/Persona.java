package com.cognizant.objectify.objects;

public class Persona {
	
	private String name;
	private Integer age;
	
	public Persona() {
		
	}
	
	public Persona(String name) {
		setName(name);
	}
	
	public Persona(String name, Integer age) {
		setName(name);
		setAge(age);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return this.age;
	}

}
