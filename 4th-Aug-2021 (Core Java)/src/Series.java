
import java.util.*;
import java.*;
class Series {
public static double fact(double n)
{
	double i,fact=1;    
	  for(i=1;i<=n;i++){    
	      fact=fact*i;    
	  }   
	  return fact;
}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		double sum=0.0;
			for(double i=1;i<=n;i=i+2.0)
		{
				double k= fact(i+1);
		    	sum=sum+(i/k);
		
		}
System.out.print("The Sum of Series is" +" "+ sum);
	}

}
