package com.neeson.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/19 10:21
 */
public class CheckIfNAndItsDoubleExist {

    Map<Integer, Integer> tmp = new HashMap();

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ( (arr[i] % 2 == 0 && tmp.get(arr[i] / 2) != null) || tmp.get(arr[i] * 2) != null) {
                return true;
            }
            tmp.put(arr[i], i);
        }
        return false;
    }

}
