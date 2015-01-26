package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-26
 * @version 1.0
 * @Description
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *    Note:
 *    Bonus points if you could solve it both recursively and iteratively.
 *    confused what "{1,#,2,3}" means?
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(3);
		
		root.left = node1;root.right = node2;
		node1.left = node3;node1.right = node4;
		node2.left = node5;node2.right = node6;
		
		System.out.println(isSymmetric(root));

	}
	
	public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        } else {
        	return isRLSymmetric(root.left, root.right);
        }
        
    }
	
	private static boolean isRLSymmetric (TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else {
			if (left == null || right == null) {
				return false;
			}
		}
		if (left.val != right.val) {
			return false;
		}
		if (!isEquals(left.left, right.right) || !isEquals(left.right, right.left)) {
			return false;
		}
		
		return isRLSymmetric(left.right, right.left) && isRLSymmetric(left.left, right.right);
	}
	
	private static boolean isEquals (TreeNode t1, TreeNode t2) {
		if (t1!= null && t2!=null) {
			return t1.val ==t2.val;
		} else {
			return t1 == t2;
		}
	}

}
