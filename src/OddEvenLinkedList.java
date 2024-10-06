/*
    Link: https://leetcode.com/problems/odd-even-linked-list
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        int count = 0;
        while (last.next != null) {
            last = last.next;
            count++;
        }
        ListNode node = head;
        while (count > 0) {
            last.next = new ListNode(node.next.val);
            last = last.next;
            node.next = node.next.next;
            node = node.next;
            count -= 2;
        }
        return head;
    }
}
