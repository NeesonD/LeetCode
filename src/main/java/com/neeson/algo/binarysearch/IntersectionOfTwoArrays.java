package com.neeson.algo.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create on 2020-04-11
 *
 * @author Administrator
 */
public class IntersectionOfTwoArrays {

    private Set<Integer> result = new HashSet<>();

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            boolean b = inArray(nums1, nums2[i]);
            if (b) {
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean inArray(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        new IntersectionOfTwoArrays().intersection(ints, nums2);
    }



}
