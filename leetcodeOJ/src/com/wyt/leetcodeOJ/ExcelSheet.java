package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheet {

	public static void main(String[] args) {
		System.out.println(solutions("AA"));;
		System.out.println(isPalindrome(1234321));
		String[] s = {"111", "12", "123"};
		System.out.println(longestCommonPrefix(s));
	}
	
	public static int solutions (String s) {
		
		char j = 'A';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 1; i <= 26; i++) {
			map.put(j, i);
			j = (char) (j + 1);
		}
		
		int result = 0;
		int len = s.length();
		for (int i = len - 1; i >=0 ; i--) {
			int a = map.get(s.charAt(len-i-1));
			result +=  Math.pow(26, i) * a;
		}
		
		return result;
	}
	
	public static boolean isPalindrome(int x) {
        try {
			boolean b = true;
			
			String s = String.valueOf(x);
			char[] chs = s.toCharArray();
			int len = s.length();
			for (int i = 0; i < len/2; i++) {
				if (chs[i] != chs[len - 1-i]) {
					b = false;
					break;
				}
			}
			
			return b;
		} catch (Exception e) {
			return false;
		}
    }
	
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int len = strs.length;
		if (len < 2) {
			return strs[0];
		} else {
			String result = strs[0];
			for (int i = 1; i < strs.length; i++) {
				if (result.length() > strs[i].length()) {
					result = strs[i];
				}
			}
			
			int lenCh = result.length();
			for (int i = 0; i < lenCh; i++) {
				for (int j = 0; j < len; j++) {
					if (result.charAt(i) != strs[j].charAt(i)) {
						return result.substring(0, i);
					}
				}
			}
			return result;
		}
        
    }

}
