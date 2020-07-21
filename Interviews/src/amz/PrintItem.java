package amz;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class PrintItem {

	public PrintItem() {

	}

	public void printEntry() {
		String input = "fun1 START T1 fun2 START T2 fun5 START T2.1 fun5 END T2.2 fun2 END T3 fun3 START T4 fun3 END T5 fun1 END T6 fun4 START T7 fun4 END T8";

		HashMap<String, String> hm = new HashMap<String, String>();

		int n = 1;
		StringBuilder key = new StringBuilder();
		StringBuilder value = new StringBuilder();

		for (String st : input.split(" ")) {
			if (st.contains("fun")) {
				key.append(st);
			}

			if (n % 3 == 0) {
				value.append(st);
				if (hm.containsKey(key.toString().trim())) {
					System.out.println(key + " " + value.toString() + "-" + hm.get(key.toString().trim()));
				} else {
					hm.put(key.toString(), value.toString());
				}
				key.setLength(0);
				value.setLength(0);
			}
			n++;

		}
		// Output: fun1 T6-T1 fun2 T3-T2 fun5 T2.2-T2.1 fun3 T5-T4 fun4 T8-T7
		Set<Entry<String, String>> st = hm.entrySet();

		for (Entry<String, String> ll : st) {
			// System.out.println(ll.getKey() + ": " + ll.getValue());
		}
	}

	public void printEntryTwo() {
		String input = "fun1 START T1 fun2 START T2 fun5 START T2.1 fun5 END T2.2 fun2 END T3 fun3 START T4 fun3 END T5 fun1 END T6 fun4 START T7 fun4 END T8";

		HashMap<String, String> hm = new HashMap<String, String>();

		int n = 1;
		StringBuilder key = new StringBuilder();
		StringBuilder value = new StringBuilder();

		for (String st : input.split(" ")) {
			if (st.contains("fun")) {
				key.append(st);
			}

			if (n % 3 == 0) {
				value.append(st);
				if (hm.containsKey(key.toString().trim())) {
					System.out.println(key + " " + value.toString() + "-" + hm.get(key.toString().trim()));
				} else {
					hm.put(key.toString(), value.toString());
				}
				key.setLength(0);
				value.setLength(0);
			}
			n++;

		}
		// Output: fun1 T6-T1 fun2 T3-T2 fun5 T2.2-T2.1 fun3 T5-T4 fun4 T8-T7
		Set<Entry<String, String>> st = hm.entrySet();

		for (Entry<String, String> ll : st) {
			// System.out.println(ll.getKey() + ": " + ll.getValue());
		}
	}

	public static void main(String[] args) {
		new PrintItem();
	}

}