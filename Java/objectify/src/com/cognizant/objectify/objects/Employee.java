package com.cognizant.objectify.objects;

public class Employee extends Persona {
	
	private Double salary;

	public Employee() {
		
	}

	public Employee(String name, Double salary) {
		super(name);
		setSalary(salary);
	}

	public Employee(String name, Integer age, Double salary) {
		super(name, age);
		setSalary(salary);
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
