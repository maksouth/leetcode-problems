package merge_sorted_linked_lists_21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (l1 != null && l2!= null)
            if (l1.val < l2.val) {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }

        if (l1 != null) dummy.next = l1;
        if (l2 != null) dummy.next = l2;

        return head.next;
    }
    
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}