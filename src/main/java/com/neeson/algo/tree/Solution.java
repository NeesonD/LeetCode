package com.neeson.algo.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        return traverse(root, 0, sum);
    }

    public boolean traverse(TreeNode root, int carry, int sum) {
        if (root == null) {
            return false;
        }
        // 这里保证是最末尾的节点
        if (root.left == null && root.right == null) {
            return sum == carry + root.val;
        }
        carry = carry + root.val;
        return traverse(root.left, carry, sum) || traverse(root.right, carry, sum);
    }

    /**
     * 反推树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        // 后置遍历，最末尾是 root 节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // 找到 root 节点在中置中的索引
        int rootIndexInOrder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndexInOrder = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndexInOrder),
                Arrays.copyOfRange(postorder, 0, rootIndexInOrder)
        );

        root.right = buildTree(Arrays.copyOfRange(inorder, rootIndexInOrder + 1, inorder.length),
                Arrays.copyOfRange(postorder, rootIndexInOrder, postorder.length - 1)
        );

        return root;

    }


    /**
     * 反推树
     *
     * @param inorder
     * @param preorder
     * @return
     */
    public TreeNode buildTreeFrom(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);

        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTreeFrom(Arrays.copyOfRange(preorder, 1, rootIndex),
                Arrays.copyOfRange(inorder, 0, rootIndex)
        );

        root.right = buildTreeFrom(Arrays.copyOfRange(preorder, rootIndex, preorder.length),
                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length)
        );
        return root;
    }

    public Node connect(Node root) {
        helper(root, null);
        return root;
    }

    private void helper(Node root, Node next) {
        if (root == null) {
            return;
        }
        root.next = next;
        helper(root.left, root.right);
        if (next == null) {
            helper(root.right, null);
        } else {
            helper(root.right, next.left);
        }
    }

    public Node connect2(Node root) {
        helper2(root, null);
        return root;
    }

    private void helper2(Node current, Node parent) {
        if (current == null) {
            return;
        }
        while (parent != null) {
            if (parent.left != null && parent.left != current) {
                current.next = parent.left;
                break;
            } else if (parent.right != null) {
                current.next = parent.right;
                break;
            } else {
                parent = parent.next;
            }
        }

        helper2(current.left, current);
        helper2(current.right, current.next);
    }

    private TreeNode result;

    /**
     * Lowest Common Ancestor of a Binary Tree
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private boolean helper(TreeNode curr, TreeNode p, TreeNode q) {

        if (curr == null) {
            return false;
        }

        int left = helper(curr.left, p, q) ? 1 : 0;
        int right = helper(curr.right, p, q) ? 1 : 0;

        int i = (curr.val == p.val || curr.val == q.val) ? 1 : 0;

        if ((left + right + i) >= 2) {
            result = curr;
        }

        return (left + right + i) > 0;
    }

    /**
     * Unique Binary Search Trees II
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return  new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <=end; i++) {
            List<TreeNode> leftSubTree = generateTrees(start, i - 1);
            List<TreeNode> rightSubTree = generateTrees(i + 1, end);

            for (int j = 0; j < leftSubTree.size(); j++) {
                TreeNode left = leftSubTree.get(j);
                for (int k = 0; k < rightSubTree.size(); k++) {
                    TreeNode right = rightSubTree.get(k);
                    TreeNode now = new TreeNode(i);
                    now.left = left;
                    now.right = right;
                    list.add(now);
                }
            }
        }
        return list;
    }

}

