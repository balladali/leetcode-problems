import java.util.Arrays;
import java.util.PriorityQueue;

/*
    Link: https://leetcode.com/problems/kth-largest-element-in-an-array
    Algorithm: Sorting, Priority Queue
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
