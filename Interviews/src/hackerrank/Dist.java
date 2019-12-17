package hackerrank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Dist {

	private static final int MAX = 6; 
	
	public Dist() {

		
		LinkedHashMap<Integer, String> li_hash_map = new LinkedHashMap<Integer, String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
				return size() > MAX;
			}
		};
		// Adding elements using put()
		li_hash_map.put(0, "Welcome");
		li_hash_map.put(1, "To");
		li_hash_map.put(2, "The");
		li_hash_map.put(3, "World");
		li_hash_map.put(4, "Of");
		li_hash_map.put(5, "geeks");

		System.out.println("" + li_hash_map);

		// Adding more elements
		li_hash_map.put(6, "GeeksforGeeks");

		// Displying the map after adding one more element
		System.out.println("" + li_hash_map);

		// Adding more elements
		li_hash_map.put(7, "Hello");

		// Displying the map after adding one more element
		System.out.println("" + li_hash_map);

	}

	public static void main(String[] args) {
		new Dist();
	}
}
