package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/18 20:38
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int var1 = m - 1;
        int var2 = n - 1;
        while (true) {
            if (var2 == -1) {
                break;
            } else if (var1 == 0) {
                nums1[var2] = nums2[var2--];
            } else if (nums1[var1] > nums2[var2]) {
                nums1[var1 + var2 + 1] = nums1[var1--];
            } else {
                nums1[var1 + var2 + 1] = nums2[var2--];
            }
        }

    }

}
