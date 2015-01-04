package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyitao
 * @Date 2015-01-01
 * @version 1.0<br>
 * <p> leetcode 169 Majority Element
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] a = {2,2};
		int b = majorityElement__(a);
		System.out.println(b);
	}
	
	/**
	 * @param num
	 * @return 出现次数超过数组中元素个数一半的元素
	 */
	public static int majorityElement (int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {//将数组最后所有元素放进hash map中，键为num中元素，值为该值出现的个数
			if(map.containsKey(num[i])) {
				map.put(num[i], map.get(num[i]) + 1);
			} else {
				map.put(num[i], 1);
			}
		}
		int key = 0,value=0;
		for (int i : map.keySet()) {//遍历找到个数最多的
			int tmp = map.get(i);
			if(tmp > value) {
				value = tmp;
				key = i;
			}
		}
		return key;
	}
	
	/**
	 * @param num
	 * @return 优化后的代码
	 */
	public static int majorityElement__ (int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if(map.containsKey(num[i])) {
				map.put(num[i], map.get(num[i]) + 1);
			} else {
				map.put(num[i], 1);
			}
		}
		int key = 0;
		int index = (int) Math.floor(num.length/2.0);//优化点，先求接触达标点，找出满足的一个跳出循环
		for (int i : map.keySet()) {
			int tmp = map.get(i);
			if(tmp > index) {
				key = i;
				break;
			}
		}
		return key;
	}

}
