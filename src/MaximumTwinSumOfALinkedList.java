/*
    Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 */
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        int max = 0;
        while (secondHalf != null) {
            max = Math.max(firstHalf.val + secondHalf.val, max);
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return max;
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            result = new ListNode(head.val, result);
            head = head.next;
        }
        return result;
    }
}
