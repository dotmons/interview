package learn.linkedlist;

public class LinkedList {

	Node head;

	public LinkedList() {

	}

	public void insert(int data) {
		Node node = new Node();
		node.data = data;

		if (head == null) {
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;

		}

	}

	public void show(){
		Node node = head;
		
		while(node.next!=null){
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// TODO Auto-generated method stub

	}

}
