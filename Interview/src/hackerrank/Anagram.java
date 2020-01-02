package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Anagram {

	public Anagram() {
		// System.out.println(isAnagram("Stressed", "Desserts"));
		// System.out.println(isFastAnagram("Stressed", "Desserts"));

		// System.out.println(numberNeeded("fcrxzwscanmligyxyvym",
		// "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
		System.out.println(numberNeeded("abccc", "cdec"));
		// System.out.println(getDifferenceBetweenStrings("oshowman", "woman"));
		// getDifference("oshowmana", "woman");
		// testDuplicates(castStringToList("oshowman"),
		// castStringToList("woman"));
		// System.out.println(getDifferenceBetweenStrings("fcrxzwscanmligyxyvym",
		// "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));

		// r, x, w, s, m, l, i, g, x, v, m

		// [f, c, z, c, a, n, y, y, y]

		// [j, t, h, u, j, p, d, o, q, b, b, h, p, e, o, k, e]
	}

	public boolean isAnagram(String firstPhrase, String secondPhrase) {

		if (firstPhrase.length() != secondPhrase.length()) {
			return false;
		}

		char tempA[] = firstPhrase.toUpperCase().toCharArray();
		char tempB[] = secondPhrase.toUpperCase().toCharArray();

		Arrays.sort(tempA);
		Arrays.sort(tempB);

		firstPhrase = new String(tempA);
		secondPhrase = new String(tempB);

		return firstPhrase.equals(secondPhrase);

	}

	public boolean isFastAnagram(String firstPhrase, String secondPhrase) {
		if (firstPhrase.length() != secondPhrase.length()) {
			return false;
		}

		int counter = firstPhrase.length() - 1;

		for (int i = 0; i < firstPhrase.length(); i++) {
			if (firstPhrase.toUpperCase().charAt(i) != secondPhrase.toUpperCase().charAt(counter)) {
				return false;
			}
			counter--;
		}
		return true;
	}

	public ArrayList<String> castStringToList(String data) {

		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < data.length(); i++) {
			output.add(String.valueOf(data.charAt(i)));
		}
		return output;
	}

	public static int numberNeeded(String first, String second) {
		int[] lettercounts = new int[26];
		for (char c : first.toCharArray()) {
			lettercounts[c - 'a'] = lettercounts[c - 'a'] + 1;
			System.out.println("Char::> " + c + "   :::   (" + c + "-a): " + (c - 'a') + "  lettercounts[" + c
					+ " - 'a']: " + lettercounts[c - 'a']);
		}

		for (char c : second.toCharArray()) {
			lettercounts[c - 'a'] = lettercounts[c - 'a'] - 1;
			System.out.println("Char::> " + c + "   :::   (" + c + "-a): " + (c - 'a') + "  lettercounts[" + c
					+ " - 'a']: " + lettercounts[c - 'a']);
		}
		int result = 0;
		for (int i : lettercounts) {
			result += Math.abs(i);
		}
		return result;
	}

	public int getDifference(String firstPhraseA, String secondPhraseB) {
		ArrayList<String> firstPhrase = castStringToList(firstPhraseA);
		ArrayList<String> secondPhrase = castStringToList(secondPhraseB);

		System.out.println("firstPhrase:" + firstPhrase);
		System.out.println("secondPhrase:" + secondPhrase);
		int counter = 0;
		for (int i = 0; i < firstPhrase.size(); i++) {
			if (secondPhrase.contains(firstPhrase.get(i))) {
				counter++;
				System.out.println(">>" + firstPhrase.get(i));
				// firstPhrase.remove(firstPhrase.get(i));
			}
		}

		System.out.println("Final content: " + firstPhrase);
		return counter;
	}

	public int getDifferenceBetweenStrings(String firstPhraseA, String secondPhraseB) {

		ArrayList<String> firstPhrase = castStringToList(firstPhraseA);
		ArrayList<String> firstPhraseLL = castStringToList(firstPhraseA);
		ArrayList<String> firstPhraseBB = castStringToList(firstPhraseA);
		ArrayList<String> firstPhaseClone = castStringToList(firstPhraseA);
		ArrayList<String> secondPhrase = castStringToList(secondPhraseB);
		ArrayList<String> secondPhraseLL = castStringToList(secondPhraseB);
		ArrayList<String> secondPhraseBB = castStringToList(secondPhraseB);
		ArrayList<String> secondPhraseClone = castStringToList(secondPhraseB);

		secondPhrase.removeAll(firstPhaseClone);
		firstPhrase.removeAll(secondPhraseClone);

		secondPhraseLL.retainAll(firstPhraseLL);
		firstPhraseBB.retainAll(secondPhraseBB);

		System.out.println(firstPhrase);
		System.out.println(secondPhrase);
		System.out.println("LL::: >>>>        " + firstPhraseBB);
		System.out.println("LL::: >>>>        " + secondPhraseLL);

		Set<String> valueA = new TreeSet<String>(castStringToList(firstPhraseA));
		Set<String> valueB = new TreeSet<String>(castStringToList(secondPhraseB));

		int totalRemoval = (firstPhraseA.length() - valueA.size()) + (secondPhraseB.length() - valueB.size());

		// System.out.println("firstPhraseA.length():"+firstPhraseA.length());
		// System.out.println("valueA.size():"+valueA.size());
		// System.out.println("secondPhraseB.length():"+secondPhraseB.length());
		// System.out.println("valueB.size():"+valueB.size());

		// System.out.println(getDifferenceBetweenStrings("oshowman", "woman"));

		System.out.println("Sizer :: " + totalRemoval);

		return (firstPhrase.size() + secondPhrase.size() + totalRemoval);
		// return (firstPhaseSize - firstPhrase.size()) + (secondPhrase.size() -
		// firstPhrase.size());

	}

	public void testDuplicates(ArrayList<String> a, ArrayList<String> b) {

		ArrayList<String> newList = new ArrayList<String>();
		// castStringToList("oshowman"), castStringToList("woman")
		for (String dd : a) {

			// if ()

			if (!b.contains(dd)) {
				System.out.println(dd);
				newList.add(dd);
			}
		}
	}

	// Function to remove duplicates from an ArrayList
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

		// Create a new ArrayList
		ArrayList<T> newList = new ArrayList<T>();

		// Traverse through the first list
		for (T element : list) {

			// If this element is not present in newList
			// then add it
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}

		// return the new list
		return newList;
	}

	public static void main(String[] args) {
		Anagram an = new Anagram();
	}
}
