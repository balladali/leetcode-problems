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
}
