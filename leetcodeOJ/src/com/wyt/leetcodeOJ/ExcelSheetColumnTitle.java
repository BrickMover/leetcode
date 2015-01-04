package com.wyt.leetcodeOJ;


public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
	}
	
	public static String convertToTitle (int n) {
		StringBuffer buffer = new StringBuffer();
		while (n != 0 ) {
			buffer.append((char)('A' + (n-1)%26));
			n = (n-1)/26;
		}
		return buffer.reverse().toString();
	}

}
