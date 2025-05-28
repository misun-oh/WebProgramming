package com.inherit.practice;

public class Employee extends Person{
	public int salary;	// 급여
	public String dept;	// 부서
	
	public Employee() {
		
	}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		super.name = name;
		this.salary = salary;
		this.dept = dept;
		
	}

	@Override
	public String information() {
		return super.information() + ", " + salary+","+dept;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
