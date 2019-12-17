package hackerrank;

public class BirthdayCake {

	public BirthdayCake() {
		System.out.println(birthdayCakeCandles(new int[] {5,5,5,5,5}));
	}

	static int birthdayCakeCandles(int[] arr) {
		
		int max = 0;
		int counter = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}			
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==max){
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		BirthdayCake bc = new BirthdayCake();
	}

}
