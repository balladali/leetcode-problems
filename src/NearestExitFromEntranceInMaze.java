import java.util.LinkedList;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze
    Algorithm: BFS
 */
public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] step = q.poll();
                int i = step[0];
                int j = step[1];
                if (count != 0 && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    return count;
                }
                if (i - 1 >= 0 && maze[i - 1][j] == '.' && !visited[i - 1][j]) {
                    q.offer(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if (i + 1 < maze.length && maze[i + 1][j] == '.' && !visited[i + 1][j]) {
                    q.offer(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if (j - 1 >= 0 && maze[i][j - 1] == '.' && !visited[i][j - 1]) {
                    q.offer(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
                if (j + 1 < maze[0].length && maze[i][j + 1] == '.' && !visited[i][j + 1]) {
                    q.offer(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
            }
            count++;
        }
        return -1;
    }
}
