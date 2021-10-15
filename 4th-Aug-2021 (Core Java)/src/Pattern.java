import java.util.*;
public class Pattern {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int k=8;
		int rows = sc.nextInt();
		System.out.println("Enter the number of columns");
		int col=sc.nextInt();
		for (int i=1;i<=rows;i++)
		{ 
			for (int j=0;j<col;j++)
			{
				
			int m=(int)(k*Math.pow((i+1), j));
			System.out.println(m+ " ");
			m=0;
			
			
			}
			k--;
		}
		
	}

}
