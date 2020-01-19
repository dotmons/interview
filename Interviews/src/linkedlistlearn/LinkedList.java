package linkedlistlearn;

public class LinkedList {

	private class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node() {
		}
	}

	private Node first;

	public void addFirst(int item) {

		Node node = new Node(item);
		node.next = first;
		first = node;

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
	}

	public void deleteFirst() {

		Node n = first;
		first = n.next;
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
		while (n.next != null) {
			System.out.println(n.value);
			n = n.next;
		}
		System.out.println(n.value);
	}

	public void printStack(Node n) {
		while (n.next != null) {
			System.out.println(n.value);
			n = n.next;
		}
		System.out.println(n.value);
	}

}
