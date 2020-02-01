package myschoolcode.bst;

public class BinarySearchTree {

	public BinarySearchTree() {

	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();

		Node root = null;
		BST bst = new BST();
		root = bst.insertNode(root, 8);
		root = bst.insertNode(root, 3);
		root = bst.insertNode(root, 6);
		root = bst.insertNode(root, 10);
		root = bst.insertNode(root, 4);
		root = bst.insertNode(root, 7);
		root = bst.insertNode(root, 1);
		root = bst.insertNode(root, 14);
		root = bst.insertNode(root, 13);
		
		root = bst.deleteNode(root, 3);
		System.out.println(root);

	}

}
