package com.neeson.algo.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Create on 2020-04-11
 *
 * @author Administrator
 */
public class TwoSum {

    private Map<Integer, Integer> tmp = new HashMap<>();

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int i1 = target - numbers[i];
            Integer integer = tmp.get(i1);
            if (Objects.isNull(integer)) {
                tmp.put(numbers[i], i);
            } else {
                return new int[]{integer+1,i+1};
            }
        }
        return new int[0];
    }

}
