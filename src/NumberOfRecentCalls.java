import java.util.LinkedList;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/number-of-recent-calls
    Algorithm: Queue
 */
public class NumberOfRecentCalls {

    // with Queue
    class RecentCounter {
        private Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            while (!q.isEmpty() && t - q.peek() > 3000) {
                q.poll();
            }
            q.offer(t);
            return q.size();
        }
    }

    // with no Queue
    class RecentCounterNoQueue {
        int[] calls = new int[10000];
        int start;
        int end;

        public RecentCounterNoQueue() {
            start = 0;
            end = 0;
        }

        public int ping(int t) {
            while (start < end && t - calls[start] > 3000) {
                start++;
            }
            calls[end++] = t;
            return end - start;
        }
    }
}
