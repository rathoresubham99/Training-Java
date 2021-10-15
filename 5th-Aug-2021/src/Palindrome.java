import java.io.*;
import java.lang.*;
import java.util.*;
public class Palindrome 
{
	public static void main(String []args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter text:");
		String name=scan.nextLine();
		String res="";			
		
		for(int i=name.length()-1;i>=0;i--)
		{
			res=res+name.charAt(i);			
		}
		System.out.println("Reverse:"+res);
		if(name.equals(res))
			System.out.println("Palindrome");
		else
			System.out.println("Not palindrome");
	}

}

