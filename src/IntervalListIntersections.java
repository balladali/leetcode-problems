import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/interval-list-intersections
    Algorithm: Two Pointers
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            int left = Math.max(first[0], second[0]);
            int right = Math.min(first[1], second[1]);
            if (right >= left) {
                result.add(new int[] {left, right});
            }
            if (right == first[1]) {
                i++;
            }
            if (right == second[1]) {
                j++;
            }
        }
        return result.toArray(new int[0][0]);
    }
}
