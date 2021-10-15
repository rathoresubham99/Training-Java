package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
@RequestMapping("/add")
public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException
{
	String flag ="success";
	System.out.println("In Create Employee");
	String ename =request.getParameter("ename");
	String empPhone = request.getParameter("empPhone");
    ModelAndView mView = new ModelAndView();
    mView.addObject("ename",ename);
    mView.addObject("empPhone",empPhone);
    if(flag.equalsIgnoreCase("success"))
    {
    mView.setViewName("success.jsp");
    }
    else
    {
    	 mView.setViewName("error.jsp");
    }
    return mView;
}
}
