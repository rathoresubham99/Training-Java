package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

//@Component
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountId",unique=true,nullable=false)
	int empId;
	
	@Column(name="emp_name",length=30)
	String empName;
	
	@Column
	String empPhoneNum;
	
	@Column
	String experience;
	
	@Column
	String gender;
	
	@Column
	int salary;
	
	@Column
	int age;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Date dob;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="emp_acct_id",referencedColumnName="accountId")
	BankAccount bankAccount;
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="deptId",referencedColumnName="deptId")//emp table deptId is a FK to the deptID of the dept table
	Department dept;
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="EMP_PROJECTS",joinColumns={@JoinColumn(name="EMPLOYEE_ID",referencedColumnName="empId")},inverseJoinColumns={@JoinColumn(name="PROJECT_ID",referencedColumnName="PR_ID")})
	private List<Project> projectsList;
	
	public List<Project> getProjectsList() {
		return projectsList;
	}
	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public Employee(String ename,String phone,String gender){
		this.empName=ename;
		this.empPhoneNum=phone;
		this.gender=gender;
		
	}

	public static class EmployeeFactory{
	public static Employee create(){
		return  new Employee();
	}
	}
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", experience="
				+ experience + ", gender=" + gender + ", salary=" + salary + ", age=" + age + ", dob=" + dob + ", dept="
				+ dept + "]";
	}
	
	
	
	
}