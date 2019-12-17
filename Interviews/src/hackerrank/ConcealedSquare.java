package hackerrank;

import java.math.BigInteger;

public class ConcealedSquare {

	public ConcealedSquare() {
		// int n=99999999;
		boolean isDone = false;
		int nn = 0;
		// BigInteger k = new BigInteger("1020304451627983990");
							  
		while (!isDone) {
			

			BigInteger n = new BigInteger("138853089");
			n = BigInteger.valueOf(n.intValue() + nn++);
			// System.out.println(((n.pow(2))));

			if (isConcealed(String.valueOf(n.pow(2)))) {
				isDone = true;
				System.out.println("Answer :::: "+String.valueOf(n + ">>" + n.pow(2)));
			} else {
				System.out.println(String.valueOf(n + ">>" + n.pow(2)));
			}
		}
		// 1020304451627983990
		// System.out.println(isConcealed("1020384253607680980"));
	}

	public static void main(String[] args) {
		new ConcealedSquare();
	}

	public boolean isConcealed(String value) {
		// System.out.println(value);
		// 1020384253607680980
		int length = value.length();
		int nn = 0;
		int coun = 0;
		int ll = 0;

		for (int i = 0; i < length; i = i + 2) {
			// nn = (i+1==10)?++ll:(i+1);
			nn = ++ll;
			if (ll == 10) {
				nn = 0;
			}
			//

			if (!value.substring(i, i + 1).equals((String.valueOf(nn)))) {
				// System.out.println(value.substring(i, i + 1) + " <--> " +
				// (nn));
				coun++;
			}
			// 1020394259506852100
		}
		// System.out.println(coun);
		return coun == 0;
	}
}
