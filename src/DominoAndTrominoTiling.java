/*
    Link: https://leetcode.com/problems/domino-and-tromino-tiling
    Algorithm: DP
 */
public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int mod = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }
        return dp[n];
    }
}
