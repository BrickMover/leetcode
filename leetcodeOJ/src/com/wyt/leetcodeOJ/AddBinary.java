package com.wyt.leetcodeOJ;

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("100", "110010"));
	}
	
	public static String addBinary(String a, String b) {
		StringBuffer buffer = new StringBuffer();
		if(a.length() < b.length()) {
			int k = 0;
			for (int i = 0; i < a.length(); i++) {
				int tmp = a.charAt(a.length()-1-i) + b.charAt(b.length()-1-i) - 96 + k;
				if (tmp >= 2) {
					k = tmp/2;
				} else {
					k = 0;
				}
				buffer.append(tmp%2);
			}
			
			for (int i = 0; i < b.length()-a.length(); i++) {
				int tmp = k + b.charAt(b.length()-a.length()-1-i) - 48;
				if (tmp >= 2) {
					k = tmp/2;
				} else {
					k = 0;
				}
				buffer.append(tmp%2);
			}
			if(k != 0) {
				buffer.append(k);
			}
			
			return buffer.reverse().toString();
		} else {
			int k = 0;
			for (int i = 0; i < b.length(); i++) {
				int tmp = (a.charAt(a.length()-1-i)+b.charAt(b.length()-1-i)-96) + k;
				if (tmp >= 2) {
					k = tmp/2;
				} else {
					k = 0;
				}
				buffer.append(tmp%2);
			}
			
			for (int i = 0; i < a.length()-b.length() ; i++) {
				int tmp = k + a.charAt(a.length()-b.length()-1-i) - 48;
				if(tmp >= 2) {
					k = tmp/2;
				} else {
					k = 0;
				}
				buffer.append(tmp%2);
			}
			if(k !=0) {
				buffer.append(k);
			}
			return buffer.reverse().toString();
		}
    }

}
