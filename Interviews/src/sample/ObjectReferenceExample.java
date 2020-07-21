package sample;

public class ObjectReferenceExample {

	public static void main(String[] doYourBest) {
		int arr[] = new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		
		int n = 0;
		Simpson simpson = new Simpson();
		simpson.name = "Bola";
		System.out.println("Size B:" + arr[1]);
		transformIntoHomer(simpson, n, arr);
		System.out.println(simpson.name);
		System.out.println(n);
		
	}

	static void transformIntoHomer(Simpson s, int n, int arr[]) {
		s.name = "Homer";
		n = 50;
		arr[1] = 9;
		System.out.println("Size A:" + arr[1]);
	}

}

/*
 * 
 * If you determined that the value would change to 30, you are correct. It’s 30
 * because (again) Java passes object parameters by value. The number 30 is just
 * a copy of the value, not the real value. Primitive types are allocated in the
 * stack memory, so only the local value will be changed. In this case, there is
 * no object reference.
 * 
 * Array works as an object reference, just like creating an object
 */
class Simpson {
	String name;
}