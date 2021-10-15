
public class Account {
private int accountNumber;
private String accountType;  // savings, current
public Account(int accountNumber) {
	super();
	this.accountNumber = accountNumber;
}
private float balance;

@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance + "]";
}
public Account(int accountNumber, String accountType, float balance) {
	super();
	this.accountNumber = accountNumber;
	this.accountType = accountType;
	this.balance = balance;
}
public int getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}
@Override
public int hashCode() {
return this.accountNumber;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Account other = (Account) obj;
	if (accountNumber != other.accountNumber)
		return false;
	return true;
}

}
