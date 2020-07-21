package leetcode;

public class PathSum {

	class TreeNode {
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
	}
	
	public PathSum(){
		TreeNode tn = new TreeNode();
		tn.val = 5;
		TreeNode tn1 = new TreeNode();
		tn1.val = 4;
		tn.left = tn1;
		TreeNode tn2 = new TreeNode();
		tn2.val = 12;
		tn1.left = tn2;
		TreeNode tn3 = new TreeNode();
		tn3.val = 7;
		tn2.left = tn3;
		
		
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		PathSum pathSum = new PathSum();
	}

}

/*
 * public class Solution { public boolean hasPathSum(TreeNode root, int sum) {
 * if(root == null) return false;
 * 
 * if(root.left == null && root.right == null && sum - root.val == 0) return
 * true;
 * 
 * return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -
 * root.val); } }
 */