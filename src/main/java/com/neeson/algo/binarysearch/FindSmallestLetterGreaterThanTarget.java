package com.neeson.algo.binarysearch;

/**
 * Create on 2020-04-11
 *
 * @author Administrator
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (letters[mid] == target) {
                lo = mid + 1;
            } else if (letters[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == letters.length) {
            return letters[0];
        }
        return letters[lo];
    }

}
