package leetcode;

import java.util.HashSet;

public class DeleteNodesFromLinkedList {

    public DeleteNodesFromLinkedList(){
        int[]nums = {1,2,3};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(modifiedList(nums, head));
    }
    public ListNode modifiedList(int[] nums, ListNode head) {

        if (nums.length<1){
            return null;
        }
        HashSet<Integer> numHashSet = new HashSet<>();
        for (int num : nums) {
            numHashSet.add(num);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (head!=null){
            if (!numHashSet.contains(head.val)){
                current.next = new ListNode(head.val);
                current = current.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
 public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     @Override
     public String toString() {
         return "ListNode{" +
                 "val=" + val +
                 ", next=" + next +
                 '}';
     }
 }

      public static void main(String[] args) {
        DeleteNodesFromLinkedList deleteNodesFromLinkedList = new DeleteNodesFromLinkedList();
      }
}
