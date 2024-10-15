import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
    Algorithm: Sorting
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        int count = points.length;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            if (current[0] <= end) {
                count--;
            } else {
                end = current[1];
            }
        }
        return count;
    }
}
