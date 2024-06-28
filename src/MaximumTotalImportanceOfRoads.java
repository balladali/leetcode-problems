import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/maximum-total-importance-of-roads
 */
public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for (int[] road: roads) {
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Arrays.sort(freq);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) (i + 1) * freq[i];
        }
        return result;
    }
}
