package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * Create on 2020-04-22
 *
 * @author Administrator
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        if (tmp1 == null || tmp2 == null) {
            return null;
        }
        while (tmp1 != tmp2) {
            if (tmp1.next == null && tmp2.next == null) {
                return null;
            }
            tmp1 = tmp1.next != null ? tmp1.next:headB;
            tmp2 = tmp2.next != null ? tmp2.next:headA;
        }
        return tmp1;
    }

}
