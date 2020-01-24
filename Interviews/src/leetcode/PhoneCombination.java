package leetcode;

import java.util.*;

public class PhoneCombination {

	public PhoneCombination() {

		System.out.println(getPhoneCombination("23"));
	}

	public java.util.List<String> getPhoneCombination(String number) {
		java.util.List<String> result = new ArrayList<String>();

		if (number.length() == 0 || number == null) {
			return result;
		}

		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		// 23

		for (int i = 0; i < mapping[2].length(); i++) {
			for (int j = 0; j < mapping[3].length(); j++) {

				result.add(mapping[2].substring(i, i + 1) + mapping[3].substring(j, j + 1));
			}
		}

		return result;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneCombination phoneCombination = new PhoneCombination();
	}

}
