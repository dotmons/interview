package leetcode;

public class PowerOfTwo {

	public PowerOfTwo() {
		// System.out.println(powerOfTwo(1));
		// System.out.println(powerOfTwo(6));
		System.out.println(isPowerOfTwo(65536));
		System.out.println(isPowerOfTwoBetter(65536));
	}

	boolean isPowerOfTwo(int n) {
		return (powerOfTwoBool(n) != -1);
	}

	long powerOfTwoBool(long n) {

		return n == 1 ? 1 : n == 2 ? 1 : n % 2 == 0 ? powerOfTwoBool(n / 2) : -1;
	}

	public boolean isPowerOfTwoBetter(int n) {

		long i = 1;
		while (i < n) {
			i *= 2;
		}
		return i == n;
	}

	public static void main(String[] args) {
		PowerOfTwo powerOfTwo = new PowerOfTwo();
	}

}
