import java.util.*;
public class SqueezeExtraSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String string= scanner.nextLine();
		for(int i=0;i<string.length();i++)
		{
			char ch=string.charAt(i);
			if(ch!=' ')
			{
				System.out.print(ch);
			}
		}

	}

}
