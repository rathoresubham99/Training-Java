import java.awt.MenuComponent;
import java.util.*;
import java.util.Map.Entry;
public class Frequency {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Text: ");
		String string = scanner.nextLine();
		HashMap<Character,Integer> map = new HashMap<>();
		char[] arr = string.toCharArray();
		
		for(char ch : arr)
		{
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
			}
			else map.put(ch, 1);
		}
		for (Map.Entry c:map.entrySet())
		{
			System.out.println(c.getKey()+ " "+ c.getValue() );
		}
	}

}
