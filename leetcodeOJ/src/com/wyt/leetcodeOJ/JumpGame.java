package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-05
 * @version 1.0
 * @Description
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {

	public static void main(String[] args) {
		int[] A = {1,2,3};
		System.out.println(canJump(A));
	}

	/**
	 * @param A
	 * @return
	 * 
	 * 从第一个元素开始，以0~A[0]为区间，找到一个最大的扩展区间（0，A[x]）,再在(x, A[x])区间中找下一个扩展区间，如果A.length在其中，则结束
	 */
	public static boolean canJump(int[] A) {
		if(A == null || A.length == 0) {
			return false;
		}
		
		if(A.length == 1) {
			return A[0] >= 0;
		}
		
		int curMax = A[0];
		int result = 0;
        for (int i = 0; i < A.length;) {
        	int step = 0;
        	if (A[i] == 0 || i == A.length-1) {
        		break;
        	}
			for (int j = i + 1; j <= i + (A[i] < A.length-1 ? A[i] : A.length - 1); j++) {
				if (j + A[j] >= A.length) {
					return true;
				}
				if (curMax < j + A[j]) {
					curMax = j + A[j];
					step = j - i;
				}
			}
			i = step == 0 ? i+A[i] : i + step;
			result = i;
		}
        if (result + 1 >= A.length) {
			return true;
		} else {
			return false;
		}
    }
}
