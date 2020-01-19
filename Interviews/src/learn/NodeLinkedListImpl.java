package learn;

public class NodeLinkedListImpl {

	public NodeLinkedListImpl(){
		NodeLinkedList nodeLinkedList = new NodeLinkedList(4);
		//nodeLinkedList.first = nodeLinkedList;
		
		nodeLinkedList.addLast(7);
		//nodeLinkedList.addLast(9);
		//nodeLinkedList.addLast(90);
		
		System.out.println(nodeLinkedList);
		
	}
	
	public static void main(String[] args) {
		NodeLinkedListImpl nodeLinkedListImpl = new NodeLinkedListImpl();
		// TODO Auto-generated method stub

	}
}
