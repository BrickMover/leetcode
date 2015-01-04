package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * date 2015-01-01
 *
 */
public class TrailingZeros {

	public static void main(String[] args) {
			System.out.println(trailingZeros(2147483647));
		
	}
	
	/**
	 * @param n
	 * @return 0的个数<br>
	 * 阶乘最后的0来自5x2，而因子2的个数一定多于5，所以就是数n里面有多少个5，那就有多少个尾数0
	 */
	public static int trailingZeros(int n){
		int result = 0;
		while (n > 0) {
			n /= 5;
			result += n;
		}
		return result;
	}
	
	public static int trailingZeroes_(int n) {//时间复杂度过高
	       int x =5;
	        int result = 0;
	        while(n >= x) {
	            if (x!=0) {
	                result += n/x;
	        	    x *= 5;
	            } else {
	                return 0;
	            }
	        }
	        return result;
	    }

}
