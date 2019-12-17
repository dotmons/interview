package hackerrank;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Pentagon {

	public Pentagon() {

		int nt = 12;
		ArrayList pn = new ArrayList();

		for (int n = 1; n < nt; n++) {
			pn.add((n * (3 * n - 1)) / 2);
//			
		}

		int init = Integer.parseInt(String.valueOf(pn.get(0)));

		for (int i = pn.size() - 1; i >= 0; i--) {
			// System.out.println(i);
			for (int k = 0; k < pn.size(); k++) {
				int a = Integer.parseInt(String.valueOf(pn.get(i))) + init;
				int b = Math.abs(Integer.parseInt(String.valueOf(pn.get(i))) - init);
				// System.out.println("A:" + pn.get(i) + " B: " + init);
				if (isValid(a, pn)) {
					System.out.println("1111:    A: " + pn.get(i) + " B: " + init + " = " + a);
				}
				if (isValid(b, pn)) {
					System.out.println("2222:    A: " + pn.get(i) + " B: " + init + " = " + b);
				}
				
				init = Integer.parseInt(String.valueOf(pn.get(k)));
			}
		}
		System.out.println("Not Statisfied");

	}

	public boolean isValid(int numb, ArrayList pn) {
		int a = 0;

		for (int i = pn.size() - 1; i >= 0; i--) {
			a = Integer.parseInt(String.valueOf(pn.get(i)));
			if (numb == a) {				
				return true;
			}
		}
		// System.out.println("A = " + a + " B = " + numb);
		return false;
	}

	public static void main(String[] args) {
		new Pentagon();
	}
}
