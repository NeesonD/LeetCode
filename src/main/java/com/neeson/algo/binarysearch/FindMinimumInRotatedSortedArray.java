package com.neeson.algo.binarysearch;

/**
 * Create on 2020-04-09
 *
 * @author Administrator
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length -1, mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (nums[mid] > nums[nums.length -1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 1, 2};
        new FindMinimumInRotatedSortedArray().findMin(a);
    }

}
