package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/19 10:40
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3 || A[0] >= A[1] || A[A.length - 1] >= A[A.length - 2] ) {
            return false;
        }
        boolean flag = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i -1]) {
                if (flag) {
                    return false;
                }
            } else if (A[i] == A[i - 1]) {
                return false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

}
