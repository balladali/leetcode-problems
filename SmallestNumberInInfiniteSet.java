/*
    Link: https://leetcode.com/problems/smallest-number-in-infinite-set
    Algorithm: Priority Queue
 */
public class SmallestNumberInInfiniteSet {
    class SmallestInfiniteSet {
        private PriorityQueue<Integer> q;
        private int current = 1;

        public SmallestInfiniteSet() {
            this.q = new PriorityQueue<>();
            this.current = 1;
        }

        public int popSmallest() {
            int min = current;
            if (!q.isEmpty() && q.peek() < current) {
                min = q.poll();
            } else {
                current++;
            }
            while (!q.isEmpty() && q.peek() == min) {
                q.poll();
            }
            return min;
        }

        public void addBack(int num) {
            q.offer(num);
        }
    }
}
