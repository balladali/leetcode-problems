import java.util.LinkedList;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/rotting-oranges
    Algorithm: BFS
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 2;
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] elem = queue.poll();
            int i = elem[0];
            int j = elem[1];
            int t = elem[2];
            time = Math.max(time, t);
            check(grid, i, j + 1, queue, visited, t);
            check(grid, i, j - 1, queue, visited, t);
            check(grid, i + 1, j, queue, visited, t);
            check(grid, i - 1, j, queue, visited, t);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 2) {
                    return -1;
                }
            }
        }
        return time;
    }

    private void check(int[][] grid, int i, int j, LinkedList<int[]> queue, int[][] visited, int t) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1 || visited[i][j] == 2) {
            return;
        }
        visited[i][j] = 2;
        queue.add(new int[]{i, j, t + 1});
    }

    //---------------------- BFS ----------------------------

    public int orangesRotting2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int minutes = -1;
        while (!q.isEmpty()) {
            minutes++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.offer(new int[]{i - 1, j});
                }
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.offer(new int[]{i + 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.offer(new int[]{i, j - 1});
                }
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.offer(new int[]{i, j + 1});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes == -1 ? 0 : minutes;
    }
}
