package com.neeson.algo.binarysearch;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/8 21:51
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length;
        int mid;
        while (min < max) {
            mid = min + (max - min)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                if (mid == min) {
                    return -1;
                }
                min = mid;
            } else {
                max = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 3, 5, 9, 12};
        new BinarySearch().search(ints, 2);
    }

}
