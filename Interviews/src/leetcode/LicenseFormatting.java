package leetcode;

public class LicenseFormatting {

	public LicenseFormatting() {

		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}

	private class Stack {
		int count = -1;
		String stackarray[];

		public Stack(int n) {
			stackarray = new String[n];
		}

		public void push(String data) {
			stackarray[++count] = data;
		}

		public String getStack() {
			String a = "";
			for (int i = count - 1; i >= 0; i--) {
				a += stackarray[i];
			}
			return a;
		}
	}

	public String licenseKeyFormattingStringBuilder(String S, int K) {
		int tempK = 0;
		Stack stack = new Stack(S.length() + 1);
		StringBuilder st = new StringBuilder();
		for (int i = S.length() - 1; i >= 0; i--) {

			if (!S.substring(i, i + 1).equals("-")) {

				if (tempK++ < K) {
					st.append(S.substring(i, i + 1).toUpperCase());
				} else {
					st.append("-");
					st.append(S.substring(i, i + 1).toUpperCase());
					tempK = 1;
				}
			}

		}
		return st.reverse().toString();
	}

	public String licenseKeyFormatting(String S, int K) {
		int tempK = 0;
		java.util.Stack<String> stack = new java.util.Stack<String>();
		int counter = 0;
		for (int i = S.length() - 1; i >= 0; i--) {

			if (!S.substring(i, i + 1).equals("-")) {

				if (tempK++ < K) {
					stack.push(S.substring(i, i + 1).toUpperCase());
					counter++;
				} else {
					stack.push("-");
					stack.push(S.substring(i, i + 1).toUpperCase());
					tempK = 1;
					counter=counter+2;
				}
			}

		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i<counter; i++) {
			builder.append(stack.pop());
			//System.out.println("|||> "+stack.pop());	
		}
		
		return builder.toString();
	}

	public static void main(String[] args) {
		LicenseFormatting licenseFormatting = new LicenseFormatting();
	}
}
