/*
    Link: https://leetcode.com/problems/unique-paths-ii
    Algorithm: DP, memoization
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] mem = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        return uniquePathsWithObstaclesHelper(m - 1, n - 1, obstacleGrid, mem, visited);
    }

    private int uniquePathsWithObstaclesHelper(int m, int n, int[][] obstacleGrid, int[][] mem, boolean[][] visited) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (obstacleGrid[m][n] == 1) {
            visited[m][n] = true;
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (visited[m][n]) {
            return mem[m][n];
        }
        mem[m][n] = uniquePathsWithObstaclesHelper(m - 1, n, obstacleGrid, mem, visited) + uniquePathsWithObstaclesHelper(m, n - 1, obstacleGrid, mem, visited);
        visited[m][n] = true;
        return mem[m][n];
    }
}
