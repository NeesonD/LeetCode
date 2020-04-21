package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/21 19:27
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
