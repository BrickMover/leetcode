package com.wyt.leetcodeOJ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangyitao
 * @Date 2015-01-27
 * @version 1.0
 * @Description
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  / \
 * 15  7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);root.left=node1;root.right=node2;
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);node2.left=node3;node2.right=node4;
		
		levelOrder(root);

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (root == null) {
			return results;
		}
        Queue<TreeNode> sameLevel = new ArrayDeque<TreeNode>();
        TreeNode cur = null;
        sameLevel.add(root);
        while (!sameLevel.isEmpty()) {
        	List<Integer> oneLevel = new LinkedList<Integer>();
        	Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        	while (!sameLevel.isEmpty()) {
				cur = sameLevel.remove();
				oneLevel.add(cur.val);
				if (cur.left != null) {
					tmp.add(cur.left);
				}
				if (cur.right != null) {
					tmp.add(cur.right);
				}
			}
        	results.add(oneLevel);
        	sameLevel = tmp;
		}
        return results;
    }
}
