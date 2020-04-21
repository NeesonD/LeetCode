package com.neeson.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2020-04-21
 *
 * @author Administrator
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] tmp = new int[nums.length];
        for (int num : nums) {
            tmp[num - 1] = num;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
