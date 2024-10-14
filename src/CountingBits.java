/*
    Link: https://leetcode.com/problems/counting-bits
    Algorithm: DP, memoization
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = solve(i, result);
        }
        return result;
    }

    private int solve(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n % 2 == 1) {
            memo[n] = 1 + solve(n / 2, memo);
        } else {
            memo[n] = solve(n / 2, memo);
        }
        return memo[n];
    }
}
