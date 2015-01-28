package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-28
 * @version 1.0
 * @Description
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class IntegertoRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(99));
	}
	
	public static String intToRoman(int num) {
		if (num >= 1000) {
			return "M" + intToRoman(num - 1000);
		}
		if (num >= 900 && num <1000) {
			return "CM" + intToRoman(num-900);
		}
		if (num >= 500 && num < 900 ) {
			return "D" + intToRoman(num - 500);
		}
		if (num >= 400 && num < 500) {
			return "CD" + intToRoman(num-400);
		}
		if (num >= 100 && num < 400) {
			return "C" + intToRoman(num - 100);
		}
		if (num >= 90 && num < 100) {
			return "XC" + intToRoman(num - 90);
		}
		if (num >=50 && num < 90) {
			return "L" + intToRoman(num-50);
		}
		if (num >= 40 && num <50) {
			return "XL" + intToRoman(num-40);
		}
		if (num >= 10 && num < 40) {
			return "X" + intToRoman(num-10);
		}
		if (num == 9) {
			return "IX";
		}
		if (num >=5 && num < 9) {
			return "V" + intToRoman(num - 5);
		}
		if (num == 4) {
			return "IV";
		}
		if (num >=1 && num < 4) {
			return "I" + intToRoman(num-1);
		} else {
			return "";
		}
    }

}
