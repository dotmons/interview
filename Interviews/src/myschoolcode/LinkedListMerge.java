package myschoolcode;

import java.util.HashSet;

import myschoolcode.LinkedListMerge.Node;

public class LinkedListMerge {

	Node first;
	int count = 0;

	public class Node {
		int data;
		Node next;
		public Object first;
	}

	/*
	 * public void addLast(int data) { Node node = new Node(data);
	 * 
	 * if (first == null) { first = node; } else { Node n = first;
	 * 
	 * while (n.next != null) { n = n.next; } n.next = node; } size++; }
	 */

	public void addList(int data) {

		Node a = new Node();
		a.data = data;

		if (count > 0) {

			while (first.next != null) {
				first = first.next;
			}
			first.next = a;
		} else {
			first = a;
			first.next = null;
		}

		count++;
	}

	public LinkedListMerge() {

	}

	public HashSet<Node> getLinkedSet() {
		HashSet<Node> hs = new HashSet<Node>();
		if (first.next != null) {
			hs.add(first);
		}
		return hs;
	}

	public static void main(String[] args) {
		new LinkedListMerge();
	}

}
