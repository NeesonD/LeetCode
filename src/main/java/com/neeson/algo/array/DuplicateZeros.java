package com.neeson.algo.array;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/18 19:55
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int a = arr.length - 1; a > i ; a--) {
                    if (a == i + 1) {
                        arr[a] = 0;
                    }
                    arr[a] = arr[a - 1];
                }
                i++;
            }
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        new DuplicateZeros().duplicateZeros(new int[]{ 1,0,2,3,0,4,5,0});
    }

}
