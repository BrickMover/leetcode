package com.wyt.leetcodeOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyitao
 * @Date 2015-01-08
 * @version 1.0
 * @AC Time 202ms
 */
public class Subsets {

	public static void main(String[] args) {
		int[] S = {1,2};
		int max = 2>>1;
		System.out.println(max);
		System.out.println(7&1);
		
		List<List<Integer>> subsets = subsets(S);
		System.out.println(subsets);
	}
	
	public static List<List<Integer>> subsets(int[] S) {
		
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        if (S != null) {
        	
        	Arrays.sort(S);//子集有序，题目所需
        	
        	int n = 1 << S.length;//子集个数为2^S.length
            
            for (int i = 0; i < n; i++) {
            	List<Integer> list = new ArrayList<Integer>();
            	int index = 0;
            	int j = i;
            	while (j > 0) {
            		if((j & 1) != 0) {//j的二进制形式，按位与1，为0表示该位置的元素没有如，101&1==1-->add(s0),index+1=s1,j>>1=10&1==0,s1不在，
            			list.add(S[index]);
            		}
            		index++;//标志前移
            		j = j >> 1;//j右移，一直到0
            	}
    			subsets.add(list);
    		}
		}
        
        return subsets;
    }

}
