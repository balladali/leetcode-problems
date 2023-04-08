import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/01-matrix
    Algorithm: BFS, DP
 */
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] elem = queue.poll();
            int i = elem[0];
            int j = elem[1];
            int matElem = mat[i][j];
            check(mat, i, j + 1, queue, matElem);
            check(mat, i, j - 1, queue, matElem);
            check(mat, i + 1, j, queue, matElem);
            check(mat, i - 1, j, queue, matElem);
        }
        return mat;
    }

    private void check(int[][] mat, int i, int j, LinkedList<int[]> queue, int elem) {
        if (i < 0 || i == mat.length || j < 0 || j == mat[0].length || mat[i][j] != -1) {
            return;
        }
        mat[i][j] = elem + 1;
        queue.add(new int[]{i, j});
    }

    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = max;
                int left = max;
                if (mat[i][j] == 0) {
                    continue;
                }
                if (i - 1 >= 0) {
                    top = mat[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = mat[i][j - 1];
                }
                mat[i][j] = Math.min(top, left) + 1;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int bottom = max;
                int right = max;
                if (mat[i][j] == 0) {
                    continue;
                }
                if (i + 1 < m) {
                    bottom = mat[i + 1][j];
                }
                if (j + 1 < n) {
                    right = mat[i][j + 1];
                }
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}
