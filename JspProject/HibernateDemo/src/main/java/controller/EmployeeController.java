package controller;

import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;
import service.EmployeeService;



@Controller
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/")
	public String home(Model model){
		Employee emp=Employee.EmployeeFactory.create();
		System.out.println(" In Home");
		model.addAttribute("emp",new Employee());
		return "index";
		//Employee emp=Employee.EmployeeFactory.create();

	}
	
	@RequestMapping("/create")
	public String create(){
		System.out.println(" In Add Emp");
		return "addEmp";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Welcome!!!");
		model.addAttribute("emp",new Employee());
	}
	
//	public String addEmployee(@RequestParam String ename,@RequestParam String salary,@RequestParam String desig )
//	{
	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute Employee emp )
	{
		System.out.println("In add employee controller!!!!!!!!!!!!!!");
		boolean flag;
		
		System.out.println("Emplooyee:"+emp);
			
	
		
		 flag=employeeService.addEmployeeDetails(emp);
		System.out.println("******************");
		System.out.println(flag);
		System.out.println("******************");
		
		if(flag)
			return "success";
		else
			return "error";
					
}
	
	public ModelAndView addEmp(@ModelAttribute("emp") Employee emp)
	{
	 ModelAndView modelAndView =new ModelAndView("success");
	 return modelAndView;
		
	}
}