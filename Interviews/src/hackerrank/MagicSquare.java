package hackerrank;

public class MagicSquare {

	MagicSquare() {

		int[][] s = new int[3][3];
		s[0][0] = 2;
		s[0][1] = 5;
		s[0][2] = 4;
		s[1][0] = 4;
		s[1][1] = 6;
		s[1][2] = 9;
		s[2][0] = 4;
		s[2][1] = 5;
		s[2][2] = 2;

		System.out.println(assertEquals(formingMagicSquare(s), 16));
	}

	public boolean assertEquals(int suppliedValue, int expectedValue) {
		System.out.println("suppliedValue:" + suppliedValue + " expectedValue:" + expectedValue);
		return suppliedValue == expectedValue;
	}

	static int formingMagicSquare(int[][] s) {

		java.util.ArrayList<Integer> sortedInt = new java.util.ArrayList<>();

		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				sortedInt.add(s[i][j]);
			}
		} 
		int counter = 0;
		java.util.Collections.sort(sortedInt);
		for (int i = 0; i < sortedInt.size(); i++) {
			if (sortedInt.get(i) != (i + 1)) {
				counter += Math.abs(sortedInt.get(i) - (i + 1));
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MagicSquare ms = new MagicSquare();

	}

}
