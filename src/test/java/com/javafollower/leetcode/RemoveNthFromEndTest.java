package com.javafollower.leetcode;

import com.javafollower.leetcode.RemoveNthFromEnd.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class RemoveNthFromEndTest {

    private RemoveNthFromEnd solution = new RemoveNthFromEnd();

    @Test
    public void testRemoveNthFromEnd_true() {
        int[] paramArray = new int[]{1, 2, 3, 4, 5};
        ListNode head = createListNode(paramArray);

        int[] resultArray = new int[]{1, 2, 3, 5};
        ListNode expectedListNode = createListNode(resultArray);
        Assert.assertTrue(equalsListNode(expectedListNode, solution.removeNthFromEnd(head, 2)));
    }

    @Test
    public void testRemoveNthFromEnd_false() {
        int[] paramArray = new int[]{1, 2, 3, 4, 5};
        ListNode head = createListNode(paramArray);

        int[] resultArray = new int[]{1, 2, 3, 5, 6};
        ListNode expectedListNode = createListNode(resultArray);
        Assert.assertFalse(equalsListNode(expectedListNode, solution.removeNthFromEnd(head, 2)));
    }

    private boolean equalsListNode(ListNode expect, ListNode result) {
        while (expect != null && result != null) {
            if (expect.val != result.val) {
                return false;
            }
            expect = expect.next;
            result = result.next;
        }
        return expect == null && result == null;
    }

    private ListNode createListNode(int[] input) {
        ListNode head = new ListNode(0);
        ListNode first = head;
        for (int i : input) {
            first.next = new ListNode(i);
            first = first.next;
        }
        return head.next;
    }
}