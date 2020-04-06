package com.neeson.algo.recursion;

import com.neeson.algo.tree.TreeNode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/5 19:32
 */
public class Solution {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int lo = 0;
        int hi = s.length - 1;
        reverseString(s, lo, hi);
    }

    void reverseString(char[] s, int lo, int hi) {
        if (lo == hi || lo == hi + 1) {
            return;
        }
        swap(s, lo, hi);
        reverseString(s, lo + 1, hi - 1);
    }

    private void swap(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = head;
        head = tmp;
        swap(head.next, head.next.next);
        return head;
    }

    void swap(ListNode pred, ListNode current) {
        if (current == null || current.next == null) {
            return;
        }
        ListNode tmp = current.next;
        current.next = current.next.next;
        tmp.next = current;
        current = tmp;
        pred.next = current;
        swap(current.next, current.next.next);
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 二叉树查找
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode result;
        if (root.val > val) {
            result = searchBST(root.left, val);
        } else {
            result = searchBST(root.right, val);
        }
        return result;
    }

    /**
     * Fibonacci Number
     *
     * @param N
     * @return
     */
    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int fib(int N) {
        if (Objects.nonNull(cache.get(N))) {
            return cache.get(N);
        }
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int i = fib(N - 1) + fib(N - 2);
        cache.put(N, i);
        return i;
    }

    /**
     * 爬楼梯
     *
     * @param N
     * @return
     */
    public int climbStairs(int N) {
        if (Objects.nonNull(cache.get(N))) {
            return cache.get(N);
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        int i = fib(N - 1) + fib(N - 2);
        cache.put(N, i);
        return i;
    }

    /**
     * x 的 -50 次方 = 1/x 的 50 次方
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return x * myPow(x, n - 1);
            }
        } else {
            if (n < Integer.MIN_VALUE + 1) {
                return (1 / x) * myPow(1 / x, -(n + 1));
            } else {
                return myPow(1 / x, -n);
            }
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        if (K % 2 != 0) {
            return kthGrammar(N - 1, (K + 1) / 2);
        } else {
            int pred = kthGrammar(N - 1, (K + 1) / 2);
            if (pred == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }


}
