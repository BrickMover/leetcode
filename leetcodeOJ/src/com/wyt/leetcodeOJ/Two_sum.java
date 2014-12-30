package com.wyt.leetcodeOJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyitao
 * @version 1.0
 * 
 */
public class Two_sum {
	/**
	 * @param args<br>
	 * <p>测试例子<br>
	 * Input: numbers={2, 7, 11, 15}, target=9<br>
	 * Output: index1=1, index2=2
	 */
	public static void main(String[] args) {
		int[] numbers = {2, 3, 11, 15, 16, 17, 18, 19, 7};
		int target = 9;
		int[] a = twoSum(numbers, target);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * @param numbers:带求解int数组
	 * @param target:目标值
	 * @return 返回一个长度为2的int数组，两个index对应numbers元素之和为target的值
	 */
	private static int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
	    int[] index = new int[2];

	    /**
	     * 思路：对于numbers中的一个元素a，它的期待值是target-a
	     * 以target-a为键，a为值，将其放入map，每次put查找key是否存在，存在的话
	     * 说明存在这一的一个two sum
	     */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < len; i++) {
			if (!map.containsKey(numbers[i])) {//做一次查找，若存在就说明找到了数对
				map.put(target - numbers[i], i);//否则，放进map，继续找
			} else {
				index[0] = map.get(numbers[i]) + 1;
				index[1] = i + 1;
			}
		}

		return index;
	}
}
