package hackerrank;

public class MinimumSwaps {

	public MinimumSwaps() {
		int arr[] = { 7, 1, 3, 2, 4, 5, 6 };

		//System.out.println(assertEquals(getMinimumSwap(arr), 5));
		//System.out.println(assertEquals(getMinimumSwap(new int[] { 4, 3, 1, 2 }), 3));
		//System.out.println(assertEquals(getMinimumSwap(new int[] { 2, 3, 4, 1, 5 }), 3));
		//System.out.println(assertEquals(getMinimumSwap(new int[] { 1, 3, 5, 2, 4, 6, 7 }), 3));
		System.out.println(assertEquals(getMinimumSwap(new int[] { 3, 7, 6, 9, 1, 8, 10, 4, 2, 5 }), 9));

	}

	public boolean assertEquals(int provided, int expected) {
		if (!(expected == provided))
			System.out.println("Expected:" + expected + " Provided: " + provided);
		return expected == provided;
	}

	public int getMinimumSwapp(int arr[]) {

		int change = 0;

		for (int b = 0; b < arr.length; b++) {
			for (int i = 0; i < arr.length; i++) {

				if (arr[b] != b + 1) {
					if (arr[i] == (b + 1)) {
						int temp = arr[i];
						arr[i] = arr[b];
						arr[b] = temp;
						change++;
						break;
					}
				}

			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println("Array:: " + arr[i]);
		}

		return change;
	}

	public int getMinimumSwap(int arr[]) {

		int total = 0;
		int change = 0;
		int totalSum = 0;
		int incre = 1;
		boolean isMax = false;

		do {
			if (incre != arr[incre - 1]) {
				int temp = arr[incre - 1];
				arr[incre - 1] = arr[temp - 1];
				arr[temp - 1] = temp;
				change++;
				totalSum++;
			}
			if (!isMax) {
				incre++;
			} else {
				incre--;
			}

			if (incre == arr.length) {
				isMax = true;
				totalSum = totalSum == 0 ? -1 : 0;
			}
			if (incre == 1) {
				isMax = false;
				totalSum = totalSum == 0 ? -1 : 0;
			}
			System.out.println("Total executionL:" + total++);
		} while (totalSum != -1);

		return change;
	}

	public int[] getSwappedValues(int n, int arr[], int value) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				arr[i] = value;
				break;
			}
		}
		return arr;
	}

	public int getMinimumSwaps(int arr[]) {
		int counter = 1;
		int change = 0;
		for (int b = arr.length - 1; b >= 0; b--) {
			for (int i = arr.length - 1; i >= 0; i--) {

				if (arr[i] < (i + 1)) {
					if (arr[counter - 1] == counter) {
						counter++;
					} else {
						int temp = arr[i];
						arr[i] = arr[counter - 1];
						arr[counter - 1] = temp;
						change++;
					}
					// counter = counter==arr[counter-1]?counter:counter++;
				}
				// System.out.println("Array:: " + arr[i] + " ii> " + i);
				// for (int j = arr.length - 1; j >= 0; j--) {
				// System.out.println("<<<Array::>>> " + arr[j]);
				// }
				// System.out.println("");
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println("Array:: " + arr[i]);
		}

		return change;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSwaps ms = new MinimumSwaps();
	}

}
