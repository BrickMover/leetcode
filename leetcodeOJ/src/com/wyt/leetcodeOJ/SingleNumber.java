package com.wyt.leetcodeOJ;

import java.util.Hashtable;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {
		int[] A = {1,1,2,2,3};
		System.out.println(singleNumber__(A));
	}

	/**
	 * @param A
	 * @return 找到单独的那个数<br>
	 * 使用异或操作，一趟完成
	 */
	public static int singleNumber(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}
	
	/**
	 * @param A
	 * @return<br>
	 * 将元素放到map中，每次放进去求总和，发现存在的就减去存在值的两倍，剩余的就是单独的数
	 */
	public static int singleNumber__(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if(map.containsKey(A[i])) {
				sum -= A[i]*2;
			} else {
				map.put(A[i], A[i]);
			}
		}
		return sum;
	}

}
