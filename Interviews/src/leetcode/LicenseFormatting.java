package leetcode;

public class LicenseFormatting {

	/*
	You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.



Example 1:

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
	**/

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
