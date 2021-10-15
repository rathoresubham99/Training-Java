import java.util.Map;
import java.util.*;
import javax.imageio.ImageTypeSpecifier;

import java.util.*;
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account(1001, "Savings", 5000);
		Account a2 = new Account(1002, "Current", 5000);
		Account a3 = new Account(1003, "Savings", 6000);
		
		Customer c1 = new Customer(1234, "ABC colony", 1234, "Abhishek");
		Customer c2 = new Customer(12346, "AB colony", 121, "Mayank");
		Customer c3 = new Customer(12345, "AC colony", 112, "Karan");
		Customer c4 = new Customer(12347, "ABCD colony", 212, "Sahil");
		
		Map<Account, Customer> map = new HashMap<>();
		map.put(a1, c1);
		map.put(a2, c2);
		map.put(a3, c3);
		
		Customer c = map.get(1003);
		if(c!=null)
		{
			System.out.println(c.toString());
		}
		else{
			System.out.println("Not Exist");
		}
	
	// for object and object mapping

for (int i=0;i<3;i++)
{
	System.out.println("Enter account no to be searched");
	Scanner scanner = new Scanner(System.in);
	int acc = scanner.nextInt();
	Account account = new Account(acc);
	Customer customer = map.get(account);
	if(customer!=null)
	{
		System.out.println(customer.toString());
	}
	else {
		System.out.println("Not Found");
	}
}
System.out.println("-----------------------------------------------------------");
for(Map.Entry<Account, Customer> entry : map.entrySet())
{
	Account account = entry.getKey();
	Customer customer = entry.getValue();
	System.out.println("Account details are: "+ account.toString());
	System.out.println("Customer details are: "+ customer.toString());
	System.out.println("-------------------------------------------------------------");
}
}
}
