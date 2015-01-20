package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-20
 * @version 1.0
 * @Description
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself 
 * what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * spoilers alert... click to show requirements for atoi.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
 * and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 **/
public class StringtoInteger {

	public static void main(String[] args) {
		String str = "    010ab123";
		System.out.println(atoi(str));
	}
	
	public static int atoi(String str) {
		if (str == null) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < str.length(); i++) {//去空格
			if(str.charAt(i) == ' ') {
				index ++;
			} else {
				break;
			}
		}
		str = str.substring(index);
		StringBuffer sb = new StringBuffer();
		int flag = 1;
		boolean hasFlag = false;//不能有两个符号
		for (int i = 0; i < str.length(); i++) {
			if((int)str.charAt(i)>= 48 && (int)str.charAt(i)<=57) {
				sb.append(str.charAt(i));
			} else {
				if (str.charAt(i) == '-' || str.charAt(i) == '+') {
					if (hasFlag) {
						break;
					}
					if (str.charAt(i) == '-') {
						flag = -1 * flag;
					}
					hasFlag = true;
				} else {
					break;
				}
			}
		}
		
		str = sb.toString();
		if (str.length() == 0) {
			return 0;
		}
		int result = 0;
		try {
			result = flag * Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		
		return result;
	}

}
