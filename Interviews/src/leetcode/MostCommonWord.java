
package leetcode;

import java.util.*;
import java.util.Map.Entry;

public class MostCommonWord {

	public MostCommonWord() {
		// TODO Auto-generated constructor stub
		String paragraph = "Bob hit a ball, the hit ball flew far after it was hit.";
		String[] banned = { "hit" };
		System.out.println(mostCommonWord(paragraph, banned));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		String wordValue = "";
		int mix = 0;
		Set<String> setAma = new HashSet<String>();
		Map<String, Integer> mapAma = new HashMap<String, Integer>();

		for (String data : banned) {
			setAma.add(data);
		}

		for (String word : paragraph.split("\\W+")) {
			if (!(setAma.contains(word.toLowerCase()))) {
				if (mapAma.containsKey(word.toLowerCase())) {
					int temp = mapAma.get(word);
					if (temp > mix) {
						wordValue = word;
					}
					mapAma.put(word, temp + 1);
				} else {
					mapAma.put(word, 1);
				}
			}
		}


		return wordValue;
	}

	public static void main(String[] args) {
		MostCommonWord mostCommonWord = new MostCommonWord();
		// TODO Auto-generated method stub

	}

}
