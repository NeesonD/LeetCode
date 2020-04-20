package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/20 20:45
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length -1];
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[arr.length -1] = arr[i];
            arr[i] = max;
            max = Math.max(max, arr[arr.length -1]);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

}
