package org.impelsys.model;

import java.util.Date;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;


public class Employee {
	
	int empId;
	

	String empName;
	String empPhoneNum;
	String experience;
	String gender;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Date dob;
	
	int age;
	int salary;
	
	
	
	
	public Employee(String ename,String phone,String gender){
		this.empName=ename;
		this.empPhoneNum=phone;
		this.gender=gender;
	}
	public Employee(){
		
	}

	public static class EmployeeFactory{
		public static Employee create(){
			return  new Employee();
		}
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhoneNum() {
		return empPhoneNum;
	}
	public void setEmpPhoneNum(String empPhoneNum) {
		this.empPhoneNum = empPhoneNum;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", experience="
				+ experience + ", gender=" + gender + ", dob=" + dob + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
