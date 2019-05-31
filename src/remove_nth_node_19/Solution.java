package remove_nth_node_19;

import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k = k % size;
        tail.next = head;
        ListNode temp = head;
        for (int i = 0; i < size - k; i++)
            temp = temp.next;

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}