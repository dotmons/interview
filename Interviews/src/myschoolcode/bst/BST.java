package myschoolcode.bst;

public class BST {

	public Node insertNode(Node node, int val) {
		Node n = new Node();
		n.data = val;

		if (node == null) {
			n.left = null;
			n.right = null;
			return n;
		} else {
			if (val > node.data) {
				node.right = insertNode(node.right, val);
			} else {
				node.left = insertNode(node.left, val);
			}
		}
		return node;
	}

	public Node delete(Node node, int val) {
		if (node == null) {
			return null;
		}

		if (val < node.data) {
			node.left = delete(node.left, val);
		} else if (val > node.data) {
			node.right = delete(node.right, val);
		} else {
			if ((node.left == null || (node.right == null))) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;

				if (temp == null) {
					return null;
				} else {
					return node;
				}

			} else {
				Node succesor = getSuccessor(node);
			}

		}
		return null;
	}

	public Node deleteNode(Node majorNode, int val) {

		if (majorNode == null) {
			return null;
		}

		if (majorNode.data == val) {
			if (majorNode.left == null && majorNode.right == null) {
				majorNode = null;
			} else if (majorNode.left != null && majorNode.right == null) {
				Node successor = getSuccessor(majorNode.left);
				majorNode.data = successor.data;
				majorNode.left = null;
				majorNode = null;
			} else if (majorNode.left == null && majorNode.right != null) {
				Node successor = getSuccessor(majorNode.right);
				majorNode.right = null;
				majorNode = null;
			} else {

			}

		} else if (val > majorNode.data) {
			majorNode.right = deleteNode(majorNode.right, val);
		} else {
			majorNode.left = deleteNode(majorNode.left, val);
		}

		return majorNode;
	}

	Node getSuccessor(Node node) {
		
		return null;
	}

}