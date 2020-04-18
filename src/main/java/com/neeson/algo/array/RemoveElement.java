package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/18 21:56
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int length = nums.length ;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                length--;
                for (int j = i; j < length - 1 ; j++) {
                    nums[j] = nums[j+1];
                }
            }
        }
        return length;
    }

}
