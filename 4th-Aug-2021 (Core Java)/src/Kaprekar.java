import java.*;
import java.util.*;
public class Kaprekar {
	static boolean multiplesOfTen(int n)
	{
		if(n%10==0)
			return true;
		else
			return false;
	
	}
	static boolean iskaprekar(int n)
    {
		int leftPart, leftPart1;
		int rightPart,rightPart1;
		int sum=0, sum1=0, sum2=0;
		int k,k1;
        if (n == 1)
           return true;
        int square=n*n;
        int temp=square;
        int count=0;
        while(square>0)
        {
        	count+=1;
        	square=square/10;
        }
       
        if (count%2==0)
        {
        	k=count/2;
        	leftPart=(int)(temp/Math.pow(10, k));
        	rightPart=(int)(temp%Math.pow(10, k));
        	sum=leftPart+rightPart;
        
        	if(sum==n)
        	{
        		return true;
        	}    	
        	
        }
        else if(count%2!=0)
        {
        	k=(int)(Math.floor(count/2));
        	k1=(int)(Math.ceil(count/2));
        	leftPart=(int)(temp/Math.pow(10, k));
        	rightPart=(int)(temp%Math.pow(10, k1));
        	sum1=leftPart+rightPart;
        	
        
        	if(sum1==n)
        	{
        		return true;
        	} 
        	
        }
        return false;
    }
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Starting Number");
int start = sc.nextInt();
System.out.println("Enter the Ending Number");
int end = sc.nextInt();
System.out.println("The Kaprekar Numbers are  ");
for(int i=start;i<=end;i++)
{
	if(iskaprekar(i) && !multiplesOfTen(i))
	{
		System.out.print(i+" ");
	} 
}
}
}
