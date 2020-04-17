package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/17 21:42
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int preLength = 0;
        int length = 0;

        for (int num : nums) {
            if (num == 0) {
                length = Math.max(preLength, length);
                preLength = 0;
            } else {
                preLength = preLength + 1;
            }
        }
        return Math.max(preLength, length);
    }

}
