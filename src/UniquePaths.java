/*
    Link: https://leetcode.com/problems/unique-paths
    Algorithm: DP, memoization
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        return uniquePathsHelper(m - 1, n - 1, mem);
    }

    public int uniquePathsHelper(int m, int n, int[][] mem) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        if (mem[m][n] > 0) {
            return mem[m][n];
        }
        mem[m][n] = uniquePathsHelper(m - 1, n, mem) + uniquePathsHelper(m, n - 1, mem);
        return mem[m][n];
    }

    //-------------------- DP ----------------------

    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
