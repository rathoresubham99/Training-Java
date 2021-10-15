import java.util.*;
public class Shortname {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    String string = scanner.nextLine();
    if(string.length()==0){
    	System.out.println("Please Enter a valid name: "+" "+string);
	}
    System.out.print(Character.toUpperCase(string.charAt(0))+".");
    for (int i =1;i<string.length()-2;i++)
        if (string.charAt(i)== ' ')
            System.out.print(" " + Character.toUpperCase(string.charAt(i + 1))+".");
	}

}
