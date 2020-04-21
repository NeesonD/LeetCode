package com.neeson.algo.array;

/**
 * Create on 2020-04-21
 *
 * @author Administrator
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        int fNum = Integer.MIN_VALUE;
        for (int num : nums) {
            fNum = Math.max(fNum, num);
        }

        int sNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == fNum) {
                continue;
            }
            sNum = Math.max(sNum, num);
        }
        if (sNum == Integer.MIN_VALUE) {
            return fNum;
        }

        long tSum = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == fNum || num == sNum) {
                continue;
            }
            tSum = Math.max(tSum, num);
        }
        if (tSum == Long.MIN_VALUE) {
            return fNum;
        }
        return (int) tSum;
    }

    public static void main(String[] args) {
        int i = new ThirdMaximumNumber().thirdMax(new int[]{1, 2, -2147483648});
    }

}
