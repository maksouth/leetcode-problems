package remove_linked_list_elements_203;

import static merge_sorted_linked_lists_21.Solution.ListNode;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if (head == null) return null;

        ListNode pointer = head;

        while (pointer.next != null)
            if (pointer.next.val == val)
                pointer.next = pointer.next.next;
            else pointer = pointer.next;

        return head;
    }
}