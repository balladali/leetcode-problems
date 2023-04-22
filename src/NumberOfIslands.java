import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/number-of-islands
    Algorithm: DFS, BFS
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

    // ---------- BFS -----------

    public int numIslandsBFS(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int k, int l) {
        LinkedList<int[]> queue = new LinkedList<>();
        grid[k][l] = '0';
        queue.add(new int[] {k, l});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                queue.add(new int[]{i + 1, j});
                grid[i + 1][j] = '0';
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                queue.add(new int[]{i - 1, j});
                grid[i - 1][j] = '0';
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                queue.add(new int[]{i, j + 1});
                grid[i][j + 1] = '0';
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                queue.add(new int[]{i, j - 1});
                grid[i][j - 1] = '0';
            }
        }
    }
}
