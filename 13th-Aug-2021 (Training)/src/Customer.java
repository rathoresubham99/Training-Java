
public class Customer {
	private int mobileNumber;
	private String address;
	private int pincode;
	private String accountHolderName;
	
	public Customer(int mobileNumber, String address, int pincode, String accountHolderName) {
		super();
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.pincode = pincode;
		this.accountHolderName = accountHolderName;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Customer [mobileNumber=" + mobileNumber + ", address=" + address + ", pincode=" + pincode
				+ ", accountHolderName=" + accountHolderName + "]";
	}

	}
