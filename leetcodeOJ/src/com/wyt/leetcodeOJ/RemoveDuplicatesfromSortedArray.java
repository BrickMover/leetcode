package com.wyt.leetcodeOJ;


public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] A = {1,2,2,3,4,4,4,4,5};
		System.out.println(removeDuplicates(A));;
	}

	public static int removeDuplicates(int[] A) {
		if(A == null) {
			return 0;
		}
		if(A.length == 0 || A.length == 1) {
			return A.length;
		}
		
		int pre = A[0];
		int len = 1;//第一个指针，计不重复数
		int index = 1;//第二个指针在前面跑，遇到不重复的，将第一个指针的位置的值覆盖，此时第一个指针后移
		
		while (index < A.length) {
			if (! (A[index]==pre)) {
				A[len] = A[index];
				len ++;
			}
			pre = A[index];
			index ++;
		}
		return len;
	}
	
	public static int removeDuplicates__(int[] A) {
	    int len = A.length;
	    for (int i = 0, j = 1; i < A.length && j < A.length; ) {
	        if (A[i] == A[j]) {
	            j++;
	            --len;
	        }else{
	            i++;
	            A[i]=A[j++];
	        }
	    }
	    return len;
	}
	
	public static int re(int[] A) {
		if (A == null) {
            return 0;
        }
        if (A.length <= 1) {
            return A.length;
        }
        int insert = 1, index = 1;
        while (index < A.length) {
            if (A[index] != A[insert - 1]) {
                A[insert] = A[index];
                insert++;
            }
            index++;
        }
        return insert;
	}

}
