package org.impelsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.impelsys.data.model.BankAccount;
import org.impelsys.data.model.Department;
import org.impelsys.data.model.Employee;
import org.impelsys.data.model.Employee.EmployeeFactory;
import org.impelsys.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	
	@RequestMapping("/updateDept/{empId}/{deptId}")
	public void updateDept(@PathVariable int empId, @PathVariable int deptId , Model model ){
		Employee emp=new Employee();
		emp.setEmpId(empId);
//		Department d=new Department();
//		d.setDeptId(deptId);
//		emp.setDepartment(d);
		service.updateEmployeedept(emp);
		
	}
	
	@RequestMapping("/update/{ename}/{phone}/{city}")
	public String update(@PathVariable String ename, @PathVariable String phone , @PathVariable String city, Model model )
	{
		Employee e= new Employee();
		e.setEmpName(ename);
		e.setEmpPhoneNum(phone);
		int count = service.updateEmployeedept(e);
		if(count>=1){
			model.addAttribute("emp",e);
			return "show";
		}
		else
		{
			return "error";
		}
		
	}
	
	@RequestMapping("/create/{count}")
//	localhost:8080/HibernateDemo/employee/create/100	 
	public void createEmpInBulk(@PathVariable int count){
		Employee e=new Employee(); 
		for(int i=0;i<count;i++){
			e.setEmpName("emp:"+i);
			e.setEmpPhoneNum("124455663453"+i);
			//populate all the fields 
			service.addEmployeeDetails(e);
		}
		System.out.println("Processing Complete");
	}
	
	@RequestMapping("/getPage/{pageNum}")
	public String page(@PathVariable String pageNum,Model model){
		int pageNo = Integer.parseInt(pageNum);	//let pageNo=2
		int numOfRecords=10;	
		int rowFrom=1;
		rowFrom=((pageNo-1)* numOfRecords)+1; // ((2-1)*10)+1=1
		List<Employee> listEmp = service.displayAllEmployees(rowFrom, numOfRecords);
		model.addAttribute("empList",listEmp);
		return "home";
	}
	
	@RequestMapping("/")
	public String home(Model model)
	{
		System.out.println("In /employee/");
		Employee emp=new Employee();
		emp.setEmpName("Subham");
//		Department dept= new Department();
//		dept.setDeptName("Admin2");
//		emp.setDepartment(dept);
		
		
		//System.out.println("dept added");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountType("Savings Account");
		bankAccount.setBankName("AXIS Bank");
		bankAccount.setIfsc("AXIS004240");
		System.out.println("Bank details added");
		
//		emp.setBankAccount(bankAccount);
		service.addEmployeeDetails(emp);
		service.assignEmployeeProjects();
		
		Long empCount = service.getEmployeesCount();
		model.addAttribute("employee",emp);
		model.addAttribute("empCount",empCount);
		model.addAttribute("firstCall",true);
		
		return "home";
	}


	
	@ModelAttribute
	public void commStuff(Model model){
		model.addAttribute("HeaderStatus", "Welcome to Impelsys!!");
		model.addAttribute("emp", new Employee());
	}
	@RequestMapping("/index")
	public String addemp(){
		return "add";
	}
	@RequestMapping("/tryAgain")
	public String tryAgain(){
		return "add";
	}
	@RequestMapping("showLogin")
	public String showLogin(){
		return "login";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
	}

	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp){
		System.out.println("Addin g employee (in controller)");
		 int flag = 1;
		
		 flag=service.addEmployeeDetails(emp);
		 if(true)
			 return "success";
		 return "error";
		
	}
	
}
