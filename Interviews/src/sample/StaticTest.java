package sample;

public class StaticTest {

    String lastName;
	String firstName;
	static int count = 0;
	
	public StaticTest(){
	
	}
	
	public static void addUser(String firstName, String lastName){
		lastName = lastName;
		firstName = firstName;
		count++;
		System.out.println("Lastname: " + lastName + " Firstname: " + firstName + " Total members: " + count);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticTest a = new StaticTest();
		a.addUser("Dotun", "Adeoye");
		a.addUser("Lala", "Ogba");
		a.addUser("Lol", "RR");
		
		StaticTest b = new StaticTest();
		b.addUser("YY", "PP");
	}

}
