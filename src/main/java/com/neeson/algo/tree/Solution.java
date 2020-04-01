package com.neeson.algo.tree;


/**
 * @author daile
 * @version 1.0
 * @date 2020/4/1 21:32
 */
public class Solution {

    /**
     * 求最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 判断是否是对称的
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * 求路径和是不是某个值
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum2(root, sum);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        int tmpSum = sum - root.val;
        return hasPathSum(root.left, tmpSum) || hasPathSum(root.right, tmpSum);
    }
}

