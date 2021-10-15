import java.util.*;
import java.io.*;
public class Operation {

	private Employee [] emp;
	private int index=0;
	 Operation(int size) {
	 emp=new Employee[size];
	 
		// TODO Auto-generated constructor stub
	}
	 public void addEmployee(Employee e)
	 {
		 emp[index++]=e;
	 }
	 
	 public void showEmployee()
	 {
		 for(int i=0;i<emp.length;i++)
		 {
			 if(emp[i]!=null)
			 {
				 System.out.println(emp[i].getEmpno()+ "\t"+ emp[i].getName()+ "\t"+emp[i].getSal()+"\t" + emp[i].getDept());
				 
			 }
		 }
	 }
	 public Employee findByEmpno(int empno)
	 {
		 Employee employee=null;
		 for(int i=0;i<emp.length;i++)
		 {
			 if(emp[i]!=null)
			 {
				 if(emp[i].getEmpno()==empno)
				 {
					 employee=emp[i];
				 }
			 }
		 }
		 return employee;
	 }
	
	 public Employee findByEmpName(String ename)
	 {
		 Employee employee=null;
		 for(int i=0;i<emp.length;i++)
		 {
			 if(emp[i]!=null)
			 {
				 if(emp[i].getName().equals(ename))
				 {
					 employee=emp[i];
				 }
			 }
		 }
		 return employee;
	 }
}
