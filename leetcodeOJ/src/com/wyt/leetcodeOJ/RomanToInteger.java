package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyitao
 * @Date 2015-01-29
 * @version 1.0
 * @Description
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("XCIX"));
	}
	
	public static int romanToInt(String s) {
        int result = 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        if (s.length() == 1) {
			return map.get(s.charAt(0));
		}
        
        for (int i = 0; i < s.length() - 1; i++) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
        
        result += map.get(s.charAt(s.length()-1));
        return result;
    }

}
