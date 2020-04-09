package com.neeson.algo.binarysearch;

import java.util.Arrays;

/**
 * Create on 2020-04-09
 *
 * @author Administrator
 */
public class FindPeakElement {

    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

}
