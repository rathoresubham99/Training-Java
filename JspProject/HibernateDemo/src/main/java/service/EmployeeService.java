package service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.EmployeeDao;
import model.Employee;


@Service
public class EmployeeService {
	@Autowired
	@Qualifier("hibernatedao")
	EmployeeDao employeeDao;
	@PostConstruct
	public void setup(){
		
	}
	
	public boolean addEmployeeDetails(Employee emp){
		boolean flag;
		System.out.println("Adding employee (in service)");
		//perform bussiness logic here
		//EmployeeDao dao=new EmployeeDao();
		//if(emp!=null && emp.getName()!=null && emp.getDesignation()!=null)
		//{
		if(emp.getName().equals("")|| emp.getDesignation().equals("")){
			flag=false;
		}
		//}
		else
			flag=employeeDao.add(emp);
		return flag;
	}

}