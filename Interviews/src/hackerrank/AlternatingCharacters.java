package hackerrank;

public class AlternatingCharacters {

	public AlternatingCharacters() {

		System.out.println(assertEquals(alternatingCharacters("AAAA"), 3));
		System.out.println(assertEquals(alternatingCharacters("BBBBB"), 4));
		System.out.println(assertEquals(alternatingCharacters("ABABABABB"), 1));
		System.out.println(assertEquals(alternatingCharacters("BABABA"), 0));
		System.out.println(assertEquals(alternatingCharacters("AAABBB"), 4));

	}

	static int alternatingCharacters(String s) {

		int counter = 0;
		int expectedCharValue = ((int) 'A') + ((int) 'B');

		if (!(s.length() >= 1) && (s.length() <= 10000)) {
			return -1;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if ((((int) s.charAt(i)) + ((int) s.charAt(i + 1))) != expectedCharValue) {
				counter++;
			}
		}

		return counter;

	}

	public boolean assertEquals(int value, int ansValue) {
		return value == ansValue;
	}

	public static void main(String[] args) {
		AlternatingCharacters ac = new AlternatingCharacters();
	}
}
