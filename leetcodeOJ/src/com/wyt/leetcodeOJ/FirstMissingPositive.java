package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] A = {3,4,-1,1};
		System.out.println(firstMissingPositive(A));
	}

	public static int firstMissingPositive(int[] A) {
		
		if(A == null || A.length == 0) {
			return 1;
		}
		
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < A.length; i++) {
			if (!map.containsValue(A[i])) {
				map.put(A[i], A[i]);
			}
		}
        int result = 1;
        while (map.get(result)!=null) {
        	result++;
		}
        
        return result;
    }
}
