package hackerrank;

import java.util.ArrayList;
import java.util.Collections;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
class GCD {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

	public GCD() {
		int[] arr = {48,18};
		System.out.println("Starting");
		System.out.println(generalizedGCD(2, arr));
	}

	public static void main(String[] args) {
		new GCD();
	}

	public int generalizedGCD(int num, int[] arr) {

		ArrayList<Integer> arrl = new ArrayList<Integer>();

		for (int ad : arr) {
			arrl.add(ad);
		}
		// WRITE YOUR CODE HERE

		// arrl.add(arr);

		Collections.sort(arrl);
		int init = arrl.get(0);
		arrl.remove(0);		
		int divider = 3;
		divider = getDivider(init, divider);		
		int newDivid = init/divider;

		while (!isDividerTrueValue(arrl, newDivid)) {
			newDivid = init/divider;
		}

		return newDivid;
	}

	public boolean isDividerTrueValue(ArrayList<Integer> arrl, int divider) {
		int init = 0;
		for (int numb : arrl) {
			init = numb % divider == 0 ? init : init++;
		}
		return (init==0);
	}
	
	public int getDivider(int init, int divider) {
		while (init % divider != 0) {
			divider++;
		}
		return divider;
	}

	// METHOD SIGNATURE ENDS

}