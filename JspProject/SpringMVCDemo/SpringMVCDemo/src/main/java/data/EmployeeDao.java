package data;

import javax.annotation.Resource;

import model.Employee;

@Resource
public class EmployeeDao {
	public boolean addEmployee(Employee emp){
		System.out.println("Adding employee (in data/dao)");
		boolean flag=false;
		//perform database operations here
		
		return flag;
	}

}
