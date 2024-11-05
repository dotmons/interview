package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }

        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        Pair<TreeNode, TreeNode> pairTreeNode = new Pair<>(root1, root2);
        queue.add(pairTreeNode);

        while (!queue.isEmpty())
        {
            // Extract the pair of nodes from the queue
            Pair<TreeNode, TreeNode> current = queue.poll();
            TreeNode node1 = current.getLeft();
            TreeNode node2 = current.getRight();

            // Add the values of the two nodes
            node1.val += node2.val;

            // If both left children exist, add them to the queue
            if (node1.left != null && node2.left != null) {
                queue.add(new Pair<TreeNode, TreeNode>(node1.left, node2.left));
            }
            // If only node2 has a left child, attach it to node1
            else if (node1.left == null) {
                node1.left = node2.left;
            }

            // If both right children exist, add them to the queue
            if (node1.right != null && node2.right != null) {
                queue.add(new Pair<TreeNode, TreeNode>(node1.right, node2.right));
            }
            // If only node2 has a right child, attach it to node1
            else if (node1.right == null) {
                node1.right = node2.right;
            }

        }

        return root1;
    }
}
