package service;

import org.springframework.stereotype.Service;

import data.EmployeeDao;
import model.Employee;

@Service()
public class EmployeeService {
	public boolean addEmployeeDetails(Employee emp){
		System.out.println("Adding employee (in service)");
		//perform bussiness logic here
		EmployeeDao dao=new EmployeeDao();
		boolean flag=false;
		if(emp.getEmpName().equals("")||emp.getEmpPhoneNum().equals("")){
			flag=false;
		}
		else
			flag=dao.addEmployee(emp);
		return flag;
	}

}
