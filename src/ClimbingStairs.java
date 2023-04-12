/*
    Link: https://leetcode.com/problems/climbing-stairs
    Algorithm: Dynamic programming, memoization
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
}
