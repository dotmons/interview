package goog;

import java.util.HashSet;

public class TotalSum {

	public TotalSum() {
		
		System.out.println(isSumPairInList(getListA(), 8));
		System.out.println(isSumPairInList(getListB(), 8));
		//test();
	}

	boolean isSumPairInList(int[] arr, int sum) {

		int j = arr.length - 1;
		int k = 0;
		int prSum = 0;

		for (int i = 0; i < arr.length; i++) {
			prSum = (arr[k] + arr[j]);
			if (prSum == sum) {
				return true;
			} else {
				if (prSum > sum) {
					j--;
				} else {
					k++;
				}
			}
		}

		return false;
	}
	
	boolean hasPairWithSum(int[] arr, int sum) {
	
		HashSet<Integer> hashSetCompliments = new HashSet<Integer>();
		
		for (int value : arr){
			//if (hashSetCompliments.contains(value)!=hashSetCompliments.size())
			{
				return true;
			}
		}
		
		return false;
	}

	public int[] getListA() {
		int a[] = { 1, 2, 3, 9, 10 };
		return a;
	}

	public int[] getListB() {
		int a[] = { 1, 4, 2, 4 };
		return a;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TotalSum totalSum = new TotalSum();
	}

}
