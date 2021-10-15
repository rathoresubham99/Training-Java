package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
	String empName;
	@NotNull
	@Size(min=3,max=10)
	String empPhoneNum;

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
	
}
