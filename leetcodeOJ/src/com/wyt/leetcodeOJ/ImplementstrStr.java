package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-23
 * @version 1.0
 * @Description
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer. 
 * If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 *
 */
public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int strStr(String haystack, String needle) {
		if(haystack == null) {
			if (needle == null) {
				return 0;
			} else {
				return -1;
			}
		}
		if (haystack.length()==0) {
			if (needle.length() == 0) {
				return 0;
			} else {
				return -1;
			}
		}
		if (haystack.length()!=0 && (needle==null||needle.length()==0)) {
			return 0;
		}
		for (int i = 0; i < haystack.length(); i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				if (i + needle.length() > haystack.length()) {
					return -1;
				} else {
					if(haystack.substring(i, i+needle.length()).equals(needle)) {
						return i;
					}
				}
			}
		}
		return -1;
	}

}
