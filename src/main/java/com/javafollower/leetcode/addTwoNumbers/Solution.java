package com.javafollower.leetcode.addTwoNumbers;

/**
 * 链表做带进位加法
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)  两个已知链表对象ListNode l1, ListNode l2
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);

        ListNode p = l1, q = l2, curr = listNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return listNode.next;
    }

    private static ListNode getListNode(int a, int b, int c) {
        ListNode listNode = new ListNode(a);
        listNode.next = new ListNode(b);
        listNode.next.next = new ListNode(c);
        return listNode;
    }

    public static void main(String[] args) {
        ListNode l1 = getListNode(3, 5, 7);
        ListNode l2 = getListNode(2, 4, 6);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.val);
            result = result.next;
        }
        System.out.println(stringBuilder.toString());
    }
}
