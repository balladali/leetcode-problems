import java.util.Stack;

/*
    Link: https://leetcode.com/problems/daily-temperatures
    Algorithm: Monotonic Stack
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                ans[i] = s.peek() - i;
            }
            s.push(i);
        }
        return ans;
    }
}
