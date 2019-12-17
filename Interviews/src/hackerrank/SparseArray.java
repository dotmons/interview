package hackerrank;

public class SparseArray {

	public SparseArray() {
		// TODO Auto-generated constructor stub
		String[] strings = { "aba", "baba", "aba", "xzxb" };
		String[] queries = { "aba", "xzxb", "ab" };

		int output[] = (matchingStrings(strings, queries));
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
		}
	}
	
//hashmap .. aba 2; baba: 1
	static int[] matchingStrings(String[] strings, String[] queries) {

		int counter[] = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			counter[i] = getStringMatcher(strings, queries[i]);
		}
		return counter;
	}

	public static int getStringMatcher(String[] strings, String query) {
		int counter = 0;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals(query)) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparseArray sa = new SparseArray();

	}

}
