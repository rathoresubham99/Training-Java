import java.util.*;
import java.util.Locale.Category;
import java.security.PublicKey;
import java.sql.*;
public class MenuJDBC {

public static void main(String[] args) throws Exception {
	Scanner scan = new Scanner(System.in);
	Empl emp = new Empl();
	System.out.println("Welcome to the JDBC application....Please set the options.");
	System.out.println("1. Add a new Employee");
	System.out.println("2. Update the Employee");
	System.out.println("3. Show the Employees dept wise");
	System.out.println("4. Delete an employee record.");
	System.out.println("5. Show all the records");
	System.out.println("6. Exit");
	
    	System.out.println("Enter the choice: ");
    	int ch = scan.nextInt();
    	switch (ch) {
		case 1:
		    emp.getEmployee();
			emp.insertEmployee();
   
			break;

		default:
			System.exit(0);
			break;
    	} 

	}
}
class Empl
{
private int empno;
private String ename;
float sal;
int  deptno;
private int mgr;

public void getEmployee()
{
	 Scanner scan = new Scanner(System.in);
	 Scanner scan1 = new Scanner(System.in);
	System.out.println("Enter the Employee Number");
	empno = scan.nextInt();
	System.out.println("Enter the Employee Name");
	ename = scan1.nextLine();
	System.out.println("Enter the Employee Salary");
	sal = scan.nextFloat();
	System.out.println("Enter the Employee dept Number");
	deptno = scan.nextInt();
	System.out.println("Enter the Employee Manager Number");
	mgr = scan.nextInt();

}
public void insertEmployee() throws Exception
{

	dbConnection connect= new dbConnection("jdbc:mysql://localhost:3306/emp_data","Sunny@001","root");
	Connection connection = connect.getConnection();
	String sql = "insert into emp(empno, ename,sal,deptno,mgr) values (?,?,?,?,?)";
	PreparedStatement st = connection.prepareStatement(sql);
	st.setInt(1, empno);
	st.setString(2, ename);
	st.setFloat(3, sal);
	st.setInt(4, deptno);
	st.setInt(5, mgr);
	st.executeUpdate();
	System.out.println("Record has been updated successfully");
	connect.closeConnection(connection, st);
}

}
class dbConnection
{
	public String url;
	public String pass;
	public String user;
	
	
	public dbConnection(String url, String pass, String user) {
		super();
		this.url = url;
		this.pass = pass;
		this.user = user;
	}

	public Connection getConnection() throws Exception
	{
	Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection(url,user,pass);
		System.out.println("Connection established Successfully...");
		return con;
	}
	public void closeConnection(Connection con, Statement stmt) throws SQLException
	{
		con.close();
		stmt.close();
	}
}






