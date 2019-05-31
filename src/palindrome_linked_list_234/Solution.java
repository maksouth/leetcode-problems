package palindrome_linked_list_234;

import static merge_sorted_linked_lists_21.Solution.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        int size = size(head);
        ListNode reverted = revert(head, size);
        for (int i = 0; i < size; i++) {
            if (reverted.val != head.val) return false;
            reverted = reverted.next;
            head = head.next;
        }

        return true;
    }

    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private ListNode revert(ListNode head, int size) {

        ListNode reverted = null;

        ListNode previous;
        for (int i = 0; i < size; i++) {
            previous = reverted;
            reverted = head;
            reverted.next = previous;
            head = head.next;
        }

        return reverted;
    }
}
