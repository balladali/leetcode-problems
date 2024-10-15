import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/non-overlapping-intervals/
    Algorithm: Sorting
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < end) {
                count++;
            } else {
                end = current[1];
            }
        }
        return count;
    }
}
