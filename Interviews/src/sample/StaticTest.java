package sample;

public class
StaticTest {

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

	static void sortInteger(){
		int a = 3;
		int b = 2;
		int c = 7;

		int max = Math.max(Math.max(a,b),c );
		int min = Math.min(Math.min(a,b),c );
		int mid = a + b + c - max - min;

		System.out.println("Max: " + max + " Min: " + min + " Mid: " + mid);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortInteger();
		StaticTest a = new StaticTest();
		a.addUser("Dotun", "Adeoye");
		a.addUser("Lala", "Ogba");
		a.addUser("Lol", "RR");
		
		StaticTest b = new StaticTest();
		b.addUser("YY", "PP");
	}

}
