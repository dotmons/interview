package sample;

import java.util.regex.Pattern;

public class PatternMatching {

	public PatternMatching() {

		String text = "This is the text to be searched " + "for occurrences of the pattern.";

		String pattern = ".*is.*";

		boolean matches = Pattern.matches(pattern, text);

		System.out.println("matches = " + matches);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PatternMatching();
	}

}
