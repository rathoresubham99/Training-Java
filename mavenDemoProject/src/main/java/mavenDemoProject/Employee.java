package mavenDemoProject;

public class Employee {
private String name;
private String empID;
private Device laptopDevice1;
Employee(){
	
}
Employee(String name, Device laptopDevice1)
{
	System.out.println("In Constructor");
	this.name = name;
	this.laptopDevice1 = laptopDevice1;
}
//public Device getDevice() {
//	return laptopDevice;
//}
//
//public void setDevice(Device device) {
//	this.laptopDevice = device;
//}

public String getEmpID() {
	return empID;
}


public Device getLaptopDevice1() {
	return laptopDevice1;
}
public void setLaptopDevice1(Device laptopDevice1) {
	System.out.println("In Setter: Set LaptopDevice");
	this.laptopDevice1 = laptopDevice1;
}
public void setEmpID(String empID) {
	this.empID = empID;

}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;

}


}

