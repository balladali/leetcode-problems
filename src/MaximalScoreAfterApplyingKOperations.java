import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/maximal-score-after-applying-k-operations
    Algorithm: Priority Queue
 */
public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        Queue<Long> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num: nums) {
            q.offer((long) num);
        }
        long score = 0;
        while (k > 0) {
            long cur = q.poll();
            score += cur;
            long newCur = cur / 3;
            if (cur % 3 > 0) {
                newCur++;
            }
            q.offer(newCur);
            k--;
        }
        return score;
    }
}
