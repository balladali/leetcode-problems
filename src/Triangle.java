import java.util.List;

/*
    Link: https://leetcode.com/problems/triangle
    Algorithm: Dynamic programming, memoization
 */
public class Triangle {

    // Space: O(n), Time: O(n^2)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] mem = new int[n + 1];
        for (int level = n - 1; level >= 0; level--) {
            for (int j = 0; j <= level; j++) {
                mem[j] = triangle.get(level).get(j) + Math.min(mem[j], mem[j + 1]);
            }
        }
        return mem[0];
    }

    // Space: O(n^2), Time: O(n^2)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] mem = new int[n + 1][n + 1];
        for (int level = n - 1; level >= 0; level--) {
            for (int j = 0; j <= level; j++) {
                mem[level][j] = triangle.get(level).get(j) + Math.min(mem[level + 1][j], mem[level + 1][j + 1]);
            }
        }
        return mem[0][0];
    }
}
