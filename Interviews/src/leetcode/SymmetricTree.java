package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public SymmetricTree(){
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(2);
        System.out.println(isSymmetric(tn));
    }
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode tnLeft = queue.poll();
            TreeNode tnRight = queue.poll();

            if ((tnLeft==null) && (tnRight==null)){
                continue;
            }
            if (((tnLeft==null) && (tnRight!=null)) || ((tnLeft!=null) && (tnRight==null)) || (tnLeft.val != tnRight.val)){
                return false;
            }

            queue.add(tnLeft.left);
            queue.add(tnRight.right);
            queue.add(tnLeft.right);
            queue.add(tnRight.left);

        }
        return true;
    }

    public static void main(String[] args){
        new SymmetricTree();
    }
}
