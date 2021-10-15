import java.util.*;
public class AscendingOrder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String temp;
		System.out.println("Enter the size of the Array String: ");
		int n= sc.nextInt();
		System.out.println("Enter the Array");
		String arr[] = new String[n];
		for (int i = 0; i < arr.length; i++) {
		        arr[i] = sc.nextLine();
		    }

		for(int i=0;i<n;i++)
		{
			for (int j=i+1;j<n;j++)
			{
				if(arr[i].compareTo(arr[j])>0)
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		} System.out.println("The names in ascending order are: ");
		for (int i=0;i<n;i++)
		{
			System.out.print(arr[i]+ " ");
		}

	}

}
