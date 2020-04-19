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

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
