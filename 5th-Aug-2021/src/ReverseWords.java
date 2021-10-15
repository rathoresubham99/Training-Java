import java.util.*;
public class ReverseWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
System.out.println("Enter a Sentence: ");		
String string= sc.nextLine();
String revString="";
String splittedString[] = string.split("\\s");
for (int i=0;i<splittedString.length;i++)
{
	String word = splittedString[i];
	String revWords="";
	for (int j=word.length()-1;j>=0;j--)
	{
		revWords+=word.charAt(j);
	}
	revString+=revWords+" ";
	
}
System.out.println("Reverse String: "+ revString+" ");
	}

}
