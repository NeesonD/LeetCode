package com.neeson.algo.queuestack;

import com.neeson.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/25 13:32
 */
public class BinaryTreeInorderTraversal {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

}
