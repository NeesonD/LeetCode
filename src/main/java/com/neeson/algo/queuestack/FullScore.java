package com.neeson.algo.queuestack;

import java.util.LinkedList;
import java.util.List;

/**
 * Create on 2020-04-23
 *
 * @author Administrator
 */
public class FullScore {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 遍历完了
        if (track.size() == nums.length) {
            res.add(track);
            return;
        }
        for (int num : nums) {
            // 排除不合法选择
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

}
