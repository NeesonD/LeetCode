package com.neeson.algo.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/10 19:15
 */
public class FindKClosestElements {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x < arr[0]) {
            int[] ints = Arrays.copyOfRange(arr, 0, k);
            for (int anInt : ints) {
                result.add(anInt);
            }
            return result;
        } else if (x > arr[arr.length - 1]) {
            int[] ints = Arrays.copyOfRange(arr, arr.length - k, arr.length);
            for (int anInt : ints) {
                result.add(anInt);
            }
            return result;
        }
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++) result.add(arr[i]);
        return result;
    }



    private int findLeft(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1, mid;

        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
