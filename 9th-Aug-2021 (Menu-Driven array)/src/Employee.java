
public class Employee {

	private int empno;  // readonly ,getter
	private String ename; // readonly , getter
	private String dept; // read & write , getter & setter    
	private int sal; // read & write , getter and setter

	Employee(int empno,String ename)
	{
		this.empno=empno;
		this.ename=ename;
		
	}
	
	public int empno()
	{
		return this.empno;
	}
	public String ename()
	{
		return this.ename;
	}
	public String dept()
	{
		return this.dept;
	}
	public void dept(String dept)
	{
		this.dept=dept;
	}
	public int sal()
	{
		return this.sal;
	}
	public void sal(int sal)
	{
		this.sal=sal;
	}	
	public String toString()
	{
		return "Empno:"+this.empno+" Name:"+this.ename+" Dept: "+this.dept;
	}

}



