import java.util.LinkedList;

public class RottingOranges {
//    public static void main(String[] args) {
//        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
//    }
//    public static int orangesRotting(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int minMins = Integer.MAX_VALUE;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 2) {
//                    LinkedList<int[]> queue = new LinkedList<>();
//                    queue.add(new int[]{i, j});
//                    minMins = Math.min(minMins, getDays(grid.clone(), queue));
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    return -1;
//                }
//            }
//        }
//        return minMins;
//    }
//
//    private static int getDays(int[][] grid, LinkedList<int[]> queue) {
//        int mins = 0;
//        while (!queue.isEmpty()) {
//            int[] elem = queue.poll();
//            int i = elem[0];
//            int j = elem[1];
//            int size = queue.size();
//            check(grid, i, j + 1, queue);
//            check(grid, i, j - 1, queue);
//            check(grid, i + 1, j, queue);
//            check(grid, i - 1, j, queue);
//            if (queue.size() > size) {
//                mins++;
//            }
//        }
//        return mins;
//    }
//
//    private static void check(int[][] grid, int i, int j, LinkedList<int[]> queue) {
//        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
//            return;
//        }
//        grid[i][j] = 2;
//        queue.add(new int[]{i, j});
//    }
}
