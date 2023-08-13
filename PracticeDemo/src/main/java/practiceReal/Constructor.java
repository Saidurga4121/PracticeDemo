package practiceReal;

public class Constructor 
{
	String name;
	int age;
	
	public Constructor()
	{
		System.out.println("default constructor");
	}
	
	public Constructor(String name ,int age)
	{
		// this.classvaribales=local varibales 
		// this keyword is used to refer the current class varibales.
		this.name=name;
		this.age=age;
	}
	
	
	public static void main(String[] args)
	{
		// Constructor obj= new Constructor();
		Constructor obj1= new Constructor("sai",10);
		System.out.println(obj1.name + " is name");
		System.out.println(obj1.age + " is age");
	}

}
