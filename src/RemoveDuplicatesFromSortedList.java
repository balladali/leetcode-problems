/*
    Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list
    Algorithm: Two Pointers
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            while (next != null && current.val == next.val) {
                next = next.next;
            }
            current.next = next;
            current = current.next;
        }
        return head;
    }
}
