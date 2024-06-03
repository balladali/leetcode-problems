/*
    Link: https://leetcode.com/problems/unique-paths-iii
    Algorithm: Backtracking
 */
public class UniquePaths3 {
    int result = 0;
    public int uniquePathsIII(int[][] grid) {
        int empty = 0;
        int sI = 0;
        int sJ = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                }
                if (grid[i][j] == 1) {
                    sI = i;
                    sJ = j;
                }
            }
        }
        dfs(sI, sJ, grid, empty);
        return result;
    }

    private void dfs(int i, int j, int[][] grid, int empty) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < 0) {
            return;
        }
        if (grid[i][j] == 2) {
            if (empty == 0) {
                result++;
            }
            return;
        }
        int tmp = grid[i][j];
        if (grid[i][j] == 0) {
            empty--;
        }
        grid[i][j] = -1;
        dfs(i + 1, j, grid, empty);
        dfs(i - 1, j, grid, empty);
        dfs(i, j + 1, grid, empty);
        dfs(i, j - 1, grid, empty);
        if (tmp == 0) {
            empty++;
        }
        grid[i][j] = tmp;
    }
}
