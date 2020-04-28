package com.neeson.algo.top.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/28 20:42
 */
public class ContainsDuplicate {

    private Set<Integer> cache = new HashSet<>();

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(nums[i])) {
                return true;
            }
            cache.add(nums[i]);
        }
        return false;
    }

}
