package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wangyitao
 * @Date 2015-01-29
 * @version 1.0
 * @Description
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "1+2(2+{3+2})";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');map.put(']', '[');map.put('}', '{');
        
        
        if (s == null || s.length() == 0) {
        	return true;
        }
        if (s.length() == 1) {
        	return false;
        }
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
			if (ch=='(' || ch=='[' || ch=='{') {
				stack.push(ch);
			}
			if (ch==')' || ch==']' || ch=='}') {
				if(stack.isEmpty()) {
					return false;
				} else {
					if (map.get(ch) != stack.pop()) {
						return false;
					}
				}
			}
		}
        
        if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
    }
}
