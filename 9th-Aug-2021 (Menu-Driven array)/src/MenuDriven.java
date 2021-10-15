import java.util.*;

public class MenuDriven {

	static Scanner scan;
	static Scanner scan1;
	static Employee arr[];
	static int pos=0;
	public static void main(String arg[]){  
		
		scan=new Scanner(System.in);
		scan1 = new Scanner(System.in);
		arr=new Employee[100];	
		while(true)
		{
			System.out.println("1.Add Employee");		
			System.out.println("2.update Salary by Emp number");
			System.out.println("3.Display by Emp Number");
			System.out.println("4.Display Employee Details By dept number");
			System.out.println("5.Display All");
			System.out.println("0.Add Employee");
			
			System.out.println("Enter your choice:");
			int ch= scan.nextInt();
			switch(ch)
			{
			case 1: addEmployee(); break;
			case 2:
				updateSalbyEmpno();
				break;
			case 3: 
				showByEmpno();
				break;
			case 4: 
				showByDept();
				break;
			case 5: showAll();break;
			case 0:
			default:
				System.exit(0);  
				break;
			
			}
		}
	}
	public static void addEmployee()
	{
		System.out.println("Enter Emp Number:");
		int en=scan.nextInt();
		System.out.println("Enter name");
		String nm=scan1.nextLine();
		System.out.println("Enter Salary:");
		int sal=scan.nextInt();
		System.out.print("Enter Department:");
		String dept= scan1.nextLine();
		boolean flag=false;
		for(int i=0;i<pos;i++)
		{
			if(arr[i].empno()==en)
			{
				flag=true;
				break;
			}
		}
			
		if(flag==false)
		{
		Employee e1=new Employee(en,nm);
		e1.sal(sal);
		e1.dept(dept);
	
		arr[pos]=e1;
		
		System.out.println("Record Addition Successful");
		pos++;
		}
		else
		  System.out.println("Duplicate empno. is not allowed");
	
	}
	public static void updateSalbyEmpno()
	{
		System.out.println("Enter the Empno. to be updated");
	    int en = scan.nextInt();
	    System.out.println("Enter the new salary to be updated.");
	    int sal=scan.nextInt();
	    for (int i=0;i<pos;i++)
	    {
	    	if(arr[i].empno()==en)
	    	{
	    		arr[i].sal(sal);
	    	}
	    }
	    
	}
	public static void showByEmpno()
	{
		System.out.println("Enter the Empno whose details are to be displayed");
		int en = scan.nextInt();
		for(int i=0;i<pos;i++)
		{
			if(arr[i].empno()==en)
			System.out.println("Employee No:" +" "+arr[i].empno()+" "+"Emp Name: "+arr[i].ename()+" "+"Emp Sal: "+arr[i].sal()+" "+ "Emp Dept:"+" "+arr[i].dept());
		}
	}
	public static void showByDept()
	{
		System.out.println("Enter dept to show details");
		String dept = scan1.next();
		for(int i=0;i<pos;i++)
		{
			if(arr[i].dept().equals(dept))
				System.out.println("Employee No:" +" "+arr[i].empno()+" "+"Emp Name: "+arr[i].ename()+" "+"Emp Sal: "+arr[i].sal()+" "+ "Emp Dept:"+" "+arr[i].dept());

		}
		
	}

	public static void showAll()
	{
		for(int i=0;i<pos;i++)
		{
		
			System.out.println("Employee No: " +" "+arr[i].empno()+" "+"Emp Name:"+arr[i].ename()+" "+"Emp Sal: "+arr[i].sal()+" "+ "Emp Dept: "+" "+arr[i].dept());

		}
	}
}
