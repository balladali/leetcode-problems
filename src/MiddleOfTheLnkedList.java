/*
    Link: https://leetcode.com/problems/middle-of-the-linked-list
    Algorithm: Two pointers
 */
public class MiddleOfTheLnkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next != null ? slow.next : slow;
    }
}
