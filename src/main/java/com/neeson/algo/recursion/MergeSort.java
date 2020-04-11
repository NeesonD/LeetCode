package com.neeson.algo.recursion;

import java.util.logging.Level;

/**
 * Create on 2020-04-11
 *
 * @author Administrator
 */
public class MergeSort {

    private int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums,0,nums.length -1);
        return nums;
    }

    void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(nums,lo,mid);
        mergeSort(nums,mid+1,hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            tmp[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // 左边用尽
                nums[k] = tmp[j++];
            } else if (j > hi) {
                // 右边用尽
                nums[k] = tmp[i++];
            } else if (tmp[j] < tmp[i]) {
                nums[k] = tmp[j++];
            } else {
                nums[k] = tmp[i++];
            }
        }
    }

}
