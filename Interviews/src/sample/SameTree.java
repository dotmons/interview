package sample;

import java.util.LinkedList;
import java.util.Objects;

public class SameTree {

    public SameTree(){
    TreeNode p = new TreeNode(1);
    TreeNode pleft = new TreeNode(2);
    TreeNode pright = new TreeNode(3);

    TreeNode q = new TreeNode(1);
    TreeNode qleft = new TreeNode(2);
    TreeNode qright = new TreeNode(3);

    p.left = pleft;
    p.right = pright;

    q.left = qleft;
    q.right = qright;

    System.out.println(isSameTree(p,q));

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (!Objects.nonNull(p) && !Objects.nonNull(q)){
            return true;
        }

        if (!Objects.nonNull(p) || (!Objects.nonNull(p.val)) || !Objects.nonNull(q) || !Objects.nonNull(q.val)){
            return false;
        }

        return transverse(p,q);
    }

    public boolean transverse(TreeNode p, TreeNode q){


        LinkedList<TreeNode> queueListP = new LinkedList();
        LinkedList<TreeNode> queueListQ = new LinkedList();


        queueListP.add(p);
        queueListQ.add(q);

        while((!queueListP.isEmpty()) && (!queueListQ.isEmpty()) ){

            TreeNode tempNodeP = queueListP.poll();
            TreeNode tempNodeQ = queueListQ.poll();

            if (tempNodeP == null && tempNodeQ == null) {
                continue;
            }

            if ((tempNodeP==null) || (tempNodeQ==null) || tempNodeP.val!=tempNodeQ.val){
                return false;
            }

            queueListP.add(tempNodeP.left);
            queueListP.add(tempNodeP.right);
            queueListQ.add(tempNodeQ.left);
            queueListQ.add(tempNodeQ.right);

        }
        return true;
    }

    public static void main(String[] args){
        new SameTree();
    }

}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


