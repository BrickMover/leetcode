package com.wyt.leetcodeOJ;

import java.math.BigInteger;

public class ReverseInteger {

	public static void main(String[] args) {
		int a = new BigInteger("9646324351").intValue();
		System.out.println(reverse(a));
	}

	public static int reverse(int x) {
		try {
			String s = String.valueOf(x);
			String result = "";
			if(x >= 0) {
				result = doReverse(s);
			} else {
				result = "-" + doReverse(s.substring(1));
			}
			return Integer.parseInt(result);
		} catch (Exception e) {
			return 0;
		}
    }

	private static String doReverse(String s) {
		char[] ss = s.toCharArray();
		int len = s.length();
		for (int i = 0; i < s.length()/2; i++) {
			char tp = ss[i];
			ss[i] = ss[len-1-i];
			ss[len-1-i] = tp;
		}
		return String.valueOf(ss);
	}
}
