package controller;
//mvc demo
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;
import service.EmployeeService;

@Controller
public class EmployeeController {
	//3 types how we can perform controller tasks
/*	@Autowired
	EmployeeService service;*/
/*	@RequestMapping("/add")
	public  ModelAndView addEmployee(HttpServletRequest request,HttpServletResponse response){
		
	
		System.out.println("In Create employee");
		boolean flag = false;
		//String empName=request.getParameter("empName");
		//String empPhoneNum=request.getParameter("empPhoneNum");
		ModelAndView mv=new ModelAndView(); 
//		mv.addObject("empName",empName);
//		mv.addObject("empPhoneNum",empPhoneNum);
		Employee emp=new Employee();
//		EmployeeService service=new EmployeeService(); 
//		emp.setEmpName(empName);
//		emp.setEmpPhoneNum(empPhone);
		emp.setEmpName(empName);
		emp.setEmpPhoneNum(empPhoneNum);
		flag=service.addEmployeeDetails(emp);
		if(flag)
			mv.setViewName("success.jsp");//for redirecting
		else
			mv.setViewName("error.jsp");
		return mv;
	}*/
	//method 2
/*	@RequestMapping("/add")
	public String addEmployee(@RequestParam String empName,@RequestParam String empPhoneNum){
		System.out.println("In Create employee");
		boolean flag = false;
		Employee emp=new Employee();
		emp.setEmpName(eName);
		emp.setEmpPhoneNum(ePhone);
		flag=service.addEmployeeDetails(emp);
		if(flag)
			System.out.println("Success");
		else
			System.out.println("Error");
		
		return null;
	}*/
	//method 3
	//valid checks for all conditions
	//bindingResult will store that validation result errors
/*	@Autowired
	EmployeeService service;*/
	@RequestMapping("/add")
	public String addEmployee(@Valid Employee emp,BindingResult bindingresult){
		 boolean flag = false;
		 EmployeeService service=new EmployeeService();
		 if(bindingresult.hasErrors()){
			 return "error.jsp";
		 }
		 flag=service.addEmployeeDetails(emp);
		 if(flag)
			 return "success.jsp";
		 return "error.jsp";
		
	}

}
