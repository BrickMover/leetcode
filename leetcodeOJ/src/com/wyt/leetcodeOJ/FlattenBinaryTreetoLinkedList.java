package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-28
 * @version 1.0
 * @Description
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * click to show hints.
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 * 
 */
public class FlattenBinaryTreetoLinkedList {
	private static TreeNode newroot = new TreeNode(-1);
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(5);node.left=node1;node.right=node2;
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);node1.left=node3;node1.right=node4;
		TreeNode node5 = new TreeNode(6);node2.right=node5;
	
		flatten(node);
	}
	
	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		} else {
			newroot.right = root;
			newroot.left = null;
			newroot = newroot.right;
			TreeNode left = root.left;
			TreeNode right = root.right;
			if (root.left != null) {
				flatten(left);
			}
			if (root.right != null) {
				flatten(right);
			}
		}
    }
	

}
