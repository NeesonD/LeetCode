package com.neeson.algo.binarysearch;

/**
 * Create on 2020-04-11
 *
 * @author Administrator
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo * lo == num;
    }

}
