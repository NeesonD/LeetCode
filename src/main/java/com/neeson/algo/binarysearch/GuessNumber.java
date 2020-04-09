package com.neeson.algo.binarysearch;

/**
 * Create on 2020-04-09
 *
 * @author Administrator
 */
public class GuessNumber {

    public int guessNumber(int n) {
        int left = 1, right = n, mid = 0;

        while (left <= right) {
            mid = left + (right - left)/2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    int guess(int num) {
        if (num == 6) {
            return 0;
        } else if (num > 6) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        new GuessNumber().guessNumber(10);
    }

}
