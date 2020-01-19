package learn;

public class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	public Node() {
	}

	/*
	 * static public Node addFirst(Node node, Node oldNode) {
	 * 
	 * if (oldNode.first != null) { oldNode.first = node; oldNode.next = new
	 * Node(oldNode.data); System.out.println("oldnext: " + oldNode.next); }
	 * return oldNode; }
	 */
	static int countNodes(Node node) {

		if (node.next == null) {
			return 0;
		}
		int count = 1;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + " ]";
	}

}
