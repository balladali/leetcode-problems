import java.util.Deque;
import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/sliding-window-maximum
    Algorithm: Deque, Sliding Window
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!d.isEmpty() && d.peek() < i - k + 1) {
                d.poll();
            }
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }
            d.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[d.peek()];
            }
        }
        return result;
    }
}
