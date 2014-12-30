package com.wyt.leetcodeOJ;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Two_sum {
	public static void main(String[] args) {
		int[] numbers = {2, 3, 11, 15, 16, 17, 18, 19, 7};
		int target = 9;
		int[] a = twoSum(numbers, target);
		System.out.println(Arrays.toString(a));
		
		System.out.println(new Date());
		
		
	}

	private static int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
	    int[] index = new int[2];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < len; i++) {
			if (!map.containsKey(numbers[i])) {
				map.put(target - numbers[i], i);
			} else {
				index[0] = map.get(numbers[i]) + 1;
				index[1] = i + 1;
			}
		}

		return index;
	}
}
