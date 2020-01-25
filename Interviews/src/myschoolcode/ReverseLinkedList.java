package myschoolcode;

import datastructure.LinkedList;

public class ReverseLinkedList {

	public ReverseLinkedList(){
		LinkedList ll = new LinkedList();
		LinkedList llReverse = new LinkedList();
		
		ll.addLast(2);
		ll.addLast(5);
		ll.addLast(8);
		ll.addLast(23);
		ll.addLast(29);
		
		ll.printStack();
		System.out.println("Reversed Linked List: ");
		ll.reverseLinkedListRecursion();
		//ll.getReverseList();
		//System.out.println("Reversed Linked List: ");
		//ll.printStack();
				
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList ReverseLinkedList = new ReverseLinkedList();
	}

}
