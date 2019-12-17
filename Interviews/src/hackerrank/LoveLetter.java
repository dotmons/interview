package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LoveLetter {

	public LoveLetter() {

		System.out.println(equalAssert(theLoveLetterMystery("abc"), 2));
		System.out.println(equalAssert(theLoveLetterMystery("abcba"), 0));
		System.out.println(equalAssert(theLoveLetterMystery("abcd"), 4));
		System.out.println(equalAssert(theLoveLetterMystery("cba"), 2));
		
		System.out.println(equalAssert(theLoveLetterMystery("abbbbbbbbbbbbbbbbbbbbbbb"), 1));

	}

	static boolean equalAssert(int value, int counter) {

		return value == counter;
	}

	// Complete the theLoveLetterMystery function below.
	static int theLoveLetterMystery(String s) {
		int init = 0;
		int counter = 0;

		//if (isPalindrone(s)) {
		//	return 0;
		//}

		for (int i = s.length() - 1; i >= s.length() / 2; i--) {

			if (s.charAt(init) != s.charAt(i)) {
				counter += Math.abs((int) s.charAt(i) - (int) s.charAt(init));

				//if (isPalindrone((s.substring(0, i) + (char) ((int) s.charAt(i) - 1)))) {
				//	return counter;
				//}

			}
			init++;
		}
		return counter;
	}

	public static boolean isPalindrone(String value) { 
		return value.equals(new StringBuilder(value).reverse().toString());
	}

	public static void main(String[] args) {
		new LoveLetter();
	}

}
