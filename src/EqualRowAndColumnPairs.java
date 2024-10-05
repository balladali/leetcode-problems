import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/equal-row-and-column-pairs
 */
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            String arrStr = Arrays.toString(row);
            map.put(arrStr, map.getOrDefault(arrStr, 0) + 1);
        }

        int[] tmp = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                tmp[i] = grid[i][j];
            }
            count += map.getOrDefault(Arrays.toString(tmp), 0);
        }
        return count;
    }
}
