package amz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {

	public PhoneNumberCombination() {
		// TODO Auto-generated constructor stub
		System.out.println(letterCombinations("23"));
		//testingLinkeList();

	}

	public List<String> letterCombinations_(String digits) {
		Map<Character, String> hp = new HashMap<Character, String>();
		hp.put('2', "ABC");
		hp.put('3', "DEF");
		hp.put('4', "GHI");
		hp.put('5', "JKL");
		hp.put('6', "MNO");
		hp.put('7', "PQRS");
		hp.put('8', "TUV");
		hp.put('9', "WXYZ");

		for (char a : digits.toCharArray()) {

		}

		return null;
	}
	
	public void testingLinkeList(){
		LinkedList<String> ans = new LinkedList<String>();
		ans.add("p");	ans.add("i");
		System.out.println("List::" + ans.peek().length());
	}

	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		System.out.println("List::" + ans.peek().length());
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			
			while (ans.peek().length() == i) {
				System.out.println(i + " : " + ans.peek().length());
				String t = ans.remove();
				System.out.println(":::t:::"+t+":");
				char[] ad = mapping[x].toCharArray();
				
				for (int y=0; y<ad.length; y++){			
					
					ans.add(t + ad[y]);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneNumberCombination phoneNumberCombination = new PhoneNumberCombination();
	}

}
