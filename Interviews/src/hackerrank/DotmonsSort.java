package hackerrank;

public class DotmonsSort {

	public DotmonsSort() {
		System.out.println("Dotmons");
		// TODO Auto-generated constructor stub
		int arr[] = { 3, 6, 9, 1, 8, 10, 4, 2, 5 };
		for (int n : dotmonsSort(arr)) {
			System.out.println(n);
		}

	}

	public int[] dotmonsSort(int arr[]) {

		int totalSum = 0;
		int incre = 1;
		boolean isMax = false;

		do {
			if (arr[incre - 1] > arr[incre]) {
				int temp = arr[incre];
				arr[incre] = arr[incre - 1];
				arr[incre - 1] = temp;
				totalSum++;
			}
			if (!isMax) {
				incre++;
			} else {
				incre--;
			}

			if (incre == arr.length - 1) {
				isMax = true;
				totalSum = totalSum == 0 ? -1 : 0;
			}
			if (incre == 1) {
				isMax = false;
				totalSum = totalSum == 0 ? -1 : 0;
			}
		} while (totalSum != -1);

		return arr;
	}

	public int[] getMinimumSwap(int arr[]) {

		int totalSum = 0;
		int incre = 1;
		boolean isMax = false;

		do {
			if (incre != arr[incre - 1]) {
				int temp = arr[incre - 1];

				arr[incre - 1] = arr[temp - 1];
				arr[temp - 1] = temp;
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
		} while (totalSum != -1);

		return arr;
	}

	public static void main(String[] args) {
		DotmonsSort ds = new DotmonsSort();
	}
}
