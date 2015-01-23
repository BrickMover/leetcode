package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-23
 * @version
 * @Description The count-and-say sequence is the sequence of integers beginning
 *              as follows: 1, 11, 21, 1211, 111221, ... 1 is read off as
 *              "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off
 *              as "one 2, then one 1" or 1211. Given an integer n, generate the
 *              nth sequence. Note: The sequence of integers will be represented
 *              as a string.
 *
 */
public class CountandSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}

	public static String countAndSay(int n) {
		String str = "1";
		if (n == 1) {
			return str;
		}
		for (int i = 2; i <= n; i++) {
			str = getTmp(str);
		}
		return str;
	}

	public static String getTmp(String nstr) {
		String str = "";
		char tmp;
		tmp = nstr.charAt(0);
		int count = 0;
		for (int i = 0; i < nstr.length(); i++) {
			if (nstr.charAt(i) == tmp) {
				count++;
			} else {
				str += count;
				str += tmp;
				tmp = nstr.charAt(i);
				count = 1;
			}
		}
		str += count;
		str += tmp;
		return str;
	}
}
