package org.impelsys.model;


import java.util.List;

import org.springframework.stereotype.Repository;

import model.Employee;

public interface EmployeeDao{
	public int addEmployee(Employee emp);
	public default boolean delete(Employee emp){
		return false;
	}
	public default List<Employee> getEmployees(int id){
		return null;
	};
	public default List<Employee> getAllEmployees(){
		return null;
	};
	public default List<Integer> getAllDistinctSalary(){
		return null;
	};
	public default List<Employee> getEmployeeList(){
		return null;
	};
	public default List<Employee>  getAllEmployees(int from,int noOfRows){
		return null;
	};
	//int updateEmployeeDept(Employee emp);
	
	Long getEmployeesCount();
	
	int update(Employee emp);
	
	public int updateEmployeeDepartment(Employee emp);
}



/*@Repository("employeeDao")
public class EmployeeDao {
	public boolean addEmployee(Employee emp){
		System.out.println("Adding employee (in data/dao)");
		boolean flag=true;
		//perform database operations here
		System.out.println(emp.getEmpName()+emp.getEmpPhoneNum());
		
		return flag;
	}
	public default boolean delete(Employee emp){return false;};
	public List<Employee> getEmployees() {
		return null;
	}

}
*/