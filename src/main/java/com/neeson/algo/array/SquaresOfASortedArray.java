package com.neeson.algo.array;

/**
 * Create on 2020-04-21
 *
 * @author Administrator
 * 读写指针
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {
        if (A.length == 1) {
            A[0] = A[0] * A[0];
            return A;
        }
        int rIdx = 0;
        int lIdx = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < 0 && A[i] >= 0) {
                rIdx = i;
                lIdx = i - 1;
                break;
            }
        }
        if (A[0] >= 0) {
            lIdx = -1;
        } else if (A[A.length - 1] < 0) {
            rIdx = A.length;
        }
        int[] res = new int[A.length];
        int resIdx = 0;
        while (true) {
            if (rIdx >= A.length) {
                res[resIdx++] = A[lIdx] * A[lIdx];
                lIdx--;
            } else if (lIdx < 0) {
                res[resIdx++] = A[rIdx] * A[rIdx];
                rIdx++;
            } else if (Math.abs(A[lIdx]) > A[rIdx]) {
                res[resIdx++] = A[rIdx] * A[rIdx];
                rIdx++;
            } else {
                res[resIdx++] = A[lIdx] * A[lIdx];
                lIdx--;
            }
            if (resIdx == A.length) {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        new SquaresOfASortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }

}
