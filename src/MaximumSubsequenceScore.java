import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/maximum-subsequence-score
    Algorithm: Sorting, Priority Queue
 */
public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] merged = new int[n][2];
        for (int i = 0; i < n; i++) {
            merged[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(merged, (a, b) -> b[1] - a[1]);
        long sum = 0;
        long max = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for (int[] a: merged) {
            q.offer(a[0]);
            sum += a[0];
            if (q.size() > k) {
                sum -= q.poll();
            }
            if (q.size() == k) {
                max = Math.max(max, sum * a[1]);
            }
        }
        return max;
    }
}
