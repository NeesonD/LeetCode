package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/19 10:06
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 1, 2});
    }

}
