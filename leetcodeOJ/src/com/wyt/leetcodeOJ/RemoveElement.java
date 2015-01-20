package com.wyt.leetcodeOJ;

import java.util.Arrays;

/**
 * @author wangyitao
 * @Date 2014-01-20
 * @version 1.0
 * @Description
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

	public static void main(String[] args) {
		int[] A = {4,5};
		System.out.println(removeElement(A, 5));
		System.out.println(Arrays.toString(A));;
	}
	
	public static int removeElement(int[] A, int elem) {
		int end = A.length;
        for (int i = 0; i < end; i++) {
			if(A[i] == elem) {
				while (A[end - 1] == elem) {//从后面数，第一个不是elem的
					end--;//end递减
					if(end == 0 || i==end) {//前后两个指针相遇，结束，或者直接从尾指向头
						return end;
					}
				}
				int tmp = A[end-1];
				A[i] = tmp;
				A[end-1] = elem;
				end--;//交换后，向前移动
			}
		}
        return end;
    }

}
