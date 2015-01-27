package com.wyt.leetcodeOJ;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangyitao
 * @Date 2015-01-27
 * @version 1.0
 * @Description
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  / \
 * 15  7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);root.left=node1;root.right=node2;
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);node2.left=node3;node2.right=node4;
		
		zigzagLevelOrder(root);
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) {
			return results;
		}
        TreeNode cur = null;
        int k = 1;
        Queue<TreeNode> sameLevel = new LinkedList<TreeNode>();
        sameLevel.add(root);
        while (!sameLevel.isEmpty()) {
			List<Integer> oneLevel = new LinkedList<Integer>();
			Queue<TreeNode> tmp = new LinkedList<TreeNode>();
			while (!sameLevel.isEmpty()) {
				cur = sameLevel.remove();
				if (k%2 == 0) {
					oneLevel.add(0,cur.val);
				} else {
					oneLevel.add(cur.val);
				}
				if (cur.left != null) {
					tmp.add(cur.left);
				}
				if (cur.right != null) {
					tmp.add(cur.right);
				}
			}
			results.add(oneLevel);
			sameLevel = tmp;
			k++;
		}
        
        return results;
    }

}
