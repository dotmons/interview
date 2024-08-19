package leetcode;

public class SumTwoIntegers {

	// Sum two integers without the use of +
	public SumTwoIntegers(){
		System.out.println((4&3)<<1);
		System.out.println((4^3));
		//System.out.println(sumNumbers(5,8));

		// ^ bitwise xor: returns bit operator where only one condition is true (1 and 0) only 5^2 (converts
		// to binary and performs the operation)

		// & Converts to binary and does the and operation
		// << 1 moves the bits one time to the left
	}

	int sumNumbers(int a, int b){
		while (b!= 0){
			int temp = (a&b)<<1;
			a = a^b;
			b = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SumTwoIntegers();

	}

}
