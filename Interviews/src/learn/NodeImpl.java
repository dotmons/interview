package learn;

public class NodeImpl {
	public NodeImpl() {
		Node nodeA = new Node(3);
		Node nodeB = new Node(9);
		Node nodeC = new Node(5);
		Node nodeD = new Node(6);

		Node nodeX = new Node(100);
		
		//nodeA.first = nodeA;
		
		//nodeA = Node.addFirst(nodeX, nodeA);
		//System.out.println("first" + nodeA.first);
		System.out.println("next" + nodeA.next);
		
		//nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;

		//nodeD.last = nodeD;

		
		
		System.out.println(">>>"+ nodeA);
	}

	public static void main(String[] args) {
		NodeImpl node = new NodeImpl();
		// TODO Auto-generated method stub

	}

}
