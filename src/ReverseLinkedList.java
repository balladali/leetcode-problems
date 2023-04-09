/*
    Link: https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public ListNode reverseListIteration(ListNode head) {
        ListNode result = null;
        while (head != null) {
            result = new ListNode(head.val, result);
            head = head.next;
        }
        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
