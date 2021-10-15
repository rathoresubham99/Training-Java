import java.util.Arrays;
import java.util.*;
public class MergeArray {

public static void mergeAndSort(int a[], int b[], int m, int n, int res[])
{
int i=0;
int j=0;
int k=0;
while(i<m)
{   
	res[k++]=a[i++];
}
while(j<n)
{
	res[k++]=b[j++];
}
Arrays.sort(res);
}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Size of first array");
		int m = scanner.nextInt();
		System.out.println("Enter the size of second array");
		int n= scanner.nextInt();
		int a[]= new int[m];
		int b[] = new int[n];
		int res[] = new int[m+n];
		System.out.println("Enter the elements for the first array");
		for (int i=0;i<m;i++)
		{
			a[i]=scanner.nextInt();
		}
		System.out.println("Enter the elements for the second array");
		for(int i=0;i<n;i++)
		{
			b[i]=scanner.nextInt();
		}
		mergeAndSort(a, b, m, n, res);
		System.out.print("Sorted merged list :");
        for (int i = 0; i < n + m; i++)
            System.out.print(" " + res[i]);
	}

}
