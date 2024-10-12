import java.util.PriorityQueue;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/total-cost-to-hire-k-workers
    Algorithm: Priority Queue
 */
public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int l = 0;
        int r = costs.length - 1;
        long sum = 0;
        Queue<Integer> qLeft = new PriorityQueue<>();
        Queue<Integer> qRight = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            while (qLeft.size() < candidates && l <= r) {
                qLeft.offer(costs[l++]);
            }
            while (qRight.size() < candidates && l <= r) {
                qRight.offer(costs[r--]);
            }
            int leftMin = qLeft.isEmpty() ? Integer.MAX_VALUE : qLeft.peek();
            int rightMin = qRight.isEmpty() ? Integer.MAX_VALUE : qRight.peek();
            if (leftMin <= rightMin) {
                sum += leftMin;
                qLeft.poll();
            } else {
                sum += rightMin;
                qRight.poll();
            }
        }
        return sum;
    }
}
