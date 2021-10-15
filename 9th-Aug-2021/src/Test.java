
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Number of Employees");
		int size=scanner.nextInt();
		Operation operation = new Operation(100);
		System.out.println("Enter the Employee details");
		for(int i=0;i<size;i++)
		{
			Employee e1=new Employee();
			System.out.println("Enter "+ (int)(i+1)+" "+ "Employee name");
			String name = scanner.next();
			System.out.println("Enter "+(int)(i+1)+" "+  "Employee Number");
			int empno=scanner.nextInt();
			
			System.out.println("Enter "+(int)(i+1)+" "+  "Employee Salary");
			int empSal=scanner.nextInt();
			System.out.println("Enter "+(int)(i+1)+ " "+ "Employee Department");
			String empDept=scanner.next();
			e1.setName(name);
			e1.setEmpno(empno);
			e1.setSal(empSal);
			e1.setDept(empDept);
			operation.addEmployee(e1);
			
		}
		
		String text="";
		Employee e1=null;
do {
	System.out.println("Enter 0 to add the Employees");
	System.out.println("Enter 1 to find by empno");
	System.out.println("Enter 2 to find by name");
	System.out.println("Enter 3 to show all Employees");
	System.out.println("Enter choice ->");
	int ch = scanner.nextInt();
	switch(ch)
	{
	case 0:
		System.out.println("Enter Number of Employees");
		int s=scanner.nextInt();
		System.out.println("Enter the Employee details");
		for(int i=0;i<size;i++)
		{
		    e1=new Employee();
			System.out.println("Enter "+ (int)(i+1)+" "+ "Employee name");
			String name = scanner.next();
			System.out.println("Enter "+(int)(i+1)+" "+  "Employee Number");
			int empno=scanner.nextInt();
			
			System.out.println("Enter "+(int)(i+1)+" "+  "Employee Salary");
			int empSal=scanner.nextInt();
			System.out.println("Enter "+(int)(i+1)+ " "+ "Employee Department");
			String empDept=scanner.next();
			e1.setName(name);
			e1.setEmpno(empno);
			e1.setSal(empSal);
			e1.setDept(empDept);
			operation.addEmployee(e1);
			
		}
		break;
	case 1:
		System.out.println("Enter Empno to find");
		
		 e1=operation.findByEmpno(scanner.nextInt());
		if(e1!=null)
		{
			System.out.println(e1.getName()+" "+e1.getEmpno()+" "+e1.getSal()+" "+e1.getDept());
			
		}
		else {
			System.out.println("This Employee does not exist!");
		}
		break;
	case 2:
		System.out.println("Enter Emp Name to find");
		 e1=operation.findByEmpName(scanner.next());
		if(e1!=null)
		{
			System.out.println(e1.getName()+" "+e1.getEmpno()+" "+e1.getSal()+" "+e1.getDept());
			
		}
		else {
			System.out.println("This Employee name does not exist!");
		}
		break;
	case 3:
		operation.showEmployee();
		break;
		default: System.out.println("Wrong Choice");
		
	}
	System.out.println("Do you want to continue Y/N?");
	text=scanner.next();
} while (text.equalsIgnoreCase("y"));	

System.out.println("Thanks for using the application");
	}
}
