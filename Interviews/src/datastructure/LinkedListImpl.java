package datastructure;

public class LinkedListImpl {

	public LinkedListImpl() {

		LinkedList list = new LinkedList();
		list.addLast(10);		
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addFirst(1);
		//list.deleteFirst();
		list.deleteLasts();

		System.out.println(list.contains(32));
		System.out.println(list.contain(40));
		System.out.println("Index value of 30: " + list.indexOf(30));
		System.out.println("Index value of 34: " + list.indexOf(34));

		list.printStack();
	}

	public static void main(String[] args) {
		LinkedListImpl ll = new LinkedListImpl();
	}
}
