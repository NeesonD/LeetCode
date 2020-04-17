package com.neeson.algo.binarysearch;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/14 20:11
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int duplicate = new FindTheDuplicateNumber().findDuplicate(new int[]{1, 2, 3, 1});
    }

}
