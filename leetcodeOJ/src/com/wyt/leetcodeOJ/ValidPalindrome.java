package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-19
 * @version 1.0
 * @Description
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 一个从头，一个从尾部，相遇停止
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "9a2";//"A man, a plan, a canal: Panama";
		System.out.println((int)s.charAt(0));
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		boolean b = true;
		int j = s.length() - 1;
		
		for (int i = 0; i < s.length(); i++) {
			if(isLetter(s.charAt(i))) {
				while(!isLetter(s.charAt(j))){
					j--;
				}
				if (i == j) {
					break;
				} else {
					if (!equalsIgnoreCase(s.charAt(i), s.charAt(j))) {
						b = false;
						break;
					}
					j--;
				}
			}
		}
        return b;
    }
	
	public static boolean isLetter(char ch) {
		return ch>=65&&ch<=90 || ch>=97&&ch<=122 || ch>=48&&ch<=57;
	}
	
	public static boolean equalsIgnoreCase(char a, char b) {
		int gap = a - b;
		return gap == 32 || gap == -32 || gap == 0;  
	}

}
