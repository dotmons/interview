package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetRemoveDuplicates {

	public SetRemoveDuplicates() {

		testListSet();

		testLinkedList();

	}

	public void testLinkedList() {
		LinkedList<String> object = new LinkedList<String>();
		object.add("A");
		object.add("B");
		object.addLast("C");
		object.addFirst("D");
		object.add(2, "E");
		object.add("F");
		object.add("G");
		System.out.println("Linked list : " + object);

		// Removing elements from the linked list
		object.remove("B");
		object.remove(3);
		object.removeFirst();
		object.removeLast();
		System.out.println("Linked list after deletion: " + object);

		// Finding elements in the linked list
		boolean status = object.contains("E");

		if (status)
			System.out.println("List contains the element 'E' ");
		else
			System.out.println("List doesn't contain the element 'E'");

		// Number of elements in the linked list
		int size = object.size();
		System.out.println("Size of linked list = " + size);

		// Get and set elements from linked list
		Object element = object.get(2);
		System.out.println("Element returned by get() : " + element);
		object.set(2, "Y");
		System.out.println("Linked list after change : " + object);
	}

	public void testListSet() {
		ArrayList<String> listValue = new ArrayList<String>();
		listValue.add("Dotun");
		listValue.add("Sule");
		listValue.add("Bola");
		listValue.add("Dotun");
		listValue.add("Funmi");

		// Does not accept duplicates
		Set<String> setValue = new HashSet<>();
		setValue.addAll(listValue);

		Iterator<String> it = listValue.iterator();

		while (it.hasNext()) {
			System.out.println("Iterator value: " + it.next());
		}

		// Used to sort data and does not accept duplicates
		Set<String> tree_Set = new TreeSet<String>(listValue);
		System.out.println(tree_Set);

		// To get unique list from the available content:
		// [1, 3, 2, 4, 8, 9, 0]
		// [1, 3, 7, 5, 4, 0, 7, 5]

		ArrayList<Integer> listA = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));
		ArrayList<Integer> listB = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));

		System.out.println("TreeSet sample: " + listA);
		System.out.println("TreeSet sample:" + listB);

		Set<Integer> uniqueSetList = new TreeSet<Integer>(listA);
		uniqueSetList.addAll(listB);
		System.out.println("Unique List using TreeSet : " + uniqueSetList);

		printMe("To get the intersection: Intersection : [0, 1, 3, 4]");
		uniqueSetList = new TreeSet<Integer>(listA);
		uniqueSetList.retainAll(listB);
		printMe("Intersection of set, expected 0,1,3,4", uniqueSetList.toString());

		printMe("To get the difference: Difference : [2, 8, 9]");
		uniqueSetList = new TreeSet<Integer>(listA);
		uniqueSetList.removeAll(listB);
		printMe("Difference between ListA and ListB", uniqueSetList.toString());
	}

	public void printMe(String output) {
		System.out.println("Output:>> " + output);
	}

	public void printMe(String header, String output) {

		System.out.println("\n<Header:> " + header + "\n Output:" + output);

	}

	public static void main(String[] arg) {
		new SetRemoveDuplicates();
	}
}
