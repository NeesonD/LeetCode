package com.neeson.algo.array;

/**
 * Create on 2020-04-21
 *
 * @author Administrator
 * 读写指针
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int wIdx = 0;
        for (int rIdx = 0; rIdx < A.length; rIdx++) {
            if (A[rIdx] % 2 == 0) {
                int tmp = A[wIdx];
                A[wIdx++] = A[rIdx];
                A[rIdx] = tmp;
            }
        }
        return A;
    }

}
