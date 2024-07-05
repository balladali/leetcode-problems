/*
    Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points
 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int last = -1;
        int first = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        ListNode previous = null;
        int i = 0;
        while (head != null) {
            if (isCritical(previous, head)) {
                if (last != -1) {
                    minDistance = Math.min(minDistance, i - last);
                }
                last = i;
                first = Math.min(first, i);
            }
            i++;
            previous = head;
            head = head.next;
        }
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance, last - first};
    }

    private boolean isCritical(ListNode previous, ListNode current) {
        return previous != null && current.next != null && ((current.val < previous.val
                && current.val < current.next.val) || (current.val > previous.val
                && current.val > current.next.val));
    }
}
