package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-20
 * @version 1.0
 * @Description
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

	public static void main(String[] args) {
		
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
        	return true;
        } else {
        	if ((p==null&&q!=null) || (p!=null&&q==null)) {
				return false;
			}
        	if(q.val != p.val) {
        		return false;
        	} else {
        		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        	}
        }
    }

}
