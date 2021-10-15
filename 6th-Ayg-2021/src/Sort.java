
import java.util.*;
public class Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the Array elements: ");
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter Element-> " + " "+(int)(i+1));
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<size;i++)
		{
			int temp;
			for (int j=i+1;j<size;j++)
			{
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("The Elements after Descending sort are: ");
		for(int i=0;i<size;i++)
		{
		System.out.print(arr[i]+ " ");
		}

	}

}
