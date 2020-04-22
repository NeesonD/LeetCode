package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * Create on 2020-04-22
 *
 * @author Administrator
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversal;
        if (fast != null) {
             reversal = reversal(slow.next);
        } else {
             reversal = reversal(slow);
        }
        while (reversal != null) {
            if (head.val != reversal.val) {
                return false;
            }
            head = head.next;
            reversal = reversal.next;
        }
        return true;
    }

    private ListNode reversal(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode reversal = reversal(head.next);
        head.next.next = head;
        head.next = null;
        return reversal;
    }

}
