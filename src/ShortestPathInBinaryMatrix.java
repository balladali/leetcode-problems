import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/shortest-path-in-binary-matrix
    Algorithm: BFS
 */
public class ShortestPathInBinaryMatrix {
    public class Step {
        int x;
        int y;
        int steps;

        public Step(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        LinkedList<Step> queue = new LinkedList<>();
        queue.add(new Step(0, 0, 1));
        while (!queue.isEmpty()) {
            Step current = queue.poll();
            int x = current.x;
            int y = current.y;
            if (x == n - 1 && y == n - 1) {
                return current.steps;
            }
            for (int i = 0; i < 8; i++) {
                int newX = x + moves[i][0];
                int newY = y + moves[i][1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    queue.add(new Step(newX, newY, current.steps + 1));
                    grid[newX][newY] = 1;
                }
            }
        }
        return -1;
    }
}
