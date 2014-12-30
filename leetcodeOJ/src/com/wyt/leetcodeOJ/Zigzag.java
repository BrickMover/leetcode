package com.wyt.leetcodeOJ;

public class Zigzag {
	
	
	public static void main(String[] args) {
		System.out.println(convert("123456789", 4));
	}
	
	
	public static String convert (String s, int nRows) {
		
		if(s == null || nRows <= 1) {
            return s;
        }
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < s.length(); i += (nRows-1)*2) {
			sb.append(s.charAt(i));
		}
		
		for (int i = 1; i < nRows - 1; i++) {
			for (int j = i; j < s.length(); j += (nRows-1)*2) {
				sb.append(s.charAt(j));
				if (j + (nRows - i - 1) * 2 < s.length()) {
                    sb.append(s.charAt(j + (nRows - i - 1) * 2));
                }
			}
		}
		
		for (int i = nRows-1; i < s.length(); i += (nRows-1)*2) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	
}
