package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * Create on 2020-04-22
 *
 * @author Administrator
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp1 = head;
        ListNode tmp2 = head.next;
        ListNode tmp1Tail = tmp1;
        int index = 2;
        ListNode tmp3 = head.next.next;
        while (tmp3 != null) {
            if (index % 2 == 0) {
                tmp1.next = tmp3;
                tmp1 = tmp3;
                tmp1Tail = tmp3;
            } else {
                tmp2.next = tmp3;
            }
            tmp3 = tmp3.next;
            index++;
        }
        tmp1Tail.next = tmp2;
        return tmp1;
    }

}
