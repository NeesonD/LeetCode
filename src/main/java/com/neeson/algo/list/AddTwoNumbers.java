package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * Create on 2020-04-22
 *
 * @author Administrator
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int i = l1.val + l2.val;
        ListNode res = new ListNode(i);
        res.next = addTwoNumbers(l1.next, l2.next);
        return res;
    }

}
