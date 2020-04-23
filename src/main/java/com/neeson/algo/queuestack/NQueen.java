package com.neeson.algo.queuestack;

import java.util.LinkedList;
import java.util.List;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 * TODO
 */
public class NQueen {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> solveQueens(int n) {
        LinkedList<Integer> track = new LinkedList<>();
        return res;
    }

    void backTrack(LinkedList<Integer> track, int n) {
        if (track.size() == n) {
            res.add(track);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.add(i);
            backTrack(track, n);
            track.removeLast();
        }
    }

}
