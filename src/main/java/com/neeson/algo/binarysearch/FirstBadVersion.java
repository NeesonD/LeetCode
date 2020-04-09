package com.neeson.algo.binarysearch;

/**
 * Create on 2020-04-09
 *
 * @author Administrator
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int min = 1, max = n, mid = 0;

        while (min < max) {
            mid = min + (max - min) / 2;
            if (isBadVersion(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        if (isBadVersion(min)) {
            return min;
        }
        return -1;
    }

    boolean isBadVersion(int version) {
        return false;
    }

}
