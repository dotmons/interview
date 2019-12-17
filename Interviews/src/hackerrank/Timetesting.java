package hackerrank;

public class Timetesting {

	public static void main(String[] args) {
		// Merge sort test
		long startTime = System.currentTimeMillis();
		int cou = 1000;
		int mergearr[] = new int[cou];// { 3, 7, 6, 9, 1, 8, 10, 4, 2, 5 };
		int quickarr[] = new int[cou];
		int dotarr[] = new int[cou];
		//int dotarr[] = { 3, 7, 9, 1, 8, 10, 4, 2, 5 };

		int nn = 0;
		for (int i = mergearr.length; i >= 1; i--) {
			mergearr[nn++] = i;
		}
		nn = 0;
		for (int i = quickarr.length; i >= 1; i--) {
			quickarr[nn++] = i;
		}
		nn = 0;
		for (int i = dotarr.length; i >= 1; i--) {
			dotarr[nn++] = i;
		}

		// printArray(dotarr);

		MergeSort ob = new MergeSort();
		ob.sort(mergearr, 0, mergearr.length - 1);
		System.out.println("Time taken by MergeSort: " + (System.currentTimeMillis() - startTime) + "ms");

		// Quick sort test
		startTime = System.currentTimeMillis();
		//QuickSort os = new QuickSort();
		//int n = quickarr.length;
		//os.sort(quickarr, 0, n - 1);
		//System.out.println("Time taken by QuickSortSort: " + (System.currentTimeMillis() - startTime) + "ms");

		// Dotmons sort test
		startTime = System.currentTimeMillis();
		DotmonsSort ds = new DotmonsSort();
		ds.getMinimumSwap(dotarr);
		System.out.println("Time taken by DotmonsSort: " + (System.currentTimeMillis() - startTime) + "ms");
		printArray(dotarr);
	}

	static void printArray(int arr[]) {
		for (int num : arr) {
			System.out.println(num);
		}
	}

}
