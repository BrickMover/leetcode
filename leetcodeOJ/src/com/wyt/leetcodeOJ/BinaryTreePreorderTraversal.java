package com.wyt.leetcodeOJ;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyitao
 * @Date 2015-01-05
 * @version 1.0
 * @Description
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 *  return [1,2,3].  
 *  Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreePreorderTraversal {
	private static List<Integer> list = new LinkedList<Integer>();
	
	private static List<Integer> postList = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		root.right=node1;node1.left=node2;
		
//		TreeNode root = new TreeNode(1);
//		TreeNode node1 = new TreeNode(2);
//		TreeNode node2 = new TreeNode(5);root.left=node1;root.right=node2;
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);node1.left=node3;node1.right=node4;
		
		preorderTraversal(root);
		List<Integer> integers = list;
		System.out.println(integers);
		
		System.out.println(postorderTraversal(root));
	}
	
	
	
	/**
	 * @param root
	 * @return
	 * @Description 先序遍历
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
        	return list;
        } else {
        	list.add(root.val);
        	preorderTraversal(root.left);
        	preorderTraversal(root.right);
        	return list;
        }
    }
	
	/**
	 * @param root
	 * @return
	 * @Description 后续遍历
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
			return postList;
		} else {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			postList.add(root.val);
			return postList;
		}
    }

}
