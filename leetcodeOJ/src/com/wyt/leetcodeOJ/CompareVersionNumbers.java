package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-09
 * @version 1.0
 * @AC Time 217ms 复杂度O(n)
 * 比较版本号的大小，考虑1,1.0.0.00.0.00000
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {
		System.out.println(compareVersion("1", "1.0.0"));
		;
	}

	private static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");//两个数组，比较每一个位置上的，然后遍历长的那个多出来的是不是都是int0
		String[] v2 = version2.split("\\.");

		int result = 0;

		if (v1.length >= v2.length) {
			for (int i = 0; i < v2.length; i++) {
				if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
					result = 1;
					break;
				} else {
					if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
						result = -1;
						break;
					} else {
						if (i == v2.length - 1) {
							for (int j = i + 1; j < v1.length; j++) {
								if (Integer.parseInt(v1[j]) != 0) {
									return 1;
								}
							}
							break;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < v1.length; i++) {
				if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
					result = 1;
					break;
				} else {
					if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
						result = -1;
						break;
					} else {
						if (i == v1.length - 1) {
							for (int j = i + 1; j < v2.length; j++) {
								if (Integer.parseInt(v2[j]) != 0) {
									return -1;
								}
							}
							break;
						}
					}
				}
			}
		}

		return result;
	}

}
