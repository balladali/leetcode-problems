import java.util.*;

/*
    Link: https://leetcode.com/problems/ipo
 */
public class Ipo {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i = 0; i < profits.length; i++) {
            pqCap.add(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= w) {
                pqPro.add(pqCap.poll());
            }
            if (pqPro.isEmpty()) {
                break;
            }
            w += pqPro.poll()[1];
        }
        return w;
    }

    // -----------------------

    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        List<int[]> projects = new ArrayList<>();
        PriorityQueue<Integer> pqPro = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < profits.length; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        projects.sort(Comparator.comparingInt(x -> x[0]));
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < profits.length && projects.get(j)[0] <= w) {
                pqPro.add(projects.get(j)[1]);
                j++;
            }
            if (pqPro.isEmpty()) {
                break;
            }
            w += pqPro.poll();
        }
        return w;
    }
}
