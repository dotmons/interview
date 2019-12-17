package hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SockMerchantProblem {

	public SockMerchantProblem() {

	}

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int nValue = 0;
		int count = 0;

		Arrays.sort(ar);

		while (ar.length - 2 >= nValue) {
			if (ar[nValue] == ar[nValue + 1]) {
				nValue = nValue + 2;
				count++;
			} else {
				nValue++;
			}
		}

		return count;
	}

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int rem = c.length%2;
		int evenCount = c.length/2;
		
		for (int i=1; i<=evenCount; i++){
			int numb = i*2;
			if (c[numb]==0){
				
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		SockMerchantProblem sock = new SockMerchantProblem();
		int ar[] = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println("Total pair : " + SockMerchantProblem.sockMerchant(4, ar));
	}
}
