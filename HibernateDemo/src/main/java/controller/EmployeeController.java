package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.BankAccount;
import model.Department;
import model.Employee;
import model.Employee.EmployeeFactory;
import service.EmployeeService;


@Controller
@RequestMapping("/employee") //localhost:8800/HibernateDemo/employee/ v u create ...
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping("/updateDept/{empId}/{deptId}")
	public void updateDept(@PathVariable int empId,@PathVariable int deptId,Model model){
		Employee emp=new Employee();
		emp.setEmpId(empId);
		Department d=new Department();
		d.setDeptId(deptId);
		emp.setDept(d);
		service.updateEmployeeDept(emp);
	}
	
	@RequestMapping("/")
	public String home(Model model){
	
		 Employee emp=new Employee();
		 emp.setEmpName("pqr");
		 Department dept=new Department();
		 dept.setDeptName("HR");
		 emp.setDept(dept);
		//service.addEmployeeDetails(emp);
		System.out.println("dept added");
		 
		 
		 BankAccount bankAccount=new BankAccount();
		 bankAccount.setAccountType("Savings Account");
		 bankAccount.setBankName("Axis Bank");
		 bankAccount.setIfsc("AXIS0001234");
		System.out.println("Bank details added");
		 
		 emp.setBankAccount(bankAccount);
		 service.addEmployeeDetails(emp);
		 
		 Long empCount=(long) service.getEmployeeCount();
		 model.addAttribute("employee",emp);
		 model.addAttribute("empCount",empCount);
		 model.addAttribute("firstCall",true);
		 
		return "home";
	}
	
	@RequestMapping("/create/{count}")
	public void createEmpInBulk(@PathVariable int count){
		for(int i=0;i<count;i++){
			Employee e=new Employee();
		e.setEmpName("emp:"+i);
		e.setEmpPhoneNum("855347"+i);
		service.addEmployeeDetails(e);
	}
		System.out.println("Processing complete....");
	}
	
	@ModelAttribute
	public void commStuff(Model model){
		model.addAttribute("HeaderStatus", "Welcome to Impelsys!");
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
	
	@RequestMapping("/getPage/{pageNum}")
	public String page(@PathVariable String pageNum,Model model){
		
		//fetching employess from table with start row count based on page no.
		int pageNo=Integer.parseInt(pageNum);
		int numOfRecords=10;
		int rowFrom=1;
		rowFrom=((pageNo - 1)* numOfRecords)+ 1;
		List<Employee> listEmp=service.displayAllEmployees(rowFrom,numOfRecords);
		boolean flag=false;
		if(!listEmp.isEmpty())
			 flag=true;
		if(flag){
		model.addAttribute("empList",listEmp);
		return "home";
		}
		else
			return "error";
		
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
	}

	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp){
		System.out.println("Adding employee (in controller)");
		 int flag = 1;
		
		 flag=service.addEmployeeDetails(emp);
		 if(flag>0)
			 return "success";
		 return "error";
		
	}
	
	//path variables
	@RequestMapping("/update/{eName}/{ePhoneNum}/{eId}")//localhost:8800/HibernateDemo/employee/yash/89516/bangalore
	public String update(@PathVariable String eName,@PathVariable String ePhoneNum,@PathVariable int eId,Model model){
		Employee e = new Employee();
		e.setEmpName(eName);
		e.setEmpPhoneNum(ePhoneNum);
		//e.setEmpId(eId);
		//update operation
		int count = service.updateEmployeeDept(e);
		if(count>=1){
			model.addAttribute("empAttribute",e);
			return "home";
		}
		else
		{
			return "error";
		}
			
	}
	
	
}
