package com.wyt.leetcodeOJ;

import java.util.ArrayList;
import java.util.List;

public class Palindrome1Solution {
	public static void main(String[] args) {
		String s = "aabaa";
		List<List<String>> re = partition(s);
		System.out.println(re);
	}
	
	
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		List<String> list = new ArrayList<String>();
		
        if (s == null || s.length() == 0) {
        	return result; 
        }
        
        doPart(result, list, s);
        
        return result;
    }
	
	
	private static void doPart(List<List<String>> result,
			List<String> list, String s) {
		
		if(s.length() == 0) {
			result.add(new ArrayList<String>(list));
		}
		
		int len = s.length();
		
		for (int i = 1; i <= len; i++) {
			String sub = s.substring(0, i);
			if(isPalindrome(sub)) {
				list.add(sub);
				String lastSub = s.substring(i);
				doPart(result, list, lastSub);
				list.remove(list.size()-1);
			}
		}
	}


	public static boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length()-1;
		
		while (i < j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
