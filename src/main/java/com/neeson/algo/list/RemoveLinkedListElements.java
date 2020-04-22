package com.neeson.algo.list;

import com.neeson.algo.recursion.ListNode;

/**
 * Create on 2020-04-22
 *
 * @author Administrator
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        helper(head,val);
        while (head != null) {
            if (head.val != val) {
                break;
            } else {
                ListNode next = head.next;
                head.next = null;
                head = next;
            }
        }
        return head;
    }

    public void helper(ListNode pred, int val) {
        if (pred == null || pred.next == null) {
            return ;
        }
        if (pred.next.val == val) {
            ListNode del = pred.next;
            pred.next = pred.next.next;
            del.next = null;
            helper(pred, val);
        } else {
            helper(pred.next, val);
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new RemoveLinkedListElements().removeElements(listNode,1);
    }

}
