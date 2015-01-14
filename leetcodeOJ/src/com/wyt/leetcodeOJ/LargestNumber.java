package com.wyt.leetcodeOJ;


/**
 * @author wangyitao
 * @date 2015-01-14
 * @version 1.0
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

	public static void main(String[] args) {
		int[] num = {128,12,320,32};
		System.out.println(largestNumber(num));

	}

	public static String largestNumber(int[] num) {
		for(int i = 1 ; i < num.length; i++) {//插入排序
			for (int j = i; j > 0 ; j--) {
				if(isBig(num[j] , num[j-1])) {//自定义大小函数
					int tmp = num[j];
					num[j] = num[j - 1];
					num[j - 1] = tmp;
				} else {
					break;
				}
			}
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < num.length; i++) {
			if(num[i] == 0 && buffer.length() == 0){//防止全是0
				continue;
			}
			buffer.append(num[i]);
		}
		
		if(buffer.length() == 0 && num.length!=0) {//全是0，返回0
			return "0";
		}
		
		return buffer.toString();
    }

	private static boolean isBig(int i, int j) {//i.append(j) > j.append(i)
		String s1 = String.valueOf(i);
		String s2 = String.valueOf(j);
		
		if (Integer.parseInt(s1+s2) > Integer.parseInt(s2+s1)) {
			return true;
		} else {
			return false;
		}
	}

}
