import java.util.*;
import java.util.ArrayList;
public class Generics {
public static void main (String args[])
{
//List<Integer> list= new ArrayList<>();
//list.add(120);
//list.add(new Integer(190));
//list.add(50);
//for (int i=0;i<list.size();i++)
//{
//	System.out.println(list.get(i));
//}
	List<Employee> arr = new ArrayList<Employee>();
	Employee e1= new Employee();
	arr.add(e1);
	
}
}
class Employee
{
	
}
class permEmployee extends Employee
{
	
}
class permEmployeeProduct extends permEmployee
{
	
}
class permEmployeeTs extends permEmployee
{
	
}