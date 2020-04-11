package com.neeson.algo.recursion;

import com.neeson.algo.tree.TreeNode;

/**
 * Create on 2020-04-11
 *
 * @author Administrator
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean validBST = isValidBST(root.left);
        boolean validBST1 = isValidBST(root.right);
        TreeNode maxNode = findMaxNode(root.left);
        TreeNode minNode = findMinNode(root.right);
        return validBST && validBST1 && maxNode.val < root.val && minNode.val > root.val;
    }

    TreeNode findMaxNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    TreeNode findMinNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
