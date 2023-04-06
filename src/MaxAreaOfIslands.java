/*
    Link: https://leetcode.com/problems/max-area-of-island
    Algorithm: Depth First Search, Breadth First Search
 */
public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        int count = 0;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return count;
        }
        grid[i][j] = 0;
        count++;
        return count + dfs(i - 1, j, grid) +  dfs(i + 1, j, grid) + dfs(i, j - 1, grid) + dfs(i, j + 1, grid);
    }
}
