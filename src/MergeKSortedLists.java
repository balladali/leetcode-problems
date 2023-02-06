import java.util.Comparator;
import java.util.PriorityQueue;

/*
    Link: https://leetcode.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        ListNode result = null;
        ListNode current = null;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.remove();
            if (result == null) {
                result = node;
                current = result;
            } else {
                current.next = node;
                current = current.next;
            }
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return result;
    }
}
