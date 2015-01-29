package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-29
 * @version 1.0
 * @Description
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 */
public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		int[] num = {7,8,8,9,3,3,4,5,1,2,3};
		System.out.println(findMinII(num));
	}

	/**
	 * @param num
	 * @return
	 * @Description
	 * 对比peak element，求出所有的最低点，并求出最小值
	 */
	public static int findMin(int[] num) {
        if (num.length == 1) {
        	return num[0];
        }
        if (num.length == 2) {
			return num[0] > num[1] ? num[1] : num[0];
		}
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
        	if (i==0 && num[i] < num[i+1]) {
				result = num[i];
			}
        	if (i == num.length - 1) {
				if (num[i] < num[i-1] && num[i]<result) {
					result = num[i];
				}
				break;
			}
			if (i != 0 && num[i] < num[i-1] && num[i] < num[i+1] && num[i] < result) {
				result = num[i];
			}
		}
        return result;
    }
	
	/**
	 * @param num
	 * @return
	 * @Description
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * Find the minimum element.
	 * The array may contain duplicates.
	 */
	public static int findMinII (int[] num) {
		if (num.length == 1) {
        	return num[0];
        }
        if (num.length == 2) {
			return num[0] >= num[1] ? num[1] : num[0];
		}
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
        	if (i==0 && num[i] <= num[i+1]) {//加上=号
				result = num[i];
			}
        	if (i == num.length - 1) {
				if (num[i] <= num[i-1] && num[i]<result) {//加上=号
					result = num[i];
				}
				break;
			}
			if (i != 0 && num[i] <= num[i-1] && num[i] <= num[i+1] && num[i] < result) {//加上=号
				result = num[i];
			}
		}
        return result;
	}
}
