/*
    Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list
    Algorithm: Two pointers
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        while (true) {
            ListNode p = node;
            int count = n;
            while (count != 0) {
                p = p.next;
                count--;
            }
            if (p == null) {
                return head.next;
            }
            if (p.next == null) {
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }
    }
}
