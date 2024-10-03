/*
    Link: https://leetcode.com/problems/find-the-highest-altitude
    Algorithm: Prefix Sum
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for (int j: gain) {
            current += j;
            max = Math.max(current, max);
        }
        return max;
    }
}
