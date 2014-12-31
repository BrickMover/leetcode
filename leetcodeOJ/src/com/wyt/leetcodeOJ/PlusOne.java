package com.wyt.leetcodeOJ;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9,9};
		System.out.println(Arrays.toString(plusOne(digits)));
		System.out.println(trailingZeros(7));
	}
	
	public static int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) {
			return digits;
		}
		
		int len = digits.length;
		if(digits[len - 1] < 9) {
			digits[len - 1] ++;
			return digits;
		}
		
		if(len == 1) {
			digits = new int[2];
			digits[0] = 1;
			digits[1] = 0;
			return digits;
		} else {
			int k = len;
			digits[len - 1] = 0;
			for (int i = len - 2; i >= 0; i--) {
				if(digits[i] < 9) {
					digits[i]++;
					break;
				} else {
					digits[i] = 0;
				}
				k--;
			}
			if(k==1) {
				digits = new int[len+1];
				digits[0] = 1;
			}
			return digits;
		}
    }
	
	public static int trailingZeros(int n){
		if(n<=0 || n>=17) {
			return 0;
		}
		
		
		for (int i=n ; i > 1; i--) {
			n = n * (i -1);
		}
		
		System.out.println(n);
		
		if(n <= 0) {
			return 0;
		}
		String s = String.valueOf(n);
		
		int result = 0;
		
		for (int i = s.length()-1; i > 0; i--) {
			if(s.charAt(i) == '0') {
				result ++;
			}
		}
		
		return result;
	}

}
