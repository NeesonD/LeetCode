package com.neeson.algo.binarysearch;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/8 22:17
 */
public class Sqrt {

    public int mySqrt(int x) {
        long min = 1;
        long max = x;
        long mid;
        while (min <= max) {
            mid = min + (max - min) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return (int) (min * min < x ? min : max);
    }


}
