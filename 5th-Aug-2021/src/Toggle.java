import java.util.Scanner;

public class Toggle {

	public static void main(String [] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter text:");
		String text=scan.nextLine();
		String res="";
		for(int i=0;i<text.length();i++)
		{
			char ch=text.charAt(i);
		//System.out.println(ch);			
			if(Character.isLowerCase(ch)==true)
				res=res + Character.toUpperCase(ch);
			else 
				res=res + Character.toLowerCase(ch);				
			
		}
		System.out.println("Toggle:"+res);
		
	}
}