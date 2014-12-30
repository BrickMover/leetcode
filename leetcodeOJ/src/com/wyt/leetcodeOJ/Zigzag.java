package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @version 1.0
 */
public class Zigzag {
	
	/**
	 * @param args
	 * Input "123456789" 4
	 * Output 
	 *		  1      7
	 *		  2    6 8
	 *		  3  5   9
	 *		  4
	 * 
	 * "172683594"
	 */
	public static void main(String[] args) {
		System.out.println(convert("123456789", 4));
	}
	
	
	/**
	 * @param s 待转换成之字形的字符串
	 * @param nRows
	 * @return
	 */
	public static String convert (String s, int nRows) {
		
		if(s == null || nRows <= 1) {
            return s;
        }
		/**
		 * 思路：
		 * 第一行代数关系：     				步长= 2x(rows - 1)  初始量0
		 * 最后一行代数关系：				步长= 2x(rows - 1)  初始量rows - 1
		 * 中间（1~rows-1）行代数关系：    	步长= 2x(rows - 1)  初始量 i ，结点值j+(rows-1-i)x2 不能超过字符串长度
		 */
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
