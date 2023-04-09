/*
    Link: https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        merge(list1, list2, result);
        return result.next;
    }

    private void merge(ListNode list1, ListNode list2, ListNode result) {
        if (list1 == null && list2 == null) {
            return;
        }
        if (list1 == null) {
            result.next = list2;
            return;
        }
        if (list2 == null) {
            result.next = list1;
            return;
        }
        if (list1.val <= list2.val) {
            result.next = list1;
            merge(list1.next, list2, result.next);
        } else {
            result.next = list2;
            merge(list1, list2.next, result.next);
        }
    }
}
