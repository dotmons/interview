package datastructure;

import java.util.NoSuchElementException;

public class LinkedList {

	private class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	private Node first;
	int size = 0;

	public void addFirst(int item) {

		Node node = new Node(item);
		node.next = first;
		first = node;
		size++;
	}

	public void addLast(int data) {
		Node node = new Node(data);

		if (first == null) {
			first = node;
		} else {
			Node n = first;

			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
		size++;
	}

	public void deleteFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		} else {
			first = first.next;
		}
		size--;
	}

	public void deleteLast() {
		Node n = first;
		int i = 0;
		while (n != null) {
			i++;
			n = n.next;
		}
		n = first;
		while (n != null) {
			if (i - 2 == 0) {
				n.next = null;
				break;
			} else {
				n = n.next;
			}
			i--;
		}

		// first = n;
	}

	public boolean contains(int value) {

		Node n = first;

		while (n.next != null) {
			if (n.value == value) {
				return true;
			} else {
				n = n.next;
			}
		}
		return value == n.value;
	}

	public boolean contain(int value) {

		return !(indexOf(value) == -1);
	}

	public int indexOf(int value) {

		Node n = first;
		int ind = 0;
		if (first != null) {
			while (n != null) {
				if (n.value == value) {
					return ind;
				}
				n = n.next;
				ind++;
			}
		}

		return -1;
	}

	public void printStack() {
		Node n = first;
		while (n != null) {
			System.out.println(n.value);
			n = n.next;
		}
	}

	public void printStack(Node n) {
		while (n.next != null) {
			System.out.println(n.value);
			n = n.next;
		}
		System.out.println(n.value);
	}

	public void deleteLasts() {
		Node n = first;
		int counter = 0;

		while (n != null) {
			if (++counter == size - 1) {
				n.next = null;
				break;
			}
			n = n.next;
		}
	}

	public void getReverseList() {
		Node temp = first;
		Node prev = null;
		Node next = null;
		Node curr = first;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		first = prev;

	}
	
	public void reverseLinkedListRecursion(){
		Node n = first;
		print(n);
	}
	
	//
	public void revereseLinkedListUsingStack(){
		
	}

	void print(Node n) {
		
		if (n == null) {
			return;
		}
		print(n.next);
		System.out.println((n.value));

		

	}
}
