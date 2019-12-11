package com.javafollower.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。<br>
 *
 * 示例：<br>
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.<br>
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.<br>
 *
 * 说明：<br>
 *      给定的 n 保证是有效的。<br>
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
