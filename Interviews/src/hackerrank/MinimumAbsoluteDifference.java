package hackerrank;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

	public MinimumAbsoluteDifference() {

		int arr[] = { -2, 2, 4 };
		System.out.println(isAssertEquals(2, minimumAbsoluteDifference(arr)));
		System.out.println(isAssertEquals(3, minimumAbsoluteDifference(new int[]{3,-7,0})));
	}

	public boolean isAssertEquals(int expectedValue, int providedValue) {
		return expectedValue == providedValue;
	}

	static int minimumAbsoluteDifference(int[] arr) {

		if (arr.length<2){
			return -1;
		}
		
		Arrays.sort(arr);
		int sumTotal = Math.abs(arr[0] - arr[1]);

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				int compute = Math.abs(arr[i] - arr[j]);
				sumTotal = compute < sumTotal ? compute : sumTotal;
			}

		}
		return sumTotal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
	}

}
