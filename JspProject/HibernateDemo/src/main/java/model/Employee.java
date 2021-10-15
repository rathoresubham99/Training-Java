package model;

import java.util.Date;

public class Employee {
	
	
	int id; 
	
	
	String name; 
	
	

	
	float salary;   
	
	
	String designation;
	
	
	int empExperience;
	
	
	Date dateOfBirth;
	
	
	public Employee(){
		
	}
	
	//factory pattern
	public static class EmployeeFactory{
		public static Employee create(){
			return new Employee();
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public int getEmpExperience() {
		return empExperience;
	}
	public void setEmpExperience(int empExperience) {
		this.empExperience = empExperience;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		System.out.println(dateOfBirth);
		this.dateOfBirth = dateOfBirth;
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ ", empExperience=" + empExperience + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	}
