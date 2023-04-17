/*
    Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
    Algorithm: Two Pointers
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fake = new ListNode();
        fake.next = head;
        ListNode prev = fake;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (prev.next == current) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return fake.next;
    }
}
