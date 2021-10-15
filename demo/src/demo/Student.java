package demo;

public class Student {
String name;
static int marks;

	public static void main(String[] args) {
	Student s = new Student();
	s.name = "Tharunya";
	s.marks = 100;
	Student s1 = new Student();
	s1.name="Subham";
	s1.marks = 45;
	System.out.println("name: "+s.name+" "+"marks: "+s.marks);
	System.out.println("name: "+s1.name+" "+"marks: "+s1.marks);
	}

}