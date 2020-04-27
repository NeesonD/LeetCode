package com.neeson.algo.top;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/27 21:10
 * 考察的是备忘录的使用
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/546/
 */
public class TwoSum {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (cache.get(target - nums[i]) != null) {
                return new int[]{i, cache.get(target - nums[i])};
            }
            cache.put(nums[i], i);
        }
        return new int[0];
    }

}
