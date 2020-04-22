package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * Create on 2020-04-22
 *
 * @author Administrator
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode tmp0 = head;
        while (tmp0 != null) {
            tmp0 = tmp0.next;
            size++;
        }

        if (n == size) {
            ListNode res = head.next;
            head.next = null;
            return res;
        }

        int index = 1;
        ListNode tmp = head;

        while (tmp != null) {
            if (index == size - n) {
                ListNode delIdx = tmp.next;
                tmp.next = tmp.next.next;
                delIdx.next = null;
                return head;
            } else {
                tmp = tmp.next;
            }
            index++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new RemoveNthNodeFromEndOfList().removeNthFromEnd(listNode, 2);
    }

}
