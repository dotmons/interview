package leetcode;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        new SwapNodesInPairs();
    }

    public SwapNodesInPairs() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(swapNodes(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return swap(head);


    }

    public ListNode swapNodes(ListNode listNode) {
        if (listNode == null || listNode.next == null)
            return listNode;

        ListNode temp = listNode.next;
        ListNode temp2 = new ListNode(listNode.val, temp.next);
        listNode = new ListNode(temp.val, temp2);
        System.out.println(">>" + listNode);
        //listNode.next = swapNodes(listNode);
       // temp3.next.next = swap(temp3);
        //return swap(listNode.next.next);
        return listNode;
    }
    public ListNode swap(ListNode hd) {
        if (hd == null || hd.next == null)
            return hd;

        ListNode temp = hd.next;
        ListNode l = temp.next;
        hd.next = l;
        temp.next = hd;
        hd = temp;
        temp = temp.next;
        temp.next = swap(l);
        return hd;
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


}

