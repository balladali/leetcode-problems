/*
    Link: https://leetcode.com/problems/teemo-attacking
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        int currentEnd = 0;
        for (int t: timeSeries) {
            if (currentEnd > t) {
                count += t + duration - currentEnd;
            } else {
                count += duration;
            }
            currentEnd = t + duration;
        }
        return count;
    }
}
