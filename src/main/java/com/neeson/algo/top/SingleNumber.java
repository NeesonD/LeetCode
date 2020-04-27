package com.neeson.algo.top;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/27 21:15
 * 考察点在于对异或的理解
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

}
