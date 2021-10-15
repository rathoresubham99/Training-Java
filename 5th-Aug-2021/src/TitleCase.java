import java.util.*;
public class TitleCase {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a text: ");
		String text=scanner.nextLine();
		if (text == null || text.isEmpty()) {
	      System.out.println(text);
	    }

	    StringBuilder converted = new StringBuilder();

	    boolean convertNext = true;
	    for (char ch : text.toCharArray()) {
	        if (Character.isSpaceChar(ch)) {
	            convertNext = true;
	        } else if (convertNext) {
	            ch = Character.toTitleCase(ch);
	            convertNext = false;
	        } else {
	            ch = Character.toLowerCase(ch);
	        }
	        converted.append(ch);
	    }
	    System.out.println(converted.toString());
	}

}
