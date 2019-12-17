package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentExtractor {

	/*
	 Nayeem loves counseling
	Sanjay has no watch
	So wait for a while
	None
	Imtiaz has a secret crush
	 */
	public ContentExtractor() {

		Scanner in = new Scanner(System.in);
		int testCases = 4;// Integer.parseInt(in.nextLine());
		String content = "<h1>Nayeem loves counseling</h1>\n<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\n<Amee>safat codes like a ninja</amee>\n<SA premium>Imtiaz has a secret crush</SA premium>";

		int i = 0;

		for (String val : content.split("\n")) {

			if (i == 0) {
				getTagValue(val);
			}
			i++;
		}

	}

	

	private List<String> getTagValues(final String str, Pattern TAG_REGEX) {
		final List<String> tagValues = new ArrayList<String>();
		final Matcher matcher = TAG_REGEX.matcher(str);
		while (matcher.find()) {
			tagValues.add(matcher.group(1));
		}
		return tagValues;
	}

	public String getTagValue(String value) {

		Pattern TAG_REGEX = Pattern.compile("(?<=\\<TD\\>)(\\s*.*\\s*)(?=\\<\\/TD\\>)", Pattern.DOTALL);
		String cont;
		System.out.println(Arrays.toString(getTagValues(value,TAG_REGEX).toArray()));

		for (int i = 0; i < value.length(); i++) {
			System.out.print(value.charAt(i));
		}

		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		ContentExtractor ce = new ContentExtractor();
	}

}
