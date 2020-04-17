package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/17 22:07
 */
public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (isEvenNum(num)) {
                res++;
            }
        }
        return res;
    }

    private boolean isEvenNum(int num) {
        return (10 <= num && num < 100) || ( 1000<=num && num < 10000) || num == 100000;
    }

}
