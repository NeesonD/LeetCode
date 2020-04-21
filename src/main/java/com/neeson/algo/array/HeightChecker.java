package com.neeson.algo.array;

/**
 * Create on 2020-04-21
 *
 * @author Administrator
 */
public class HeightChecker {

    /**
     * 桶排序
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] tmp = new int[101];
        for (int height : heights) {
            tmp[height]++;
        }
        int count = 0;
        int idx = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i]-- > 0 ) {
                if (heights[idx++] != i) {
                    count++;
                }
            }
        }
        return count;
    }

}
