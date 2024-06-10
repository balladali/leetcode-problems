import java.util.Arrays;
/*
    Link: https://leetcode.com/problems/height-checker
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = heights[i];
        }
        Arrays.sort(sorted);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != sorted[i]) {
                result++;
            }
        }
        return result;
    }
}
