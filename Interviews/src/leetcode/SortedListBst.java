package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class SortedListBst {

    public SortedListBst() {
        //[-10,-3,0,5,9]
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        System.out.println(sortedListToBST(head));
    }
    public TreeNode sortedListToBST(ListNode head) {
        // Edge case: If the list is empty, return null
        if (head == null) return null;

        // Find the middle of the linked list
        ListNode middle = findMiddle(head);
        System.out.println("middle: "+middle.val);
        // Create the root node of the BST with the value of the middle node
        TreeNode root = new TreeNode(middle.val);

        // If there is only one element, return it as the root
        if (head == middle) return root;

        // Recursively build the left subtree with the left half of the list
        root.left = sortedListToBST(head);

        // Recursively build the right subtree with the right half of the list
        root.right = sortedListToBST(middle.next);

        return root;
    }

    // Helper method to find the middle of the linked list
    private ListNode findMiddle(ListNode head) {
        // Base case for when there's only one node or no nodes
        if (head == null || head.next == null) return head;

        // Two pointers approach: slow and fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;  // To keep track of the node before slow

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half from the middle node
        if (prev != null) prev.next = null;

        return slow;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        SortedListBst sortedListBst = new SortedListBst();
    }


}
