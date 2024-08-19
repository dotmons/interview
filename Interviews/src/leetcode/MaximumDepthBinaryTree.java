package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        if (root!=null)
            queue.add(root);
        int counter = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            counter++;
            for (int i=0; i<size; i++){

                TreeNode tn = queue.poll();
                if(tn.left!=null){
                    queue.add(tn.left);
                }
                if(tn.right!=null){
                    queue.add(tn.right);
                }
            }
        }
        return counter;
    }
}
