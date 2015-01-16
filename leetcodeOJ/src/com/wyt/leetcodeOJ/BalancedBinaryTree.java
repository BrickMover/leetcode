package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-16
 * @version 1.0
 * @AC Time 328ms
 * <br>
 * @Description
 * Given a binary tree, determine if it is height-balanced.<br>
 * For this problem, a height-balanced binary tree is defined<br>
 * as a binary tree in which the depth of the two subtrees of<br>
 * every node never differ by more than 1.
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {

	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		int dis = Depth(root.left) - Depth(root.right);
		if (dis > 1 || dis < -1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
    }
	
	private static int Depth(TreeNode node) {//求结点升读
		if (node == null) {
			return 0;
		} else {
			int ld = Depth(node.left);
			int rd = Depth(node.right);
			return 1 + (ld > rd ? ld : rd);
		}
	}

}


class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }