package com.neeson.algo.binarysearch;

/**
 * Create on 2020-04-10
 *
 * @author Administrator
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = findLeft(nums, target);
        result[1]= findRight(nums, target);


        return result;

    }

    int findLeft(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                hi = mid - 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == hi + 1 || nums[lo] != target) {
            return -1;
        }
        return lo;
    }

    int findRight(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (hi < 0 || nums[hi] != target) {
            return -1;
        }
        return hi;
    }

}
