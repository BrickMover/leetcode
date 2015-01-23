package com.wyt.leetcodeOJ;

/**
 * @author wangyitao
 * @Date 2015-01-22
 * @version 1.0
 * @Description
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] A = {0,0,0,0,0,0};
		int[] B = {1};
		merge(A, 0, B, 1);
	}
	
	public static void merge(int A[], int m, int B[], int n) {
        if (B == null || B.length == 0) {
			return;
		}
        if (m == 0) {
        	A = B;
        	return;
        }
		
		int indexA = 0;
        int indexB = 0;
        
        for (int i = 0; i < m+n-1; i++) {
        	if (A[indexA] >= B[indexB]) {
        		for (int j = m+indexB; j > indexA; j--) {
        			int temp = A[j-1];
					A[j] = temp;
				}
        		A[indexA] = B[indexB];
        		indexA++;
        		indexB++;
        	} else {
        		indexA++;
        	}
        	if (indexB == n || i > n + indexB) {
				break;
			}
		}
        
        if(indexB < n) {
        	for (int i = indexB; i < n; i++) {
				A[ m + i] = B[i];
			}
        }
        	
    }
	
	public static void merge1(int A[], int m, int B[], int n) {
		int size = m+n-1;
        m--;
        n--;
        while(size>=0){
            if(m>=0&&n>=0){
                 if(A[m]>=B[n])
                    A[size--] = A[m--];
                 else
                    A[size--] = B[n--];
            }
            else{
                while(size>=0){
                    if(n>=0)
                        A[size--] = B[n--]; 
                    else
                        A[size--] = A[m--];
                }
                break;
            }
        }

	}

}
