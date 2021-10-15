import java.util.*;
import java.io.*;
public class Employee {
private int empno;
private String ename;
private int sal;
private String dept;

public void setEmpno(int empno) {
	this.empno=empno;
}
public void setName(String ename) {
	this.ename=ename;
}
public void setSal(int sal) {
	this.sal=sal;
}
public void setDept(String dept) {
	this.dept=dept;
}
public int getEmpno()
{
	return empno;
}
public String getName()
{
	return ename;
}
public int getSal()
{
	return sal;
}
public String getDept()
{
	return dept;
}
}

