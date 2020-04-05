package com.neeson.algo.recursion;

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



}
