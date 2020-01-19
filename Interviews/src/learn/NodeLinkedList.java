package learn;

public class NodeLinkedList extends Node {

	int data;
	Node first;
	Node last;
	int countNode;

	public NodeLinkedList(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public NodeLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addLast(int number) {
		Node node = new Node(number);
		if (this.first == null) {
			this.first = node;
			this.next = node;
			this.last = node;
		} else {
			System.out.println("MMM");
			this.last.next = node;
			this.last = node;
		}

	}
	// addFirst
	// addLast
	// deleteFirst
	// deleteLast
	// contains
	// indexOf

	@Override
	public String toString() {
		return "NodeLinkedList [data=" + data + ", first=" + first + ", last=" + last + "]";
	}
	
	

}
