package palindrome_linked_list_234;

import org.junit.Test;

import static merge_sorted_linked_lists_21.Solution.ListNode;
import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        solution.isPalindrome(head);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        solution.isPalindrome(head);
    }
}