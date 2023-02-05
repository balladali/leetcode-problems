/*
    Link: https://leetcode.com/problems/add-two-numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int add = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int val = l1Val + l2Val + add;
            add = val / 10;
            val %= 10;
            ListNode node = new ListNode(val);
            if (current == null) {
                current = node;
                result = node;
            } else {
                current.next = node;
                current = current.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (add != 0) {
            current.next = new ListNode(1);
        }
        return result;
    }
}
