package learn.linkedlist;

public class NodeRunner {

	public NodeRunner(){
		LinkedList list = new LinkedList();
		list.insert(3);
		list.insert(7);
		list.insert(10);
		list.insert(19);
		
		list.show();
	}
	
	public static void main(String[] args) {
		NodeRunner nodeRunner = new NodeRunner();
	}

}
