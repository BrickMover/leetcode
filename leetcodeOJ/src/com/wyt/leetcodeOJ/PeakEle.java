package com.wyt.leetcodeOJ;

public class PeakEle {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 1};
		System.out.println(findPeakElement(a));
	}

	public static int findPeakElement(int[] num) {
		if(num.length >0) {
			
			if(num.length == 1) {
				return 0;
			} else {
				if(num[0] > num[1]) {
					return 0;
				}
				if(num[num.length-1] > num[num.length-2]) {
					return num.length-1;
				}
				for (int i = 1; i < num.length-1; i++) {
					if(num[i] > num[i-1] && num[i] > num[i+1]) {
						return i;
					}
				}
			}
			
			return 0;
		} else {
			return -1;
		}
    }
}
